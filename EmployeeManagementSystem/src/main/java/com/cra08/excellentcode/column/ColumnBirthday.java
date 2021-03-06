package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnBirthday implements IColumn {
    private static ColumnBirthday columnBirthday = new ColumnBirthday();

    public static ColumnBirthday getInstance() {
        return columnBirthday;
    }

    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(), employee.getPhoneNum(),
                value, employee.getCerti());
    }

    @Override
    public boolean matched(Employee employee, String value) {
        return employee.getBirthDayAll().equals(value) || employee.getBirthYear().equals(value)
                || employee.getBirthMonth().equals(value) || employee.getBirthDay().equals(value);
    }
}
