package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.*;
import com.cra08.excellentcode.column.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class DatabaseModTest {
    private Database db;

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
        assertTrue(db.sort());
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void modTestEmployeeNum() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnEmployeeNum, "18050301");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, mockColumnEmployeeNum, "18050301"));
    }

    @Test
    public void modTestName() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnName, "KYUMOK KIM");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, mockColumnName, "KYUMOK LEE"));
    }

    @Test
    public void modTestCl() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnCl, "CL2");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, mockColumnCl, "CL2"));
    }

    @Test
    public void modTestPhoneNum() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnPhoneNum, "010-9777-6055");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, mockColumnPhoneNum, "010-9777-6055"));
    }

    @Test
    public void modTestBirthDay() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnBirthday, "19980906");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, mockColumnBirthday, "19980906"));
    }

    @Test
    public void modTestCerti() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnCerti, "PRO");
        assertEquals(1, schResult.size());

        assertTrue(db.mod(schResult, mockColumnCerti, "PRO"));
    }
}