package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class LastNameOption extends IOption {

    public static Map<String, LastNameOption> sMe = new HashMap<String, LastNameOption>();

    private String lastName;

    public static LastNameOption getInstance(String lastName) {
        if (!sMe.containsKey(lastName)) {
            sMe.put(lastName, new LastNameOption(lastName));
        }
        return sMe.get(lastName);
    }

    private LastNameOption(String lastName) {
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
