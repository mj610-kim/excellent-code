package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class FirstNameOption extends IOption {

    public static Map<String, FirstNameOption> sMe = new HashMap<String, FirstNameOption>();

    private String firstName;

    public static FirstNameOption getInstance(String firstName) {
        if (!sMe.containsKey(firstName)) {
            sMe.put(firstName, new FirstNameOption(firstName));
        }
        return sMe.get(firstName);
    }

    private FirstNameOption(String firstName) {
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
