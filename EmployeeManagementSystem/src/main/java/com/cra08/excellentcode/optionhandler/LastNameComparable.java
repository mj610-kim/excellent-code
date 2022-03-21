package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;

class LastNameComparable implements Comparable<Employee> {

    private String lastName;

    public LastNameComparable(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getLastName().equals(this.lastName)) {
            return 0;
        } else {
            return -1;
        }
    }
}