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
        for (Employee employee : employeeList){
            employeeDB.remove(employee.getEmployeeNum());
        }
        return true;
    }

    public List<Employee> sch(String colName, String colValue) {
        List<Employee> resultEmployeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> employee : employeeDB.entrySet()){
            if (isMatched(employee.getValue(), colName, colValue))
                resultEmployeeList.add(employee.getValue());
        }

        return resultEmployeeList;
    }

    public boolean mod(List<Employee> employeeList, String newColName, String newColValue) {
        for (Employee employee : employeeList){
            employeeDB.put(employee.getEmployeeNum(), modColumn(employee, newColName, newColValue));
        }
        return true;
    }

    private boolean isMatched(Employee employee, String colName, String colValue) {
        if ("employeeNum".equals(colName))
            return employee.getEmployeeNum().contains(colValue);
        else if ("name".equals(colName))
            return employee.getName().contains(colValue);
        else if ("cl".equals(colName))
            return employee.getCl().contains(colValue);
        else if ("phoneNum".equals(colName))
            return employee.getPhoneNum().contains(colValue);
        else if ("birthday".equals(colName))
            return employee.getBirthDayAll().contains(colValue);
        else if ("CERTI".equals(colName))
            return employee.getCERTI().contains(colValue);

        return false;
    }

    private Employee modColumn(Employee employee, String newColName, String newColValue) {
        String employeeNum = employee.getEmployeeNum();
        String name = employee.getName();
        String cl = employee.getCl();
        String phoneNum = employee.getPhoneNum();
        String birthday = employee.getBirthDayAll();
        String CERTI = employee.getCERTI();

        if ("employeeNum".equals(newColName))
            employeeNum = newColValue;
        else if ("name".equals(newColName))
            name = newColValue;
        else if ("cl".equals(newColName))
            cl = newColValue;
        else if ("phoneNum".equals(newColName))
            phoneNum = newColValue;
        else if ("birthday".equals(newColName))
            birthday = newColValue;
        else if ("CERTI".equals(newColName))
            CERTI = newColValue;

        return new Employee(employeeNum, name, cl, phoneNum, birthday, CERTI);
    }
}