package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;

public class LastNumberOption extends IOption {
    private String lastNumber;

    public LastNumberOption(String lastNumber) {
        this.lastNumber = lastNumber;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getLastNumber().equals(this.lastNumber)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnPhoneNum)
            return true;

        return false;
    }
}
