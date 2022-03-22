package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;

public class BirthMonthOption extends IOption {
    private String birthMonth;

    public BirthMonthOption(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthMonth().equals(this.birthMonth)) {
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
