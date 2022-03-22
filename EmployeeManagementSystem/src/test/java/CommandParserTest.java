import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import com.cra08.excellentcode.CommandParser;
import com.cra08.excellentcode.Employee;
import org.junit.Test;
import org.mockito.Mock;

public class CommandParserTest {

    String cmdLine1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
    String cmdLine2 = "DEL, , , ,birthday,19900906";
    String cmdLine3 = "MOD,-p,, ,name,KYUMOK KIM,name,KYUMOK LEE";
    String cmdLine4 = "MOD,-p,-m, ,birthday,09,cl,CL2";
    String invalidCmdLine = "MOE,-p,-m, ,birthday,09,cl,CL2";
    String invalidEmpDataLength = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055";
    String invalidTwoColDataLen = "MOD,-p,, ,name,KYUMOK KIM,name";
    String invalidOneColDataLen = "DEL, , , ,birthday";

    @Mock
    CommandParser cmdParser = mock(CommandParser.class);

    @Test
    public void getCommandTest() {
        assertEquals("ADD", cmdParser.getCommand(cmdLine1));
        assertEquals("DEL", cmdParser.getCommand(cmdLine2));
        assertEquals("MOD", cmdParser.getCommand(cmdLine3));
        assertEquals("MOD", cmdParser.getCommand(cmdLine4));
        assertThrows(IllegalArgumentException.class, () -> cmdParser.getCommand(invalidCmdLine));
    }

    @Test
    public void getEmployeeTest() {
        String birthday = cmdParser.getEmployee(cmdLine1).getBirthDayAll();
        assertEquals("19980906", birthday);
        assertThrows(IllegalArgumentException.class, () -> cmdParser.getEmployee(invalidEmpDataLength));
    }

    @Test
    public void getColumnDataTest() {
        assertEquals("birthday", cmdParser.getColumnData(cmdLine2).get(0));
        assertEquals("19900906", cmdParser.getColumnData(cmdLine2).get(1));

        assertEquals("name", cmdParser.getColumnData(cmdLine3).get(0));
        assertEquals("KYUMOK KIM", cmdParser.getColumnData(cmdLine3).get(1));

        assertEquals("name", cmdParser.getColumnData(cmdLine3).get(2));
        assertEquals("KYUMOK LEE", cmdParser.getColumnData(cmdLine3).get(3));

        assertEquals("birthday", cmdParser.getColumnData(cmdLine4).get(0));
        assertEquals("09", cmdParser.getColumnData(cmdLine4).get(1));

        assertEquals("cl", cmdParser.getColumnData(cmdLine4).get(2));
        assertEquals("CL2", cmdParser.getColumnData(cmdLine4).get(3));

        assertThrows(IllegalArgumentException.class, () -> cmdParser.getColumnData(invalidTwoColDataLen));
        assertThrows(IllegalArgumentException.class, () -> cmdParser.getColumnData(invalidOneColDataLen));
    }

    @Test
    public void getOptionTest() {
        assertEquals("",cmdParser.getOption(cmdLine1).get(0));
        assertNotEquals(" ",cmdParser.getOption(cmdLine1).get(0));
        assertEquals("",cmdParser.getOption(cmdLine1).get(1));
        assertNotEquals(" ",cmdParser.getOption(cmdLine1).get(1));
        assertEquals("",cmdParser.getOption(cmdLine1).get(2));
        assertNotEquals(" ",cmdParser.getOption(cmdLine1).get(2));
        assertEquals("-p", cmdParser.getOption(cmdLine3).get(0));
        assertEquals("-m", cmdParser.getOption(cmdLine4).get(1));

    }

}

