import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class CommandParserTest {

    String cmdLine1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
    String cmdLine2 = "DEL, , , ,birthday,19900906";
    String cmdLine3 = "MOD,-p,, ,name,KYUMOK KIM,name,KYUMOK LEE";
    String cmdLine4 = "MOD,-p,-m, ,birthday,09,cl,CL2";


    CommandParser cmdParser1 = new CommandParser();
    CommandParser cmdParser2 = new CommandParser();
    CommandParser cmdParser3 = new CommandParser();
    CommandParser cmdParser4 = new CommandParser();

    @Before
    public void setUp() {
        cmdParser1.setCommandLine(cmdLine1);
        cmdParser2.setCommandLine(cmdLine2);
        cmdParser3.setCommandLine(cmdLine3);
        cmdParser4.setCommandLine(cmdLine4);
    }

    @Test
    public void getCommandTest(){
        assertEquals("ADD", cmdParser1.getCommand());
        assertEquals("DEL", cmdParser2.getCommand());
        assertEquals("MOD", cmdParser3.getCommand());
        assertEquals("MOD", cmdParser4.getCommand());

    }

    @Test
    public void getEmployeeTest(){
        String birthday = cmdParser1.getEmployee().getBirthDay();
        assertEquals("19980906", birthday);
    }

    @Test
    public void getColumnDataTest(){
        assertEquals("birthday", cmdParser2.getColumnData().get(0));
        assertEquals("19900906", cmdParser2.getColumnData().get(1));

        assertEquals("name", cmdParser3.getColumnData().get(0));
        assertEquals("KYUMOK KIM", cmdParser3.getColumnData().get(1));

        assertEquals("name", cmdParser3.getColumnData().get(2));
        assertEquals("KYUMOK LEE", cmdParser3.getColumnData().get(3));

        assertEquals("birthday", cmdParser4.getColumnData().get(0));
        assertEquals("09", cmdParser4.getColumnData().get(1));

        assertEquals("cl", cmdParser4.getColumnData().get(2));
        assertEquals("CL2", cmdParser4.getColumnData().get(3));
    }

    @Test
    public void getOptionTest(){
        assertEquals("-p", cmdParser3.getOption().get(0));
        assertEquals("-m", cmdParser4.getOption().get(1));

    }

}

