import java.util.List;

public class EmployeeBirthDayFilter extends EmployeeFilter{
    private final String birthYearOption = "-y";
    private final String birthMonthOption = "-m";
    private final String birthDayOption = "-d";


    public boolean checkValidOption(String option) {
        if (option.equals(birthYearOption)) return true;
        if (option.equals(birthMonthOption)) return true;
        if (option.equals(birthDayOption)) return true;

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if(option.equals(birthYearOption))
            return optionFilter.filter(employeeList, new BirthYearComparable(condition));

        if(option.equals(birthMonthOption))
            return optionFilter.filter(employeeList, new BirthMonthComparable(condition));

        if(option.equals(birthDayOption))
            return optionFilter.filter(employeeList, new BirthDayComparable(condition));

        return null;
    }
}
