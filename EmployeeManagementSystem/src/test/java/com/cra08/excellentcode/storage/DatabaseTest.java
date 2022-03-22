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
    Employee mockEmployee3;

    @Mock
    Employee mockEmployee4;

    @Mock
    Employee mockEmployee5;

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
    public void employeeSetUp() {
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
    public void addTest_FailCase() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertTrue(db.add(mockEmployee3));
        assertTrue(db.add(mockEmployee4));
        assertTrue(db.add(mockEmployee5));
        assertTrue(db.copyDB());
        assertNotEquals(3, db.getDatabaseSize());
    }

    @Test
    public void addTest_NullCase() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertTrue(db.add(mockEmployee3));
        assertTrue(db.add(mockEmployee4));
        assertTrue(db.add(mockEmployee5));
        assertTrue(db.copyDB());

        assertThrows(NullPointerException.class, () -> db.add(null));
        assertEquals(5, db.getDatabaseSize());
    }

    @Test
    public void delEmployeeNumTest() {
        addTest();

        when(mockColumnEmployeeNum.matched(mockEmployee1, "15123099")).thenReturn(true);
        when(mockColumnEmployeeNum.matched(mockEmployee2, "17112609")).thenReturn(true);
        when(mockColumnEmployeeNum.matched(mockEmployee3, "18115040")).thenReturn(true);
        when(mockColumnEmployeeNum.matched(mockEmployee4, "88114052")).thenReturn(true);
        when(mockColumnEmployeeNum.matched(mockEmployee5, "19129568")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnEmployeeNum, "15123099");
        assertEquals(1, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(4, db.getDatabaseSize());


        List<Employee> schResult2 = db.sch(mockColumnEmployeeNum, "17112609");
        assertEquals(1, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnEmployeeNum, "18115040");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(2, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnEmployeeNum, "17112609");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void delFirstNameTest() {
        addTest();

        when(mockColumnName.matched(mockEmployee1, "VXIHXOTH")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee2, "FB")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee3, "FB")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee4, "NQ")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee5, "NQ")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnName, "VXIHXOTH");
        assertEquals(1, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(4, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnName, "FB");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(2, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnName, "NQ");
        assertEquals(2, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnName, "NQ");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delLastNameTest() {
        addTest();

        when(mockColumnName.matched(mockEmployee1, "JHOP")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee2, "JHOP")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee3, "HBO")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee4, "HBO")).thenReturn(true);
        when(mockColumnName.matched(mockEmployee5, "HMEF")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnName, "JHOP");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnName, "HBO");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(1, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnName, "HMEF");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnName, "HMEF");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delClTest() {
        addTest();

        when(mockColumnCl.matched(mockEmployee1, "CL3")).thenReturn(true);
        when(mockColumnCl.matched(mockEmployee2, "CL4")).thenReturn(true);
        when(mockColumnCl.matched(mockEmployee3, "CL3")).thenReturn(true);
        when(mockColumnCl.matched(mockEmployee4, "CL4")).thenReturn(true);
        when(mockColumnCl.matched(mockEmployee5, "CL2")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnCl, "CL3");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnCl, "CL4");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(1, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnCl, "CL2");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnCl, "CL2");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delPhoneNumTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "010-3112-2609")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "010-5645-2609")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "010-5645-2050")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "010-4528-2050")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "010-4528-9521")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "010-3112-2609");
        assertEquals(1, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(4, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "010-5645-2050");
        assertEquals(1, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "010-4528-2050");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(2, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "010-3112-2609");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void delMiddlePhoneNumTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "3112")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "5645")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "5645")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "4528")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "4528")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "3112");
        assertEquals(1, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(4, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "5645");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(2, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "4528");
        assertEquals(2, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "5645");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delLastPhoneNumTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "2609")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "2609")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "2050")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "2050")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "9521")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "2609");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "2050");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(1, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "9521");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "9521");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delBirthDayAllTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "19771211")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "19861203")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "20080703")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "19910721")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "19770921")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "19771211");
        assertEquals(1, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(4, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "19861203");
        assertEquals(1, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "19910721");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(2, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "19861203");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(2, db.getDatabaseSize());
    }

    @Test
    public void delBirthYearTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "1977")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "1986")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "2008")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "1991")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "1977")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "1977");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "1991");
        assertEquals(1, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(2, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "2008");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(1, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "2008");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(1, db.getDatabaseSize());
    }

    @Test
    public void delBirthMonthAllTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "12")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "12")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "07")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "07")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "09")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "12");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "07");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(1, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "09");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "09");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delBirthDayTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "11")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "03")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "03")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "21")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "21")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "21");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "03");
        assertEquals(2, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(1, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "11");
        assertEquals(1, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult4 = db.sch(mockColumnPhoneNum, "03");
        assertEquals(0, schResult4.size());
        assertTrue(db.del(schResult4));
        assertEquals(0, db.getDatabaseSize());
    }

    @Test
    public void delCertiTest() {
        addTest();

        when(mockColumnPhoneNum.matched(mockEmployee1, "ADV")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee2, "PRO")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee3, "ADV")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee4, "PRO")).thenReturn(true);
        when(mockColumnPhoneNum.matched(mockEmployee5, "PRO")).thenReturn(true);

        List<Employee> schResult1 = db.sch(mockColumnPhoneNum, "ADV");
        assertEquals(2, schResult1.size());
        assertTrue(db.del(schResult1));
        assertEquals(3, db.getDatabaseSize());

        List<Employee> schResult2 = db.sch(mockColumnPhoneNum, "PRO");
        assertEquals(3, schResult2.size());
        assertTrue(db.del(schResult2));
        assertEquals(0, db.getDatabaseSize());

        List<Employee> schResult3 = db.sch(mockColumnPhoneNum, "PRO");
        assertEquals(0, schResult3.size());
        assertTrue(db.del(schResult3));
        assertEquals(0, db.getDatabaseSize());
    }
}