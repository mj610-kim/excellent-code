package com.cra08.excellentcode.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cra08.excellentcode.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class DatabaseSchTest {
    private Database db;
    private List<Employee> employeeList = new ArrayList<>();

    @Mock
    Employee mockEmployee1;

    @Mock
    Employee mockEmployee2;

    @Mock
    ColumnEmployeeNum mockColumnEmployeeNum;

    @Mock
    ColumnName mockColumnName;

    @Mock
    ColumnCl mockColumnCl;

    @Mock
    ColumnPhoneNum mockColumnPhoneNum;

    @Mock
    ColumnBirthday mockColumnBirthday;

    @Mock
    ColumnCerti mockColumnCerti;


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

        when(mockColumnEmployeeNum.contains(mockEmployee1, "18050301")).thenReturn(true);
        when(mockColumnName.contains(mockEmployee1, "KYUMOK KIM")).thenReturn(true);
        when(mockColumnCl.contains(mockEmployee1, "CL2")).thenReturn(true);
        when(mockColumnPhoneNum.contains(mockEmployee1, "010-9777-6055")).thenReturn(true);
        when(mockColumnBirthday.contains(mockEmployee1, "19980906")).thenReturn(true);
        when(mockColumnCerti.contains(mockEmployee1, "PRO")).thenReturn(true);
    }

    @Test
    public void addTest() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void schTestByEmployeeNum() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnEmployeeNum, "18050301");
        assertEquals(1, schResult.size());
        assertEquals("18050301", schResult.get(0).getEmployeeNum());
    }

    @Test
    public void schTestByName() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnName, "KYUMOK KIM");
        assertEquals(1, schResult.size());

        assertEquals("KYUMOK KIM", schResult.get(0).getName());
    }

    @Test
    public void schTestByCl() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnCl, "CL2");
        assertEquals(1, schResult.size());

        assertEquals("CL2", schResult.get(0).getCl());
    }

    @Test
    public void schTestByPhoneNum() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnPhoneNum, "010-9777-6055");
        assertEquals(1, schResult.size());

        assertEquals("010-9777-6055", schResult.get(0).getPhoneNum());
    }

    @Test
    public void schTestByBirthDay() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnBirthday, "19980906");
        assertEquals(1, schResult.size());

        assertEquals("19980906", schResult.get(0).getBirthDayAll());
    }

    @Test
    public void schTestByCerti() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnCerti, "PRO");
        assertEquals(1, schResult.size());

        assertEquals("PRO", schResult.get(0).getCerti());
    }
}
