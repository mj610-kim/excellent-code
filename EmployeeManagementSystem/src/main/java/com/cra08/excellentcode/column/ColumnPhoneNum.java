package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnPhoneNum implements IColumn {
    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(), value, employee.getBirthDayAll(), employee.getCerti());
    }
    @Override
    public boolean contains(Employee employee, String value) {
        return employee.getPhoneNum().contains(value);
    }
}
