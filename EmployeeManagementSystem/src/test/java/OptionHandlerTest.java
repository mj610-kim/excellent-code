import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class OptionHandlerTest {
    @Mock
    Employee employee1;

    @Mock
    Employee employee2;

    @Mock
    Employee employee3;

    List<Employee> testEmployeeList;

    @Before
    public void setUp() {
        openMocks(this);
        System.out.println("setUp()");

        testEmployeeList = new ArrayList<Employee>();
        testEmployeeList.add(employee1);
        testEmployeeList.add(employee2);
        testEmployeeList.add(employee3);

        when(employee1.toString()).thenReturn(new String("91351446,LIM PNQN,CL3,010-6094-6223,19700122,PRO"));
        when(employee1.getFirstName()).thenReturn(new String("PNQN"));
        when(employee1.getLastName()).thenReturn(new String("LIM"));
        when(employee1.getMiddleNumber()).thenReturn(new String("6094"));
        when(employee1.getLastNumber()).thenReturn(new String("6223"));
        when(employee1.getBirthYear()).thenReturn(new String("1970"));
        when(employee1.getBirthMonth()).thenReturn(new String("01"));
        when(employee1.getBirthDay()).thenReturn(new String("22"));

        when(employee2.toString()).thenReturn(new String("93916535,JANG YHFQ,CL3,010-1509-9243,19580525,PRO"));
        when(employee2.getFirstName()).thenReturn(new String("YHFQ"));
        when(employee2.getLastName()).thenReturn(new String("JANG"));
        when(employee2.getMiddleNumber()).thenReturn(new String("1509"));
        when(employee2.getLastNumber()).thenReturn(new String("9243"));
        when(employee2.getBirthYear()).thenReturn(new String("1958"));
        when(employee2.getBirthMonth()).thenReturn(new String("05"));
        when(employee2.getBirthDay()).thenReturn(new String("25"));

        when(employee3.toString()).thenReturn(new String("07843022,SEO KFI,CL3,010-4837-6716,19810630,ADV"));
        when(employee3.getFirstName()).thenReturn(new String("KFI"));
        when(employee3.getLastName()).thenReturn(new String("SEO"));
        when(employee3.getMiddleNumber()).thenReturn(new String("4837"));
        when(employee3.getLastNumber()).thenReturn(new String("6716"));
        when(employee3.getBirthYear()).thenReturn(new String("1981"));
        when(employee3.getBirthMonth()).thenReturn(new String("06"));
        when(employee3.getBirthDay()).thenReturn(new String("30"));
    }


    @Test
    public void Option1_p옵션처리_정상_동작_테스트() {
        Option1 option1 = new Option1();
        String resultString = "";

        resultString = option1.process_option("DEL", "-p", testEmployeeList);
        System.out.println(resultString);
        assertEquals(resultString, "DEL,91351446,LIM PNQN,CL3,010-6094-6223,19700122,PRO\n" +
                                    "DEL,93916535,JANG YHFQ,CL3,010-1509-9243,19580525,PRO\n" +
                                    "DEL,07843022,SEO KFI,CL3,010-4837-6716,19810630,ADV\n");
    }

    @Test
    public void Option1_null옵션처리_정상_동작_테스트() {
        Option1 option1 = new Option1();
        String resultString = "";

        resultString = option1.process_option("DEL", "", testEmployeeList);
        System.out.println(resultString);
        assertEquals(resultString, "DEL,3");
    }

    @Test
    public void Option1_empty_employee_list_입력시_동작_테스트() {
        Option1 option1 = new Option1();
        String result_str = "";

        List<Employee> empty_employeeList = new ArrayList<Employee>();

        result_str = option1.process_option("DEL", "-p", empty_employeeList);
        System.out.println(result_str);
        assertEquals(result_str, "DEL,NONE");

        result_str = option1.process_option("DEL", "", empty_employeeList);
        System.out.println(result_str);
        assertEquals(result_str, "DEL,NONE");
    }

    @Test
    public void Option1_invalid_option_동작_테스트() {
        Option1 option1 = new Option1();

        assertThrows(IllegalArgumentException.class, () -> option1.process_option("DEL", "-l", testEmployeeList) );
    }

    @Test
    public void Option2_name컬럼_f옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-f", testEmployeeList, "name", "PNQN");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(0));
    }

    @Test
    public void Option2_name컬럼_l옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-l", testEmployeeList, "name", "JANG");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(1));
    }

    @Test
    public void Option2_phoneNum컬럼_m옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-m", testEmployeeList, "phoneNum", "6094");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(0));
    }

    @Test
    public void Option2_phoneNum컬럼_l옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-l", testEmployeeList, "phoneNum", "9243");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(1));
    }

    @Test
    public void Option2_birthday컬럼_y옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-y", testEmployeeList, "birthday", "1970");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(0));
    }

    @Test
    public void Option2_birthday컬럼_m옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-m", testEmployeeList, "birthday", "05");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(1));
    }

    @Test
    public void Option2_birthday컬럼_d옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-d", testEmployeeList, "birthday", "30");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(2));
    }

    @Test
    public void Option2_empty_employee_list_입력시_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> emptyEmployeeList = new ArrayList<Employee>();
        List<Employee> filteredEmployeeList;

        filteredEmployeeList = option2.process_option("-d", emptyEmployeeList, "birthday", "30");

        assertEquals(emptyEmployeeList, filteredEmployeeList);
    }

    @Test
    public void Option2_invalid_option_동작_테스트() {
        Option2 option2 = new Option2();

        assertThrows(IllegalArgumentException.class, () -> option2.process_option("-y", testEmployeeList, "name", "JANG") );
        assertThrows(IllegalArgumentException.class, () -> option2.process_option("-y", testEmployeeList, "phoneNum", "9243") );
        assertThrows(IllegalArgumentException.class, () -> option2.process_option("-l", testEmployeeList, "birthday", "1970") );
    }

    @Test
    public void Option2_invalid_column_동작_테스트() {
        Option2 option2 = new Option2();

        assertThrows(IllegalArgumentException.class, () -> option2.process_option("-l", testEmployeeList, "name_", "JANG") );
        assertThrows(IllegalArgumentException.class, () -> option2.process_option("-m", testEmployeeList, "phone_number", "9243") );
        assertThrows(IllegalArgumentException.class, () -> option2.process_option("-y", testEmployeeList, "birth_day", "1970") );
    }


    @After
    public void tearDown() {
        System.out.println("tearDown()");
    }

}
