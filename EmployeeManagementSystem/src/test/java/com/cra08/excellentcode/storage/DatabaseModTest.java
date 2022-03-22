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
    Employee mockEmployee3;

    @Mock
    Employee mockEmployee4;

    @Mock
    Employee mockEmployee5;

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

        when(mockEmployee1.getEmployeeNum()).thenReturn("15123099");
        when(mockEmployee1.getName()).thenReturn("VXIHXOTH JHOP");
        when(mockEmployee1.getCl()).thenReturn("CL3");
        when(mockEmployee1.getPhoneNum()).thenReturn("010-3112-2609");
        when(mockEmployee1.getBirthDayAll()).thenReturn("19771211");
        when(mockEmployee1.getCerti()).thenReturn("ADV");

        when(mockEmployee2.getEmployeeNum()).thenReturn("17112609");
        when(mockEmployee2.getName()).thenReturn("FB NTAWR");
        when(mockEmployee2.getCl()).thenReturn("CL4");
        when(mockEmployee2.getPhoneNum()).thenReturn("010-5645-6122");
        when(mockEmployee2.getBirthDayAll()).thenReturn("19861203");
        when(mockEmployee2.getCerti()).thenReturn("PRO");

        when(mockEmployee3.getEmployeeNum()).thenReturn("18115040");
        when(mockEmployee3.getName()).thenReturn("TTETHU HBO");
        when(mockEmployee3.getCl()).thenReturn("CL3");
        when(mockEmployee3.getPhoneNum()).thenReturn("010-4581-2050");
        when(mockEmployee3.getBirthDayAll()).thenReturn("20080718");
        when(mockEmployee3.getCerti()).thenReturn("ADV");

        when(mockEmployee4.getEmployeeNum()).thenReturn("88114052");
        when(mockEmployee4.getName()).thenReturn("NQ LVARW");
        when(mockEmployee4.getCl()).thenReturn("CL4");
        when(mockEmployee4.getPhoneNum()).thenReturn("010-4528-3059");
        when(mockEmployee4.getBirthDayAll()).thenReturn("19911021");
        when(mockEmployee4.getCerti()).thenReturn("PRO");

        when(mockEmployee5.getEmployeeNum()).thenReturn("19129568");
        when(mockEmployee5.getName()).thenReturn("SRERLALH HMEF");
        when(mockEmployee5.getCl()).thenReturn("CL2");
        when(mockEmployee5.getPhoneNum()).thenReturn("010-3091-9521");
        when(mockEmployee5.getBirthDayAll()).thenReturn("19640910");
        when(mockEmployee5.getCerti()).thenReturn("PRO");
    }

    @Test
    public void addTest() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertTrue(db.add(mockEmployee3));
        assertTrue(db.add(mockEmployee4));
        assertTrue(db.add(mockEmployee5));
        assertTrue(db.copyDB());
        assertEquals(5, db.getDatabaseSize());
    }

    @Test
    public void modNameTest() {
        addTest();

        when(mockColumnName.matched(mockEmployee1, "VXIHXOTH JHOP")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnName, "VXIHXOTH JHOP");
        assertEquals(1, schResult1.size());
        assertTrue(db.mod(schResult1, mockColumnName, "VXIHXOTHAFTER JHOPAFTER"));

        List<Employee> schResult2 = db.sch(mockColumnName, "VXIHXOTH JHOP");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modFirstNameTest() {
        addTest();

        when(mockColumnName.matched(mockEmployee1, "VXIHXOTH")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnName, "VXIHXOTH");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnName, "VXIHXOTHAFTER JHOP"));

        List<Employee> schResult2 = db.sch(mockColumnName, "VXIHXOTH JHOP");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modLastNameTest() {
        addTest();

        when(mockColumnName.matched(mockEmployee1, "JHOP")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnName, "JHOP");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnName, "VXIHXOTH JHOPAFTER"));

        List<Employee> schResult2 = db.sch(mockColumnName, "VXIHXOTH JHOPAFTER");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modClTest() {
        addTest();

        when(mockColumnCl.matched(mockEmployee1, "CL2")).thenReturn(true);
        when(mockColumnCl.matched(mockEmployee5, "CL2")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnCl, "CL2");
        assertEquals(2, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnCl, "CL3"));

        List<Employee> schResult2 = db.sch(mockColumnCl, "CL2");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modPhoneNumTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee3, "010-4581-2050")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "010-4581-2050");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnPhoneNum, "010-4581-2051"));

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "010-4581-2050");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modMiddlePhoneNumTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee3, "4581")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "4581");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnPhoneNum, "4582"));

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "4581");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modLastPhoneNumTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee3, "2050")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "2050");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnPhoneNum, "2051"));

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "2050");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modBirthDayAllTest() {
        addTest();

        when(mockColumnBirthday.matched(mockEmployee4, "19911021")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnBirthday, "19911021");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnBirthday, "19911022"));

        List<Employee> schResult2 = db.sch(mockColumnBirthday, "19911021");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modBirthYearTest() {
        addTest();

        when(mockColumnBirthday.matched(mockEmployee4, "1991")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnBirthday, "1991");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnBirthday, "1990"));

        List<Employee> schResult2 = db.sch(mockColumnBirthday, "1991");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modBirthMonthTest() {
        addTest();

        when(mockColumnBirthday.matched(mockEmployee4, "10")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnBirthday, "10");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnBirthday, "12"));

        List<Employee> schResult2 = db.sch(mockColumnBirthday, "10");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modBirthDayTest() {
        addTest();

        when(mockColumnBirthday.matched(mockEmployee4, "21")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnBirthday, "21");
        assertEquals(1, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnBirthday, "23"));

        List<Employee> schResult2 = db.sch(mockColumnBirthday, "21");
        assertEquals(0, schResult2.size());
    }

    @Test
    public void modCertiTest() {
        addTest();

        when(mockColumnCerti.matched(mockEmployee2, "PRO")).thenReturn(true);
        when(mockColumnCerti.matched(mockEmployee4, "PRO")).thenReturn(true);
        when(mockColumnCerti.matched(mockEmployee5, "PRO")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnCerti, "PRO");
        assertEquals(3, schResult1.size());

        assertTrue(db.mod(schResult1, mockColumnCerti, "ADV"));

        List<Employee> schResult2 = db.sch(mockColumnCerti, "PRO");
        assertEquals(0, schResult2.size());
    }
}