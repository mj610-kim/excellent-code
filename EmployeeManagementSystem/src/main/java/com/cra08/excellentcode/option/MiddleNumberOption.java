package com.cra08.excellentcode.option;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;
import java.util.HashMap;
import java.util.Map;

public class MiddleNumberOption extends IOption {

    public static Map<String, MiddleNumberOption> sMe = new HashMap<String, MiddleNumberOption>();

    private String middleNumber;

    public static MiddleNumberOption getInstance(String middleNumber) {
        if (!sMe.containsKey(middleNumber)) {
            sMe.put(middleNumber, new MiddleNumberOption(middleNumber));
        }
        return sMe.get(middleNumber);
    }

    private MiddleNumberOption(String middleNumber) {
        this.middleNumber = middleNumber;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getMiddleNumber().equals(this.middleNumber)) {
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
