package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class LastNumberOption extends IOption {

    public static Map<String, LastNumberOption> sMe = new HashMap<String, LastNumberOption>();

    private String lastNumber;

    public static LastNumberOption getInstance(String lastNumber) {
        if (!sMe.containsKey(lastNumber)) {
            sMe.put(lastNumber, new LastNumberOption(lastNumber));
        }
        return sMe.get(lastNumber);
    }

    private LastNumberOption(String lastNumber) {
        this.lastNumber = lastNumber;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getLastNumber().equals(this.lastNumber)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isValidOption(IColumn column) {
        if (column instanceof ColumnPhoneNum)
            return true;

        return false;
    }
}
