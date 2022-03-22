package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

import java.util.*;

public class Database {
    private TreeMap<String, Employee> employeeDB;
    private LinkedHashMap<String, Employee> employeeDBPerf;
    private boolean isAddFinished = false;

    public Database() {
        employeeDBPerf = new LinkedHashMap<>();
        employeeDB = new TreeMap<>(new SortEmployeeNum<>());
    }

    public int getDatabaseSize() {
        return employeeDB.size();
    }

    public boolean add(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("employee object is null...");
        }

        employeeDB.put(employee.getEmployeeNum(), employee);
        return true;
    }

    public boolean del(List<Employee> employeeList) {
        setAddFinished();
        for (Employee employee : employeeList) {
            employeeDBPerf.remove(employee.getEmployeeNum());
        }
        return true;
    }

    public List<Employee> sch(IColumn colName, String colValue) {
        setAddFinished();
        List<Employee> resultEmployeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> employee : employeeDBPerf.entrySet()) {
            if (colName.contains(employee.getValue(), colValue)) {
                resultEmployeeList.add(employee.getValue());
            }
        }

        return resultEmployeeList;
    }

    public boolean mod(List<Employee> employeeList, IColumn newColName, String newColValue) {
        setAddFinished();
        for (Employee employee : employeeList) {
            employeeDBPerf.put(employee.getEmployeeNum(), newColName.setValue(employee, newColValue));
        }
        return true;
    }

    public boolean print() {
        Iterator<String> keyIterator = employeeDB.keySet().iterator();

        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        return true;
    }

    private void copyDB() {
        for (Map.Entry<String, Employee> employee : employeeDB.entrySet()) {
            employeeDBPerf.put(employee.getKey(), employee.getValue());
        }
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

        String num1 = ((String) o1).substring(3);
        String num2 = ((String) o2).substring(3);

        String calcYear1 = (year1.compareTo("21") < 0) ?
                String.valueOf(Integer.parseInt(year1) + 31) :
                String.valueOf(Integer.parseInt(year1) - 69);
        String calcYear2 = (year2.compareTo("21") < 0) ?
                String.valueOf(Integer.parseInt(year2) + 31) :
                String.valueOf(Integer.parseInt(year2) - 69);

        if (calcYear1.compareTo(calcYear2) < 0) {
            return -1;
        } else if (calcYear1.compareTo(calcYear2) == 0) {
            return num2.compareTo(num1);
        } else {
            return 1;
        }
    }
}