package com.cra08.excellentcode;

public class ColumnCl implements IColumn {
    @Override
    public Employee setValue(Employee employee, String value) {
        return new Employee(employee.getEmployeeNum(), employee.getName(), value, employee.getPhoneNum(), employee.getBirthDay(), employee.getCerti());
    }
    @Override
    public boolean contains(Employee employee, String value) {
        return employee.getCl().contains(value);
    }
}
