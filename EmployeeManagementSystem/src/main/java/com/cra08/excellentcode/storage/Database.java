package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.Column;
import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.IColumn;

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

    public List<Employee> sch(IColumn colName, String colValue) {
        List<Employee> resultEmployeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> employee : employeeDB.entrySet()) {
            if (colName.contains(employee.getValue(), colValue)) {
                resultEmployeeList.add(employee.getValue());
            }
        }

        return resultEmployeeList;
    }

    public boolean mod(List<Employee> employeeList, IColumn newColName, String newColValue) {
        for (Employee employee : employeeList) {
            employeeDB.put(employee.getEmployeeNum(), newColName.setValue(employee, newColValue));
        }
        return true;
    }
}