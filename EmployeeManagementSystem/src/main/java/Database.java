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

    public boolean add(List<Employee> employeeList) {
        for (Employee employee : employeeList)
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
        return "name".equals(colName) && colValue.equals(employee.getName());
    }

    private Employee modColumn(Employee employee, String newColName, String newColValue) {
        String employeeNum = employee.getEmployeeNum();
        String name = employee.getName();
        String cl = employee.getCl();
        String phoneNum = employee.getPhoneNum();
        String birthday = employee.getBirthDay();
        String CERTI = employee.getCERTI();

        if ("name".equals(newColName))
            name = newColValue;

        return new Employee(employeeNum, name, cl, phoneNum, birthday, CERTI);
    }
}