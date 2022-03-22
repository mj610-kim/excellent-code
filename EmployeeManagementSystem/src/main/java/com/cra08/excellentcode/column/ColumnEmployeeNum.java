package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnEmployeeNum implements IColumn {
    private static ColumnEmployeeNum columnEmployeeNum = new ColumnEmployeeNum();

    public static ColumnEmployeeNum getInstance() {
        return columnEmployeeNum;
    }

    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(value, employee.getName(), employee.getCl(), employee.getPhoneNum(),
                employee.getBirthDayAll(), employee.getCerti());
    }

    @Override
    public boolean matched(Employee employee, String value) {
        return employee.getEmployeeNum().equals(value);
    }
}
