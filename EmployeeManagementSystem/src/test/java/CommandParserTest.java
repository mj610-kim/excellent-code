import static org.junit.Assert.*;

import com.cra08.excellentcode.CommandParser;
import com.cra08.excellentcode.option.BirthMonthOption;
import com.cra08.excellentcode.option.EmptyOption;
import com.cra08.excellentcode.option.IOption;
import com.cra08.excellentcode.option.PrintOption;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class CommandParserTest {

    String cmdLine1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
    String cmdLine2 = "DEL, , , ,birthday,19900906";
    String cmdLine3 = "MOD,-p,, ,name,KYUMOK KIM,name,KYUMOK LEE";
    String cmdLine4 = "MOD,-p,-m, ,birthday,09,cl,CL2";
    String invalidCmdLine = "MOE,-p,-m, ,birthday,09,cl,CL2";
    String invalidEmpDataLength = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055";
    String invalidTwoColDataLen = "MOD,-p,, ,name,KYUMOK KIM,name";
    String invalidOneColDataLen = "DEL, , , ,birthday";

    @Test
    public void getCommandTest() {
        assertEquals("ADD", CommandParser.getCommand(cmdLine1));
        assertEquals("DEL", CommandParser.getCommand(cmdLine2));
        assertEquals("MOD", CommandParser.getCommand(cmdLine3));
        assertEquals("MOD", CommandParser.getCommand(cmdLine4));
        assertThrows(IllegalArgumentException.class, () -> CommandParser.getCommand(invalidCmdLine));
    }

    @Test
    public void getEmployeeTest() {
        String birthday = CommandParser.getEmployee(cmdLine1).getBirthDayAll();
        assertEquals("19980906", birthday);
        assertThrows(IllegalArgumentException.class, () -> CommandParser.getEmployee(invalidEmpDataLength));
    }

    @Test
    public void getColumnDataTest() {
        assertEquals("birthday", CommandParser.getColumnData(cmdLine2).get(0));
        assertEquals("19900906", CommandParser.getColumnData(cmdLine2).get(1));

        assertEquals("name", CommandParser.getColumnData(cmdLine3).get(0));
        assertEquals("KYUMOK KIM", CommandParser.getColumnData(cmdLine3).get(1));

        assertEquals("name", CommandParser.getColumnData(cmdLine3).get(2));
        assertEquals("KYUMOK LEE", CommandParser.getColumnData(cmdLine3).get(3));

        assertEquals("birthday", CommandParser.getColumnData(cmdLine4).get(0));
        assertEquals("09", CommandParser.getColumnData(cmdLine4).get(1));

        assertEquals("cl", CommandParser.getColumnData(cmdLine4).get(2));
        assertEquals("CL2", CommandParser.getColumnData(cmdLine4).get(3));

        assertThrows(IllegalArgumentException.class, () -> CommandParser.getColumnData(invalidTwoColDataLen));
        assertThrows(IllegalArgumentException.class, () -> CommandParser.getColumnData(invalidOneColDataLen));
    }

    @Test
    public void getOptionsListTest() {
        assertThrows(IllegalArgumentException.class, () -> CommandParser.getOptionsList(cmdLine1));
        assertEquals(new ArrayList<IOption>(Arrays.asList(EmptyOption.getInstance(), EmptyOption.getInstance(), EmptyOption.getInstance())), CommandParser.getOptionsList(cmdLine2));
        assertEquals(new ArrayList<IOption>(Arrays.asList(PrintOption.getInstance(), EmptyOption.getInstance(), EmptyOption.getInstance())), CommandParser.getOptionsList(cmdLine3));
        assertEquals(new ArrayList<IOption>(Arrays.asList(PrintOption.getInstance(), BirthMonthOption.getInstance("09"), EmptyOption.getInstance())), CommandParser.getOptionsList(cmdLine4));
    }

}

