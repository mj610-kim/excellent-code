import java.util.List;

public class EmployeeNameFilter extends EmployeeFilter {

    private static final String FIRST_NAME_OPTION = "-f";
    private static final String LAST_NAME_OPTION = "-l";

    public boolean checkValidOption(String option) {
        if (option.equals(FIRST_NAME_OPTION)) {
            return true;
        }
        if (option.equals(LAST_NAME_OPTION)) {
            return true;
        }

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if (option.equals(FIRST_NAME_OPTION)) {
            return optionFilter.filter(employeeList, new FirstNameComparable(condition));
        }

        if (option.equals(LAST_NAME_OPTION)) {
            return optionFilter.filter(employeeList, new LastNameComparable(condition));
        }

        return null;
    }
}
