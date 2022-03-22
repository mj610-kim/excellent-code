package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public class ColumnPhoneNum implements IColumn {
    private static ColumnPhoneNum columnPhoneNum = new ColumnPhoneNum();

    public static ColumnPhoneNum getInstance() {
        return columnPhoneNum;
    }

    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(), value,
                employee.getBirthDayAll(), employee.getCerti());
    }

    @Override
    public boolean matched(Employee employee, String value) {
        return employee.getMiddleNumber().equals(value) || employee.getLastNumber().equals(value);
    }
}
