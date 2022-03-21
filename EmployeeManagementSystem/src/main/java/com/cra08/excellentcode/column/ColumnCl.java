package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnCl implements IColumn {

    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), value, employee.getPhoneNum(),
                employee.getBirthDayAll(), employee.getCerti());
    }

    @Override
    public boolean contains(Employee employee, String value) {
        return employee.getCl().contains(value);
    }
}
