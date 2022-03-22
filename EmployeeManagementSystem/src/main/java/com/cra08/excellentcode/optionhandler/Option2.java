package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;
import com.cra08.excellentcode.option.IOption;

import java.util.List;

public class Option2 {

    private static final EmployeeFilter employeeFilter = new EmployeeFilter();

    public List<Employee> processOption(IOption option, List<Employee> employeeList, IColumn column) throws IllegalArgumentException {

        if (!option.isValidOption(column)) {
            throw new IllegalArgumentException("Invalid option(" + option + ")");
        }

        return employeeFilter.process(option, employeeList);
    }
}
