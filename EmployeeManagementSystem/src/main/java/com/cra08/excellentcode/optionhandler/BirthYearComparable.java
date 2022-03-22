package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;

class BirthYearComparable implements Comparable<Employee> {

    private String birthYear;

    public BirthYearComparable(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthYear().equals(this.birthYear)) {
            return 0;
        }

        return -1;
    }
}