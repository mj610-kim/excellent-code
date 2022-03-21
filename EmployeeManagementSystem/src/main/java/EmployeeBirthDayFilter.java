import java.util.List;


public class EmployeeBirthDayFilter extends EmployeeFilter {

    private static final String BIRTH_YEAR_OPTION = "-y";
    private static final String BIRTH_MONTH_OPTION = "-m";
    private static final String BIRTH_DAY_OPTION = "-d";

    public boolean checkValidOption(String option) {
        if (option.equals(BIRTH_YEAR_OPTION)) {
            return true;
        }
        if (option.equals(BIRTH_MONTH_OPTION)) {
            return true;
        }
        if (option.equals(BIRTH_DAY_OPTION)) {
            return true;
        }

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if (option.equals(BIRTH_YEAR_OPTION)) {
            return optionFilter.filter(employeeList, new BirthYearComparable(condition));
        }

        if (option.equals(BIRTH_MONTH_OPTION)) {
            return optionFilter.filter(employeeList, new BirthMonthComparable(condition));
        }

        if (option.equals(BIRTH_DAY_OPTION)) {
            return optionFilter.filter(employeeList, new BirthDayComparable(condition));
        }

        return null;
    }
}
