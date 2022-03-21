import java.util.List;

public class EmployeeNameFilter extends EmployeeFilter{
    static private final String FIRSTNAMEOPTION = "-f";
    static private final String LASTNAMEOPTION = "-l";

    public boolean checkValidOption(String option) {
        if (option.equals(FIRSTNAMEOPTION)) return true;
        if (option.equals(LASTNAMEOPTION)) return true;

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if(option.equals(FIRSTNAMEOPTION))
            return optionFilter.filter(employeeList, new FirstNameComparable(condition));

        if(option.equals(LASTNAMEOPTION))
            return optionFilter.filter(employeeList, new LastNameComparable(condition));

        return null;
    }
}
