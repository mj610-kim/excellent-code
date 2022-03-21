import java.util.List;

public class EmployeeBirthDayFilter extends EmployeeFilter{
    static private final String BIRTHYEAROPTION = "-y";
    static private final String BIRTHMONTHOPTION = "-m";
    static private final String BIRTHDAYOPTION = "-d";

    public boolean checkValidOption(String option) {
        if (option.equals(BIRTHYEAROPTION)) return true;
        if (option.equals(BIRTHMONTHOPTION)) return true;
        if (option.equals(BIRTHDAYOPTION)) return true;

        return false;
    }

    public List<Employee> process(String option, List<Employee> employeeList, String condition) {
        if(option.equals(BIRTHYEAROPTION))
            return optionFilter.filter(employeeList, new BirthYearComparable(condition));

        if(option.equals(BIRTHMONTHOPTION))
            return optionFilter.filter(employeeList, new BirthMonthComparable(condition));

        if(option.equals(BIRTHDAYOPTION))
            return optionFilter.filter(employeeList, new BirthDayComparable(condition));

        return null;
    }
}
