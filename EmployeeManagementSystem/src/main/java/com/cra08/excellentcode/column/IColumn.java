package com.cra08.excellentcode.column;

import com.cra08.excellentcode.Employee;

public interface IColumn {
    Employee setValue(Employee employee, String value);
    boolean matched(Employee employee, String value);
}

