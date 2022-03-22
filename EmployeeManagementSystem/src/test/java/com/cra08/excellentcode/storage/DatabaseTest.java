package com.cra08.excellentcode.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cra08.excellentcode.*;

import java.util.List;

import com.cra08.excellentcode.column.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class DatabaseTest {
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

        when(mockColumnEmployeeNum.matched(mockEmployee1, "18050301")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee1, "KYUMOK KIM")).thenReturn(true);
        when(mockColumnCl.matched(mockEmployee1, "CL2")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee1, "010-9777-6055")).thenReturn(true);
        when(mockColumnBirthday.matched(mockEmployee1, "19980906")).thenReturn(true);
        when(mockColumnCerti.matched(mockEmployee1, "PRO")).thenReturn(true);
    }

    @Test
    public void addTest() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        db.copyDB();
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void addTest_FailCase() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        db.copyDB();
        assertNotEquals(1, db.getDatabaseSize());
    }

    @Test
    public void addTest_NullCase() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        db.copyDB();

        assertThrows(NullPointerException.class, () -> db.add(null));
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void delTest() {
        addTest();

        List<Employee> schResult = db.sch(mockColumnName, "KYUMOK KIM");
        assertEquals(1, schResult.size());

        assertTrue(db.del(schResult));
        assertEquals(1, db.getDatabaseSize());
    }
}