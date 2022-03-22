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
    public boolean contains(Employee employee, String value) {
        return employee.getBirthDayAll().contains(value);
    }
}
