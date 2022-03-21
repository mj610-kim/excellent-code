package com.cra08.excellentcode;

class ColumnName {
    public static final String EMPLOYEE_NUM = "employeeNum";
    public static final String NAME = "name";
    public static final String CL = "cl";
    public static final String PHONE_NUM = "phoneNum";
    public static final String BIRTHDAY = "birthday";
    public static final String CERTI = "certi";
}

public class Column {
    private String colName;

    public Column(String colName) {
        this.colName = colName;
    }

    public boolean isEmployeeNum() {
        return colName.equals(ColumnName.EMPLOYEE_NUM);
    }

    public boolean isName() {
        return colName.equals(ColumnName.NAME);
    }

    public boolean isCl() {
        return colName.equals(ColumnName.CL);
    }

    public boolean isPhoneNum() {
        return colName.equals(ColumnName.PHONE_NUM);
    }

    public boolean isBirthday() {
        return colName.equals(ColumnName.BIRTHDAY);
    }

    public boolean isCerti() {
        return colName.equals(ColumnName.CERTI);
    }
}
