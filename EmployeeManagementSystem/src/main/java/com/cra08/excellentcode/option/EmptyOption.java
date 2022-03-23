package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

public class EmptyOption extends IOption {

    private static final EmptyOption sMe = new EmptyOption();

    public static EmptyOption getInstance() {
        return sMe;
    }

    private EmptyOption() {}

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    @Override
    public boolean isValidOption(IColumn column) {
        return true;
    }
}
