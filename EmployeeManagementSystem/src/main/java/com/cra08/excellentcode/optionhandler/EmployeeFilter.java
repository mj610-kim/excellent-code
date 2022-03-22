package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.option.IOption;

import java.util.List;

public class EmployeeFilter {

    private Filter<Employee> optionFilter;

    public EmployeeFilter() {
        optionFilter = new Filter<Employee>();
    }

    public List<Employee> process(IOption option, List<Employee> employeeList) {
        return optionFilter.filter(employeeList, option);
    }
}
