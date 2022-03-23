package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class BirthYearOption extends IOption {

    public static Map<String, BirthYearOption> sMe = new HashMap<String, BirthYearOption>();

    private String birthYear;

    public static BirthYearOption getInstance(String birthYear) {
        if (!sMe.containsKey(birthYear)) {
            sMe.put(birthYear, new BirthYearOption(birthYear));
        }
        return sMe.get(birthYear);
    }

    private BirthYearOption(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthYear().equals(this.birthYear)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnBirthday)
            return true;

        return false;
    }
}
