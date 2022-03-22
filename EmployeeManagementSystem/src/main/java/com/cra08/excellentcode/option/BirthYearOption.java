package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;

public class BirthYearOption extends IOption {
    private String birthYear;

    public BirthYearOption(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthYear().equals(this.birthYear)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnBirthday)
            return true;

        return false;
    }
}
