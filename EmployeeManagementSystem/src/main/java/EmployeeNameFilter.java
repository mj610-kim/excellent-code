import java.util.List;

public class EmployeeNameFilter extends EmployeeFilter {

    private final String firstNameOption = "-f";
    private final String lastNameOption = "-l";


    public boolean checkValidOption(String option) {
        if (option.equals(firstNameOption)) {
            return true;
        }
        if (option.equals(lastNameOption)) {
            return true;
        }

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if (option.equals(firstNameOption)) {
            return optionFilter.filter(employeeList, new FirstNameComparable(condition));
        }

        if (option.equals(lastNameOption)) {
            return optionFilter.filter(employeeList, new LastNameComparable(condition));
        }

        return null;
    }
}
