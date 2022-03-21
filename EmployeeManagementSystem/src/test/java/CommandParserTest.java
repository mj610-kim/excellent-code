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
    String cmdLine = "MOD,-p,-y, ,birthday,1990,name,KYUMOK LEE";

    CommandParser cmdParser = mock(CommandParser.class);
    Employee emp = mock(Employee.class);
    @Before
    public void setUp() {
        openMocks(this);
        when(cmdParser.getCommand()).thenReturn("MOD");
        when(cmdParser.getEmployee()).thenReturn(emp);
        when(emp.getBirthDay()).thenReturn("1990");
        when(emp.getFirstName()).thenReturn("KYUMOK");
        when(emp.getLastName()).thenReturn("LEE");
    }


    @Test
    public void setCommandLineTest(){
        cmdParser.setCommandLine(cmdLine);
        verify(cmdParser,times(1)).setCommandLine(anyString());
    }


    @Test
    public void getCommandTest(){
        String cmd = cmdParser.getCommand();
        assertEquals(cmd, "MOD");
    }

    @Test
    public void getEmployeeTest(){
        String birthday = cmdParser.getEmployee().getBirthDay();
        assertEquals(birthday, "1990");
    }


}
