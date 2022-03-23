package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

public class PrintOption extends IOption {

    private static final PrintOption sMe = new PrintOption();

    public static PrintOption getInstance() {
        return sMe;
    }

    private PrintOption() {}

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    @Override
    public boolean isValidOption(IColumn column) {
        return true;
    }
}
