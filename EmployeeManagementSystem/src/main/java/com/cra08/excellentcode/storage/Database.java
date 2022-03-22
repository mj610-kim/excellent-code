package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

import java.util.*;

public class Database {
    private TreeMap<String, Employee> employeeDbTree;
    private LinkedHashMap<String, Employee> employeeDbLinkedHash;
    private boolean isAddFinished = false;

    public Database() {
        employeeDbLinkedHash = new LinkedHashMap<>();
        employeeDbTree = new TreeMap<>(new SortEmployeeNum<>());
    }

    public int getDatabaseSize() {
        return employeeDbLinkedHash.size();
    }

    public boolean add(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("employee object is null...");
        }

        employeeDbTree.put(employee.getEmployeeNum(), employee);
        return true;
    }

    public boolean del(List<Employee> employeeList) {
        setAddFinished();
        for (Employee employee : employeeList) {
            employeeDbLinkedHash.remove(employee.getEmployeeNum());
        }
        return true;
    }

    public List<Employee> sch(IColumn colName, String colValue) {
        setAddFinished();
        List<Employee> resultEmployeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> employee : employeeDbLinkedHash.entrySet()) {
            System.out.println(employee.getValue().getFirstName() + " " + colValue + " " + colName.matched(employee.getValue(), colValue));
            if (colName.matched(employee.getValue(), colValue)) {
                resultEmployeeList.add(employee.getValue());
            }
        }

        return resultEmployeeList;
    }

    public boolean mod(List<Employee> employeeList, IColumn newColName, String newColValue) {
        setAddFinished();
        for (Employee employee : employeeList) {
            employeeDbLinkedHash.put(employee.getEmployeeNum(), newColName.setValue(employee, newColValue));
        }
        return true;
    }

    public List<String> print() {
        List<String> printResult = new ArrayList<>();
        Iterator<String> keyIterator = employeeDbTree.keySet().iterator();

        while (keyIterator.hasNext()) {
            printResult.add(keyIterator.next().toString());
        }

        return printResult;
    }

    public void copyDB() {
        employeeDbLinkedHash.putAll(employeeDbTree);
    }

    private void setAddFinished() {
        if (!isAddFinished) {
            isAddFinished = true;
            copyDB();
        }
    }
}

class SortEmployeeNum<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        String year1 = ((String) o1).substring(0, 2);
        String year2 = ((String) o2).substring(0, 2);

        int num1 = Integer.parseInt(((String) o1).substring(2));
        int num2 = Integer.parseInt(((String) o2).substring(2));

        int calcYear1 = (year1.compareTo("21") <= 0) ?
                Integer.parseInt(year1) + 31 : Integer.parseInt(year1) - 69;
        int calcYear2 = (year2.compareTo("21") <= 0) ?
                Integer.parseInt(year2) + 31 : Integer.parseInt(year2) - 69;

        if (calcYear1 == calcYear2) {
            return num1 - num2;
        }
        return calcYear1 - calcYear2;
    }
}