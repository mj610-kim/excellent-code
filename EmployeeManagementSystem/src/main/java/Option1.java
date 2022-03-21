import java.util.List;

public class Option1 {

    private final int maxPrintCnt = 5;

    public String processOption(String commandName, String option, List<Employee> employeeList) throws IllegalArgumentException {
        if (employeeList.size() == 0) {
            return (commandName + "," + "NONE");
        }

        if (option.equals("-p")) {
            String resultString = "";

            int printCnt = 0;

            for (Employee employee : employeeList) {
                resultString += (commandName + "," + employee.toString() + "\n");
                printCnt++;

                if (printCnt >= maxPrintCnt) {
                    break;
                }
            }

            return resultString;
        }

        if (option.equals("")) {
            return (commandName + "," + employeeList.size());
        }

        throw new IllegalArgumentException("Invalid option(" + option + ")");
    }
}
