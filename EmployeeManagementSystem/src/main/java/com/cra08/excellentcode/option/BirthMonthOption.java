package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class BirthMonthOption extends IOption {

    public static Map<String, BirthMonthOption> sMe = new HashMap<String, BirthMonthOption>();

    private String birthMonth;

    public static BirthMonthOption getInstance(String birthMonth) {
        if (!sMe.containsKey(birthMonth)) {
            sMe.put(birthMonth, new BirthMonthOption(birthMonth));
        }
        return sMe.get(birthMonth);
    }

    private BirthMonthOption(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthMonth().equals(this.birthMonth)) {
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
