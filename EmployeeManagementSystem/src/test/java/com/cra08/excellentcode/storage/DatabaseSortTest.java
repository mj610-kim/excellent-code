package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class DatabaseSortTest {
    private Database db;

    @Mock
    Employee mockEmployee1;

    @Mock
    Employee mockEmployee2;

    @Mock
    Employee mockEmployee3;

    @Mock
    Employee mockEmployee4;


    @Before
    public void setUp() {
        openMocks(this);
        db = new Database();

        when(mockEmployee1.getEmployeeNum()).thenReturn("91351446");
        when(mockEmployee1.getName()).thenReturn("KYUMOK KIM");
        when(mockEmployee1.getCl()).thenReturn("CL2");
        when(mockEmployee1.getPhoneNum()).thenReturn("010-9777-6055");
        when(mockEmployee1.getBirthDayAll()).thenReturn("19980906");
        when(mockEmployee1.getCerti()).thenReturn("PRO");

        when(mockEmployee2.getEmployeeNum()).thenReturn("91916535");
        when(mockEmployee2.getName()).thenReturn("VXIHXOTH JHOP");
        when(mockEmployee2.getCl()).thenReturn("CL3");
        when(mockEmployee2.getPhoneNum()).thenReturn("010-3112-2609");
        when(mockEmployee2.getBirthDayAll()).thenReturn("19771211");
        when(mockEmployee2.getCerti()).thenReturn("ADV");

        when(mockEmployee3.getEmployeeNum()).thenReturn("07843022");
        when(mockEmployee3.getName()).thenReturn("VXIHXOTH JHOP");
        when(mockEmployee3.getCl()).thenReturn("CL3");
        when(mockEmployee3.getPhoneNum()).thenReturn("010-3112-2609");
        when(mockEmployee3.getBirthDayAll()).thenReturn("19771211");
        when(mockEmployee3.getCerti()).thenReturn("ADV");

        when(mockEmployee4.getEmployeeNum()).thenReturn("15123101");
        when(mockEmployee4.getName()).thenReturn("VXIHXOTH JHOP");
        when(mockEmployee4.getCl()).thenReturn("CL3");
        when(mockEmployee4.getPhoneNum()).thenReturn("010-3112-2609");
        when(mockEmployee4.getBirthDayAll()).thenReturn("19771211");
        when(mockEmployee4.getCerti()).thenReturn("ADV");
    }

    @Test
    public void addTest() {
        assertTrue(db.add(mockEmployee1));
        assertTrue(db.add(mockEmployee2));
        assertTrue(db.add(mockEmployee3));
        assertTrue(db.add(mockEmployee4));
        db.sort();
        assertEquals(4, db.getDatabaseSize());
    }
}