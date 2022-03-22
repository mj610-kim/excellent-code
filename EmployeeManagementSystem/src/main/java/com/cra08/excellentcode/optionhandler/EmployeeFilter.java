package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.option.*;

import java.util.List;

public class EmployeeFilter {

    private Filter<Employee> optionFilter;

    public EmployeeFilter() {
        optionFilter = new Filter<Employee>();
    }

    public List<Employee> process(IOption option, List<Employee> employeeList, String condition) {
        if (option instanceof FirstNameOption) {
            return optionFilter.filter(employeeList, new FirstNameComparable(condition));
        }

        if (option instanceof LastNameOption) {
            return optionFilter.filter(employeeList, new LastNameComparable(condition));
        }

        if (option instanceof MiddleNumberOption) {
            return optionFilter.filter(employeeList, new MiddleNumberComparable(condition));
        }

        if (option instanceof LastNumberOption) {
            return optionFilter.filter(employeeList, new LastNumberComparable(condition));
        }

        if (option instanceof BirthYearOption) {
            return optionFilter.filter(employeeList, new BirthYearComparable(condition));
        }

        if (option instanceof BirthMonthOption) {
            return optionFilter.filter(employeeList, new BirthMonthComparable(condition));
        }

        if (option instanceof BirthDayOption) {
            return optionFilter.filter(employeeList, new BirthDayComparable(condition));
        }

        return employeeList;
    }
}
