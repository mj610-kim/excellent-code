package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;

class BirthMonthComparable implements Comparable<Employee> {

    private String birthMonth;

    public BirthMonthComparable(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthMonth().equals(this.birthMonth)) {
            return 0;
        }

        return -1;
    }
}