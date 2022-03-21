import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class CommandParserTest {
    String[] cmdLines = new String[]{
            "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO",
            "DEL, , , ,birthday,19900906",
            "MOD, , , ,name,KYUMOK KIM,name,KYUMOK LEE"
    };

    CommandParser cmdParser = new CommandParser();

    String cmdLine =  "DEL, , , ,birthday,19900906";
    CommandParser cmdParser = new CommandParser();

    @Before
    public void setUp() {
        cmdParser.setCommandLine(cmdLine);
    }

    @Test
    public void getCommandTest(){
        String cmd = cmdParser.getCommand();
        assertEquals("ADD", cmd);
    }

    @Test
    public void getEmployeeTest(){
        String birthday = cmdParser.getEmployee().getBirthDay();
        assertEquals("19980906", birthday);
    }


}
