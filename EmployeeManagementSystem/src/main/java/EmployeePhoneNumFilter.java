import java.util.List;

public class EmployeePhoneNumFilter extends EmployeeFilter {

    private final String middleNumberOption = "-m";
    private final String lastNumberOption = "-l";


    public boolean checkValidOption(String option) {
        if (option.equals(middleNumberOption)) {
            return true;
        }
        if (option.equals(lastNumberOption)) {
            return true;
        }

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if (option.equals(middleNumberOption)) {
            return optionFilter.filter(employeeList, new MiddleNumberComparable(condition));
        }

        if (option.equals(lastNumberOption)) {
            return optionFilter.filter(employeeList, new LastNumberComparable(condition));
        }

        return null;
    }
}
