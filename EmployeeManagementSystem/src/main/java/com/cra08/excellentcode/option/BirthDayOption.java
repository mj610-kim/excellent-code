package com.cra08.excellentcode.option;

import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;

public class BirthDayOption implements IOption {
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnBirthday)
            return true;

        return false;
    }
}
