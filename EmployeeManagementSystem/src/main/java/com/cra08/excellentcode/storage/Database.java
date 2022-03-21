package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.Column;
import com.cra08.excellentcode.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    // <employeeNum, Employee Object>
    private HashMap<String, Employee> employeeDB;

    public Database() {
        employeeDB = new HashMap<>();
    }

    public int getDatabaseSize() {
        return employeeDB.size();
    }

    public boolean add(Employee employee) {
        employeeDB.put(employee.getEmployeeNum(), employee);
        return true;
    }

    public boolean del(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employeeDB.remove(employee.getEmployeeNum());
        }
        return true;
    }

    public List<Employee> sch(Column colName, String colValue) {
        List<Employee> resultEmployeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> employee : employeeDB.entrySet()) {
            if (isMatched(employee.getValue(), colName, colValue)) {
                resultEmployeeList.add(employee.getValue());
            }
        }

        return resultEmployeeList;
    }

    public boolean mod(List<Employee> employeeList, Column newColName, String newColValue) {
        for (Employee employee : employeeList) {
            employeeDB.put(employee.getEmployeeNum(), modColumn(employee, newColName, newColValue));
        }
        return true;
    }

    private boolean isMatched(Employee employee, Column colName, String colValue) {
        if (colName.isEmployeeNum()) {
            return employee.getEmployeeNum().contains(colValue);
        } else if (colName.isName()) {
            return employee.getName().contains(colValue);
        } else if (colName.isCl()) {
            return employee.getCl().contains(colValue);
        } else if (colName.isPhoneNum()) {
            return employee.getPhoneNum().contains(colValue);
        } else if (colName.isBirthday()) {
            return employee.getBirthDayAll().contains(colValue);
        } else if (colName.isCerti()) {
            return employee.getCerti().contains(colValue);
        }

        return false;
    }

    private Employee modColumn(Employee employee, Column newColName, String newColValue) {
        String employeeNum = employee.getEmployeeNum();
        String name = employee.getName();
        String cl = employee.getCl();
        String phoneNum = employee.getPhoneNum();
        String birthday = employee.getBirthDayAll();
        String certi = employee.getCerti();

        if (newColName.isEmployeeNum()) {
            employeeNum = newColValue;
        } else if (newColName.isName()) {
            name = newColValue;
        } else if (newColName.isCl()) {
            cl = newColValue;
        } else if (newColName.isPhoneNum()) {
            phoneNum = newColValue;
        } else if (newColName.isBirthday()) {
            birthday = newColValue;
        } else if (newColName.isCerti()) {
            certi = newColValue;
        }

        return new Employee(employeeNum, name, cl, phoneNum, birthday, certi);
    }
}