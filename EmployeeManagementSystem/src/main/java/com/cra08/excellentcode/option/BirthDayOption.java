package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;

public class BirthDayOption extends IOption {
    private String birthDay;

    public BirthDayOption(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthDay().equals(this.birthDay)) {
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
