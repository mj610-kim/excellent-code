package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;

public class MiddleNumberOption extends IOption {
    private String middleNumber;

    public MiddleNumberOption(String middleNumber) {
        this.middleNumber = middleNumber;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getMiddleNumber().equals(this.middleNumber)) {
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
