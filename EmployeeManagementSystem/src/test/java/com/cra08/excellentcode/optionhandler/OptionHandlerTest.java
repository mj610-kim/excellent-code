package com.cra08.excellentcode.optionhandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cra08.excellentcode.Employee;
import java.util.ArrayList;
import java.util.List;

import com.cra08.excellentcode.column.*;
import com.cra08.excellentcode.option.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class OptionHandlerTest {
    @Mock
    private Employee employee1;

    @Mock
    private Employee employee2;

    @Mock
    private Employee employee3;

    @Mock
    private Employee employee4;

    @Mock
    private Employee employee5;

    @Mock
    private Employee employee6;

    private List<Employee> testEmployeeList;
    static private final OptionHandler optionHandler = new OptionHandler();

    @Before
    public void setUp() {
        openMocks(this);
        System.out.println("setUp()");

        testEmployeeList = new ArrayList<Employee>();
        testEmployeeList.add(employee1);
        testEmployeeList.add(employee2);
        testEmployeeList.add(employee3);
        testEmployeeList.add(employee4);
        testEmployeeList.add(employee5);
        testEmployeeList.add(employee6);

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

        when(employee4.toString()).thenReturn(new String("91351447,LIN PNQO,CL3,010-6095-6224,19710223,PRO"));
        when(employee4.getFirstName()).thenReturn(new String("PNQO"));
        when(employee4.getLastName()).thenReturn(new String("LIN"));
        when(employee4.getMiddleNumber()).thenReturn(new String("6095"));
        when(employee4.getLastNumber()).thenReturn(new String("6224"));
        when(employee4.getBirthYear()).thenReturn(new String("1971"));
        when(employee4.getBirthMonth()).thenReturn(new String("02"));
        when(employee4.getBirthDay()).thenReturn(new String("23"));

        when(employee5.toString()).thenReturn(new String("93916536,JANH YHFR,CL3,010-1510-9244,19590626,PRO"));
        when(employee5.getFirstName()).thenReturn(new String("YHFR"));
        when(employee5.getLastName()).thenReturn(new String("JANH"));
        when(employee5.getMiddleNumber()).thenReturn(new String("1510"));
        when(employee5.getLastNumber()).thenReturn(new String("9244"));
        when(employee5.getBirthYear()).thenReturn(new String("1959"));
        when(employee5.getBirthMonth()).thenReturn(new String("06"));
        when(employee5.getBirthDay()).thenReturn(new String("26"));

        when(employee6.toString()).thenReturn(new String("07843023,SEP KFJ,CL3,010-4838-6717,19820731,ADV"));
        when(employee6.getFirstName()).thenReturn(new String("KFJ"));
        when(employee6.getLastName()).thenReturn(new String("SEP"));
        when(employee6.getMiddleNumber()).thenReturn(new String("4838"));
        when(employee6.getLastNumber()).thenReturn(new String("6717"));
        when(employee6.getBirthYear()).thenReturn(new String("1982"));
        when(employee6.getBirthMonth()).thenReturn(new String("07"));
        when(employee6.getBirthDay()).thenReturn(new String("31"));
    }


    @Test
    public void Option1_p옵션처리_정상_동작_테스트() {
        Option1 option1 = new Option1();
        IOption option = new PrintOption();

        String resultString = option1.processOption("DEL", option, testEmployeeList);
        System.out.println(resultString);
        assertEquals(resultString, "DEL,91351446,LIM PNQN,CL3,010-6094-6223,19700122,PRO\n" +
                                    "DEL,93916535,JANG YHFQ,CL3,010-1509-9243,19580525,PRO\n" +
                                    "DEL,07843022,SEO KFI,CL3,010-4837-6716,19810630,ADV\n" +
                                    "DEL,91351447,LIN PNQO,CL3,010-6095-6224,19710223,PRO\n" +
                                    "DEL,93916536,JANH YHFR,CL3,010-1510-9244,19590626,PRO");
    }

    @Test
    public void Option1_empty옵션처리_정상_동작_테스트() {
        Option1 option1 = new Option1();
        IOption option = new EmptyOption();

        String resultString = option1.processOption("DEL", option, testEmployeeList);
        System.out.println(resultString);
        assertEquals(resultString, "DEL,6");
    }

    @Test
    public void Option1_empty_employee_list_입력시_동작_테스트() {
        Option1 option1 = new Option1();
        IOption printOption = new PrintOption();
        IOption emptyOption = new PrintOption();

        String result_str = "";

        List<Employee> empty_employeeList = new ArrayList<Employee>();

        result_str = option1.processOption("DEL", printOption, empty_employeeList);
        System.out.println(result_str);
        assertEquals(result_str, "DEL,NONE");

        result_str = option1.processOption("DEL", emptyOption, empty_employeeList);
        System.out.println(result_str);
        assertEquals(result_str, "DEL,NONE");
    }

    @Test
    public void Option1_invalid_option_동작_테스트() {
        Option1 option1 = new Option1();
        IOption option = new FirstNameOption();

        assertThrows(IllegalArgumentException.class, () -> option1.processOption("DEL", option, testEmployeeList) );
    }

    @Test
    public void Option2_name컬럼_f옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnName();
        IOption option = new FirstNameOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "PNQN");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(0));
    }

    @Test
    public void Option2_name컬럼_l옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnName();
        IOption option = new LastNameOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "JANG");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(1));
    }

    @Test
    public void Option2_phoneNum컬럼_m옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnPhoneNum();
        IOption option = new MiddleNumberOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "6094");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(0));
    }

    @Test
    public void Option2_phoneNum컬럼_l옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnPhoneNum();
        IOption option = new LastNumberOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "9243");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(1));
    }

    @Test
    public void Option2_birthday컬럼_y옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnBirthday();
        IOption option = new BirthYearOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "1970");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(0));
    }

    @Test
    public void Option2_birthday컬럼_m옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnBirthday();
        IOption option = new BirthMonthOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "05");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(1));
    }

    @Test
    public void Option2_birthday컬럼_d옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnBirthday();
        IOption option = new BirthDayOption();

        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "30");

        for (Employee employee : filteredEmployeeList)
            System.out.println(employee.toString());

        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(2));
    }

    @Test
    public void Option2_empty_employee_list_입력시_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> emptyEmployeeList = new ArrayList<Employee>();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnBirthday();
        IOption option = new BirthDayOption();

        filteredEmployeeList = option2.processOption(option, emptyEmployeeList, column, "30");

        assertEquals(emptyEmployeeList, filteredEmployeeList);
    }

    @Test
    public void Option2_invalid_option_동작_테스트() {
        Option2 option2 = new Option2();
        IColumn nameColumn = new ColumnName();
        IColumn phoneNumColumn = new ColumnPhoneNum();
        IColumn birthdayColumn = new ColumnBirthday();
        IOption option = new BirthYearOption();


        assertThrows(IllegalArgumentException.class, () -> option2.processOption(option, testEmployeeList, nameColumn, "JANG") );
        assertThrows(IllegalArgumentException.class, () -> option2.processOption(option, testEmployeeList, phoneNumColumn, "9243") );
    }


    private class ColumnInvalid implements IColumn {

        @Override
        public Employee setValue(Employee employee, String value) {
            return employee;
        }

        @Override
        public boolean contains(Employee employee, String value) {
            return false;
        }
    }

    @Test
    public void Option2_invalid_column_동작_테스트() {
        Option2 option2 = new Option2();
        IColumn invalidColumn = new ColumnInvalid();
        IOption birthDayOption = new BirthDayOption();

        assertThrows(IllegalArgumentException.class, () -> option2.processOption(birthDayOption, testEmployeeList, invalidColumn, "JANG") );
    }

    @Test
    public void Option2_empty옵션처리_정상_동작_테스트() {
        Option2 option2 = new Option2();
        List<Employee> filteredEmployeeList;
        IColumn column = new ColumnBirthday();
        IOption option = new EmptyOption();


        filteredEmployeeList = option2.processOption(option, testEmployeeList, column, "30");

        assertEquals(testEmployeeList, filteredEmployeeList);
    }



    @Test
    public void OptionHandler_정상_동작_테스트() {
        List<IOption> optionTypeList = new ArrayList<IOption>();
        optionTypeList.add(new PrintOption());
        optionTypeList.add(new FirstNameOption());
        optionTypeList.add(new EmptyOption());

        IColumn column = new ColumnName();
        List<Employee> filteredEmployeeList = optionHandler.processOptions("DEL", optionTypeList, column, "KFJ", testEmployeeList);
        assertEquals(filteredEmployeeList.get(0), testEmployeeList.get(5));

        String resultString = optionHandler.toString();
        System.out.println(resultString);
        assertEquals(resultString, "DEL,07843023,SEP KFJ,CL3,010-4838-6717,19820731,ADV");
    }


    @After
    public void tearDown() {
        System.out.println("tearDown()");
    }

}
