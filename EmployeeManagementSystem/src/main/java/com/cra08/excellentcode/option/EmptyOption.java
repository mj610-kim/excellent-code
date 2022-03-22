package com.cra08.excellentcode.option;

import com.cra08.excellentcode.column.IColumn;

public class EmptyOption implements IOption {
    public boolean isValidOption(IColumn column) {
            return true;
    }
}
