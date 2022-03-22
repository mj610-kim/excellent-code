package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.*;

import java.util.List;

public class Option2 {

    private final EmployeeNameFilter employeeNameFilter;
    private final EmployeePhoneNumFilter employeePhoneNumFilter;
    private final EmployeeBirthDayFilter employeeBirthDayFilter;

    public Option2() {
        employeeNameFilter = new EmployeeNameFilter();
        employeePhoneNumFilter = new EmployeePhoneNumFilter();
        employeeBirthDayFilter = new EmployeeBirthDayFilter();
    }

    public List<Employee> processOption(String option, List<Employee> employeeList, IColumn column,
            String condition) throws IllegalArgumentException {

        if (option.equals("")) {
            return employeeList;
        }

        if (column instanceof ColumnName){
            if (!employeeNameFilter.checkValidOption(option)) {
                throw new IllegalArgumentException("Invalid name option(" + option + ")");
            }

            return employeeNameFilter.process(option, employeeList, condition);
        }

        if (column instanceof ColumnPhoneNum) {
            if (!employeePhoneNumFilter.checkValidOption(option)) {
                throw new IllegalArgumentException("Invalid phoneNum option(" + option + ")");
            }

            return employeePhoneNumFilter.process(option, employeeList, condition);
        }

        if (column instanceof ColumnBirthday) {
            if (!employeeBirthDayFilter.checkValidOption(option)) {
                throw new IllegalArgumentException("Invalid birthday option(" + option + ")");
            }

            return employeeBirthDayFilter.process(option, employeeList, condition);
        }

        throw new IllegalArgumentException("Invalid column(" + column + ")");
    }
}
