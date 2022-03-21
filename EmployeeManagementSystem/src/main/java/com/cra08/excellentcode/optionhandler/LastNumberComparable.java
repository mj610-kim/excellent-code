package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;

class LastNumberComparable implements Comparable<Employee> {

    private String lastNumber;

    public LastNumberComparable(String lastNumber) {
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
}