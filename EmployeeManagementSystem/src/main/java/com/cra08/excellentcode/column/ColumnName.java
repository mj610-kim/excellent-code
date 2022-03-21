package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnName implements IColumn {
    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), value, employee.getCl(), employee.getPhoneNum(), employee.getBirthDayAll(), employee.getCerti());
    }
    @Override
    public boolean contains(Employee employee, String value) {
        return employee.getName().contains(value);
    }
}
