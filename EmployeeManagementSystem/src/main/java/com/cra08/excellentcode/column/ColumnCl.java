package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnCl implements IColumn {
    private static ColumnCl columnCl = new ColumnCl();

    public static ColumnCl getInstance() {
        return columnCl;
    }

    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), value, employee.getPhoneNum(),
                employee.getBirthDayAll(), employee.getCerti());
    }

    @Override
    public boolean matched(Employee employee, String value) {
        return employee.getCl().equals(value);
    }
}
