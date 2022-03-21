import java.util.List;

public class Option1 {
    public String process_option(String commandName, String option, List<Employee> employeeList) {
        if(employeeList.size() == 0) {
            return (commandName + "," + "NONE");
        }

        if(option.equals("-p")) {
            String resultString = "";

            for (Employee employee : employeeList)
                resultString += (commandName + "," + employee.toString() + "\n");

            return resultString;
        }

        if(option.equals("")) {
            return (commandName + "," + employeeList.size());
        }

        throw new IllegalArgumentException("Invalid option("+ option +")");
    }
}
