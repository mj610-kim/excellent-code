package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

public abstract class IOption implements Comparable<Employee> {
    public abstract int compareTo(Employee o);

    public abstract boolean isValidOption(IColumn column);
}