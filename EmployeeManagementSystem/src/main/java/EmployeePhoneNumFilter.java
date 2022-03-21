import java.util.List;

public class EmployeePhoneNumFilter extends EmployeeFilter{
    static private final String MIDDLE_NUMBER_OPTION = "-m";
    static private final String LAST_NUMBER_OPTION = "-l";

    public boolean checkValidOption(String option) {
        if (option.equals(MIDDLE_NUMBER_OPTION)) return true;
        if (option.equals(LAST_NUMBER_OPTION)) return true;

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if(option.equals(MIDDLE_NUMBER_OPTION))
            return optionFilter.filter(employeeList, new MiddleNumberComparable(condition));

        if(option.equals(LAST_NUMBER_OPTION))
            return optionFilter.filter(employeeList, new LastNumberComparable(condition));

        return null;
    }
}
