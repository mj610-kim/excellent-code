package com.cra08.excellentcode.option;

import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;

public class MiddleNumberOption implements IOption {
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnPhoneNum)
            return true;

        return false;
    }
}
