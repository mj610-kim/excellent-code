package com.cra08.excellentcode;

public class ColumnBirthday implements IColumn {
    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(), employee.getPhoneNum(), value, employee.getCerti());
    }
    @Override
    public boolean contains(Employee employee, String value) {
        return employee.getBirthDay().contains(value);
    }
}
