package com.cra08.excellentcode.storage;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

import java.util.*;

public class Database {
    private HashMap<String, Employee> unsortedEmployeeDB;
    TreeMap<String, Employee> employeeDB;

    public Database() {
        unsortedEmployeeDB = new HashMap<>();
        //employeeDB = new TreeMap<>();
        employeeDB = new TreeMap<>(new SortEmployeeNum<>());
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

    public boolean sort() {
        System.out.println("sort");

        Iterator<String> keyIterator = employeeDB.keySet().iterator();

        while(keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        return true;
    }
}

class SortEmployeeNum<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        String year1 = ((String)o1).substring(0, 2);
        String year2 = ((String)o2).substring(0, 2);

        String num1 = ((String)o1).substring(3);
        String num2 = ((String)o2).substring(3);

        String calcYear1 = (year1.compareTo("21") < 0) ?
                String.valueOf(Integer.parseInt(year1) + 31) :
                String.valueOf(Integer.parseInt(year1) - 69);
        String calcYear2 = (year2.compareTo("21") < 0) ?
                String.valueOf(Integer.parseInt(year2) + 31) :
                String.valueOf(Integer.parseInt(year2) - 69);

        if (calcYear1.compareTo(calcYear2) < 0) {
            return -1;
        }
        else if (calcYear1.compareTo(calcYear2) == 0) {
            return num2.compareTo(num1);
        }
        else {
            return 1;
        }
    }
}