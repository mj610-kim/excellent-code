import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class DatabaseTest {
    private Database db;
    private List<Employee> employeeList = new ArrayList<>();

    @Mock
    Employee mockEmployee1;

    @Mock
    Employee mockEmployee2;


    @Before
    public void setUp() {
        openMocks(this);
        db = new Database();

        when(mockEmployee1.getEmployeeNum()).thenReturn("18050301");
        when(mockEmployee1.getName()).thenReturn("KYUMOK KIM");
        when(mockEmployee1.getCl()).thenReturn("CL2");
        when(mockEmployee1.getPhoneNum()).thenReturn("010-9777-6055");
        when(mockEmployee1.getBirthDayAll()).thenReturn("19980906");
        when(mockEmployee1.getCerti()).thenReturn("PRO");

        when(mockEmployee2.getEmployeeNum()).thenReturn("15123099");
        when(mockEmployee2.getName()).thenReturn("VXIHXOTH JHOP");
        when(mockEmployee2.getCl()).thenReturn("CL3");
        when(mockEmployee2.getPhoneNum()).thenReturn("010-3112-2609");
        when(mockEmployee2.getBirthDayAll()).thenReturn("19771211");
        when(mockEmployee2.getCerti()).thenReturn("ADV");
    }

    @Test
    public void addTest() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void addTest_FailCase() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertNotEquals(1, db.getDatabaseSize());
    }

    @Test
    public void delTest() {
        addTest();

        List<Employee> schResult = db.sch("name", "KYUMOK KIM");
        assertEquals(1, schResult.size());

        assertTrue(db.del(schResult));
        assertEquals(1, db.getDatabaseSize());
    }

    @Test
    public void schTestByEmployeeNum() {
        addTest();

        List<Employee> schResult = db.sch("employeeNum", "18050301");
        System.out.println(schResult);
        assertEquals(1, schResult.size());
        assertEquals("18050301", schResult.get(0).getEmployeeNum());
    }

    @Test
    public void schTestByName() {
        addTest();

        List<Employee> schResult = db.sch("name", "KYUMOK KIM");
        assertEquals(1, schResult.size());

        assertEquals("KYUMOK KIM", schResult.get(0).getName());
    }

    @Test
    public void schTestByCl() {
        addTest();

        List<Employee> schResult = db.sch("cl", "CL2");
        assertEquals(1, schResult.size());

        assertEquals("CL2", schResult.get(0).getCl());
    }

    @Test
    public void schTestByPhoneNum() {
        addTest();

        List<Employee> schResult = db.sch("phoneNum", "010-9777-6055");
        assertEquals(1, schResult.size());

        assertEquals("010-9777-6055", schResult.get(0).getPhoneNum());
    }

    @Test
    public void schTestByBirthDay() {
        addTest();

        List<Employee> schResult = db.sch("birthday", "19980906");
        assertEquals(1, schResult.size());

        assertEquals("19980906", schResult.get(0).getBirthDayAll());
    }

    @Test
    public void schTestByCerti() {
        addTest();

        List<Employee> schResult = db.sch("CERTI", "PRO");
        assertEquals(1, schResult.size());

        assertEquals("PRO", schResult.get(0).getCerti());
    }

    @Test
    public void modTestEmployeeNum() {
        addTest();

        List<Employee> schResult = db.sch("employeeNum", "18050301");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, "employeeNum", "18050301"));
    }

    @Test
    public void modTestName() {
        addTest();

        List<Employee> schResult = db.sch("name", "KYUMOK KIM");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, "name", "KYUMOK LEE"));
    }

    @Test
    public void modTestCl() {
        addTest();

        List<Employee> schResult = db.sch("cl", "CL2");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, "cl", "CL2"));
    }

    @Test
    public void modTestPhoneNum() {
        addTest();

        List<Employee> schResult = db.sch("phoneNum", "010-9777-6055");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, "phoneNum", "010-9777-6055"));
    }

    @Test
    public void modTestBirthDay() {
        addTest();

        List<Employee> schResult = db.sch("birthday", "19980906");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, "birthday", "19980906"));
    }

    @Test
    public void modTestCERTI() {
        addTest();

        List<Employee> schResult = db.sch("CERTI", "PRO");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, "CERTI", "PRO"));
    }
}