package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public interface IColumn {
    Employee setValue(Employee employee, String value);
    boolean contains(Employee employee, String value);
}

