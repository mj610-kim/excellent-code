import java.util.List;

public class EmployeePhoneNumFilter extends EmployeeFilter{
    static private final String MIDDLENUMBEROPTION = "-m";
    static private final String LASTNUMBEROPTION = "-l";

    public boolean checkValidOption(String option) {
        if (option.equals(MIDDLENUMBEROPTION)) return true;
        if (option.equals(LASTNUMBEROPTION)) return true;

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if(option.equals(MIDDLENUMBEROPTION))
            return optionFilter.filter(employeeList, new MiddleNumberComparable(condition));

        if(option.equals(LASTNUMBEROPTION))
            return optionFilter.filter(employeeList, new LastNumberComparable(condition));

        return null;
    }
}
