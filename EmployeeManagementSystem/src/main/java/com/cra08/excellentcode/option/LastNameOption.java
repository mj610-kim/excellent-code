package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.IColumn;

public class LastNameOption extends IOption {
    private String lastName;

    public LastNameOption(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getLastName().equals(this.lastName)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnName)
            return true;

        return false;
    }

}
