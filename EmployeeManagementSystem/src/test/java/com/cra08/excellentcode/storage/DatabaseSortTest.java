package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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
        db.copyDB();
        assertEquals(4, db.getDatabaseSize());
    }

    @Test
    public void addMaxDataTest() {
        for (int i = 0; i < 100000; i++) {
            String employeeNum = String.valueOf(21000000 + i);
            db.add(new Employee(employeeNum, "TTT KKK", "CL2",
                    "010-1234-5678", "19900101", "PRO"));
        }
        db.copyDB();
        System.out.println(db.getDatabaseSize());
        assertEquals(100000, db.getDatabaseSize());
    }

    @Test
    public void addMaxDataTimeoutTest() {
        long startTime = System.currentTimeMillis();
        addMaxDataTest();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        assertTrue(1000 > endTime - startTime);
    }

    @Test
    public void sortTest() {
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);
        Employee employee3 = mock(Employee.class);
        Employee employee4 = mock(Employee.class);
        Employee employee5 = mock(Employee.class);
        Employee employee6 = mock(Employee.class);
        Employee employee7 = mock(Employee.class);
        Employee employee8 = mock(Employee.class);
        Employee employee9 = mock(Employee.class);
        Employee employee10 = mock(Employee.class);

        when(employee1.getEmployeeNum()).thenReturn("70101528");
        when(employee2.getEmployeeNum()).thenReturn("70130884");
        when(employee3.getEmployeeNum()).thenReturn("70129617");
        when(employee4.getEmployeeNum()).thenReturn("70109080");
        when(employee5.getEmployeeNum()).thenReturn("70120659");
        when(employee6.getEmployeeNum()).thenReturn("21131253");
        when(employee7.getEmployeeNum()).thenReturn("21130139");
        when(employee8.getEmployeeNum()).thenReturn("21129546");
        when(employee9.getEmployeeNum()).thenReturn("21129211");
        when(employee10.getEmployeeNum()).thenReturn("21127551");

        db.add(employee1);
        db.add(employee2);
        db.add(employee3);
        db.add(employee4);
        db.add(employee5);
        db.add(employee6);
        db.add(employee7);
        db.add(employee8);
        db.add(employee9);
        db.add(employee10);

        List<String> printResult = db.print();
        System.out.println(printResult);

        assertEquals( "70101528", printResult.get(0));
        assertEquals( "70109080", printResult.get(1));
        assertEquals( "70120659", printResult.get(2));
        assertEquals( "70129617", printResult.get(3));
        assertEquals( "70130884", printResult.get(4));
        assertEquals( "21127551", printResult.get(5));
        assertEquals( "21129211", printResult.get(6));
        assertEquals( "21129546", printResult.get(7));
        assertEquals( "21130139", printResult.get(8));
        assertEquals( "21131253", printResult.get(9));
    }

    @Test
    public void sortTest2() {
        Employee employee0 = mock(Employee.class);
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);
        Employee employee3 = mock(Employee.class);
        Employee employee4 = mock(Employee.class);
        Employee employee5 = mock(Employee.class);
        Employee employee6 = mock(Employee.class);
        Employee employee7 = mock(Employee.class);
        Employee employee8 = mock(Employee.class);
        Employee employee9 = mock(Employee.class);
        Employee employee10 = mock(Employee.class);
        Employee employee11 = mock(Employee.class);
        Employee employee12 = mock(Employee.class);
        Employee employee13 = mock(Employee.class);
        Employee employee14 = mock(Employee.class);

        when(employee0.getEmployeeNum()).thenReturn("69000001");
        when(employee1.getEmployeeNum()).thenReturn("69000002");
        when(employee2.getEmployeeNum()).thenReturn("69000003");

        when(employee3.getEmployeeNum()).thenReturn("89000001");
        when(employee4.getEmployeeNum()).thenReturn("89000002");
        when(employee5.getEmployeeNum()).thenReturn("89000003");

        when(employee6.getEmployeeNum()).thenReturn("09000001");
        when(employee7.getEmployeeNum()).thenReturn("09000002");
        when(employee8.getEmployeeNum()).thenReturn("09000003");

        when(employee9.getEmployeeNum()).thenReturn("11000001");
        when(employee10.getEmployeeNum()).thenReturn("11000002");
        when(employee11.getEmployeeNum()).thenReturn("11000003");

        when(employee12.getEmployeeNum()).thenReturn("21000001");
        when(employee13.getEmployeeNum()).thenReturn("21000002");
        when(employee14.getEmployeeNum()).thenReturn("21000003");

        db.add(employee1);
        db.add(employee12);
        db.add(employee6);
        db.add(employee10);
        db.add(employee3);
        db.add(employee2);
        db.add(employee7);
        db.add(employee5);
        db.add(employee8);
        db.add(employee0);
        db.add(employee13);
        db.add(employee11);
        db.add(employee9);
        db.add(employee4);
        db.add(employee14);

        List<String> printResult = db.print();
        System.out.println(printResult);

        assertEquals( "69000001", printResult.get(0));
        assertEquals( "69000002", printResult.get(1));
        assertEquals( "69000003", printResult.get(2));
        assertEquals( "89000001", printResult.get(3));
        assertEquals( "89000002", printResult.get(4));
        assertEquals( "89000003", printResult.get(5));
        assertEquals( "09000001", printResult.get(6));
        assertEquals( "09000002", printResult.get(7));
        assertEquals( "09000003", printResult.get(8));
        assertEquals( "11000001", printResult.get(9));
        assertEquals( "11000002", printResult.get(10));
        assertEquals( "11000003", printResult.get(11));
        assertEquals( "21000001", printResult.get(12));
        assertEquals( "21000002", printResult.get(13));
        assertEquals( "21000003", printResult.get(14));
    }

    @Test
    public void sortTest3() {
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);
        Employee employee3 = mock(Employee.class);
        Employee employee4 = mock(Employee.class);
        Employee employee5 = mock(Employee.class);

        when(employee1.getEmployeeNum()).thenReturn("15122555");
        when(employee2.getEmployeeNum()).thenReturn("10119921");
        when(employee3.getEmployeeNum()).thenReturn("04102919");
        when(employee4.getEmployeeNum()).thenReturn("73100202");
        when(employee5.getEmployeeNum()).thenReturn("16132569");

        db.add(employee1);
        db.add(employee2);
        db.add(employee3);
        db.add(employee4);
        db.add(employee5);

        List<String> printResult = db.print();
        System.out.println(printResult);

        assertEquals( "73100202", printResult.get(0));
        assertEquals( "04102919", printResult.get(1));
        assertEquals( "10119921", printResult.get(2));
        assertEquals( "15122555", printResult.get(3));
        assertEquals( "16132569", printResult.get(4));
    }
}