package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.IColumn;

public class FirstNameOption extends IOption {
    private String firstName;

    public FirstNameOption(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getFirstName().equals(this.firstName)) {
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
