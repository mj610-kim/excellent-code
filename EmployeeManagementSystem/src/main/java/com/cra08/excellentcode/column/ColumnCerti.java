package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnCerti implements IColumn {
    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(), employee.getPhoneNum(), employee.getBirthDayAll(), value);
    }
    @Override
    public boolean contains(Employee employee, String value) {
        return employee.getCerti().contains(value);
    }
}
