import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class DatabaseTest {
    Database db;

    @Mock
    Employee mockEmployee1;

    @Mock
    Employee mockEmployee2;

    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        openMocks(this);
        db = new Database();

        when(mockEmployee1.getEmployeeNum()).thenReturn("18050301");
        when(mockEmployee1.getName()).thenReturn("KYUMOK KIM");
        when(mockEmployee1.getCERTI()).thenReturn("CL2");
        when(mockEmployee1.getPhoneNum()).thenReturn("010-9777-6055");
        when(mockEmployee1.getBirthDay()).thenReturn("19980906");
        when(mockEmployee1.getCERTI()).thenReturn("PRO");

        when(mockEmployee2.getEmployeeNum()).thenReturn("15123099");
        when(mockEmployee2.getName()).thenReturn("VXIHXOTH JHOP");
        when(mockEmployee2.getCERTI()).thenReturn("CL3");
        when(mockEmployee2.getPhoneNum()).thenReturn("010-3112-2609");
        when(mockEmployee2.getBirthDay()).thenReturn("19771211");
        when(mockEmployee2.getCERTI()).thenReturn("ADV");

        employeeList.add(mockEmployee1);
        employeeList.add(mockEmployee2);
    }

    public void setUpDBData() {
        db.add(employeeList);
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    void addTest() {
        setUpDBData();
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    void delTest() {
        setUpDBData();

        assertTrue(db.del("name", "VXIHXOTH JHOP"));
        assertEquals(1, db.getDatabaseSize());
    }

    @Test
    void schTest() {
        setUpDBData();

        List<Employee> schResult = db.sch("name", "KYUMOK KIM");
        assertEquals(1, schResult.size());
        assertEquals("KYUMOK KIM", schResult.get(0).getName());
    }

    @Test
    void modTest() {
        setUpDBData();

        assertEquals(mockEmployee1.getName(), "KYUMOK KIM");
        assertTrue(db.mod("name", "KYUMOK KIM", "name", "KYUMOK LEE"));
    }
}