package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

import java.util.*;

public class Database {
    private HashMap<String, Employee> unsortedEmployeeDB;
    TreeMap<String, Employee> employeeDB;

    public Database() {
        unsortedEmployeeDB = new HashMap<>();
        employeeDB = new TreeMap<>();
    }

    public int getDatabaseSize() {
        return employeeDB.size();
    }

    public boolean add(Employee employee) {
        unsortedEmployeeDB.put(employee.getEmployeeNum(), employee);
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

    public boolean sort() {
        employeeDB = new TreeMap<>(unsortedEmployeeDB);
        Iterator<String> keyIterator = employeeDB.keySet().iterator();

        while(keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        return true;
    }
}