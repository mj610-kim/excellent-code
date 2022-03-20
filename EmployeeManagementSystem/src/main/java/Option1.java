import java.util.List;

public class Option1 {
    public String process_option(String prefix, String option, List<Employee> employeeList) {
        if(employeeList.size() == 0){
            return (prefix + "," + "NONE");
        }

        if(option.equals("-p")) {
            String result_str = "";

            for (Employee employee : employeeList)
                result_str += (prefix + "," + employee.toString() + "\n");

            return result_str;
        }

        if(option.equals("")){
            return (prefix + "," + employeeList.size());
        }

        throw new RuntimeException("Invalid option("+ option +")");
    }
}
