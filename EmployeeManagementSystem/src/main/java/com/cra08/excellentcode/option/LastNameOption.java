package com.cra08.excellentcode.option;

import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.IColumn;

public class LastNameOption implements IOption {
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnName)
            return true;

        return false;
    }
}
