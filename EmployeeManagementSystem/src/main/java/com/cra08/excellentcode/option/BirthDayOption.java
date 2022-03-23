package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class BirthDayOption extends IOption {

    public static Map<String, BirthDayOption> sMe = new HashMap<String, BirthDayOption>();

    private String birthDay;

    public static BirthDayOption getInstance(String birthDay) {
        if (!sMe.containsKey(birthDay)) {
            sMe.put(birthDay, new BirthDayOption(birthDay));
        }
        return sMe.get(birthDay);
    }

    private BirthDayOption(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthDay().equals(this.birthDay)) {
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
