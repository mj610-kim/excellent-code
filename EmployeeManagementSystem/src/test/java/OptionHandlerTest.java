import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class OptionHandlerTest {
    @Mock
    Employee employee1;

    @Mock
    Employee employee2;

    @Mock
    Employee employee3;

    List<Employee> test_employeeList;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        System.out.println("setUp()");

        test_employeeList = new ArrayList<Employee>();
        test_employeeList.add(employee1);
        test_employeeList.add(employee2);
        test_employeeList.add(employee3);

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
    public void Option1_정상_동작_테스트() {
        Option1 option1 = new Option1();
        String result_str = "";

        result_str = option1.process_option("DEL", "-p", test_employeeList);
        System.out.println(result_str);
        assertEquals(result_str, "DEL,91351446,LIM PNQN,CL3,010-6094-6223,19700122,PRO\n" +
                                    "DEL,93916535,JANG YHFQ,CL3,010-1509-9243,19580525,PRO\n" +
                                    "DEL,07843022,SEO KFI,CL3,010-4837-6716,19810630,ADV\n");

        result_str = option1.process_option("DEL", "", test_employeeList);
        System.out.println(result_str);
        assertEquals(result_str, "DEL,3");
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

        assertThrows(RuntimeException.class, () -> option1.process_option("DEL", "-l", test_employeeList) );
    }

    @Test
    public void Option2_정상_동작_테스트(){
        Option2 option2 = new Option2();
        List<Employee> filtered_employeeList;

        // name, -f 테스트
        filtered_employeeList = option2.process_option("-f", test_employeeList, "name", "PNQN");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(0));

        // name, -l 테스트
        filtered_employeeList = option2.process_option("-l", test_employeeList, "name", "JANG");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(1));

        // PhoneNum, -m 테스트
        filtered_employeeList = option2.process_option("-m", test_employeeList, "phoneNum", "6094");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(0));

        // PhoneNum, -l 테스트
        filtered_employeeList = option2.process_option("-l", test_employeeList, "phoneNum", "9243");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(1));

        // birthday, -y 테스트
        filtered_employeeList = option2.process_option("-y", test_employeeList, "birthday", "1970");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(0));

        // birthday, -y 테스트
        filtered_employeeList = option2.process_option("-m", test_employeeList, "birthday", "05");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(1));

        // birthday, -y 테스트
        filtered_employeeList = option2.process_option("-d", test_employeeList, "birthday", "30");

        for (Employee employee : filtered_employeeList)
            System.out.println(employee.toString());

        assertEquals(filtered_employeeList.get(0), test_employeeList.get(2));
    }

    @Test
    public void Option2_empty_employee_list_입력시_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> empty_employeeList = new ArrayList<Employee>();
        List<Employee> filtered_employeeList;

        filtered_employeeList = option2.process_option("-d", empty_employeeList, "birthday", "30");

        assertEquals(empty_employeeList, filtered_employeeList);
    }

    @Test
    public void Option2_invalid_option_동작_테스트() {
        Option2 option2 = new Option2();

        assertThrows(RuntimeException.class, () -> option2.process_option("-y", test_employeeList, "name", "JANG") );
        assertThrows(RuntimeException.class, () -> option2.process_option("-y", test_employeeList, "phoneNum", "9243") );
        assertThrows(RuntimeException.class, () -> option2.process_option("-l", test_employeeList, "birthday", "1970") );
    }

    @Test
    public void Option2_invalid_column_동작_테스트() {
        Option2 option2 = new Option2();

        assertThrows(RuntimeException.class, () -> option2.process_option("-l", test_employeeList, "name_", "JANG") );
        assertThrows(RuntimeException.class, () -> option2.process_option("-m", test_employeeList, "phone_number", "9243") );
        assertThrows(RuntimeException.class, () -> option2.process_option("-y", test_employeeList, "birth_day", "1970") );
    }


    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
    }

}
