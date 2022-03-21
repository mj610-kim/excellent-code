import java.util.List;

public class Option2 {
    private Filter<Employee> optionFilter;

    public Option2() {
        optionFilter = new Filter<Employee>();
    }

    public List<Employee> process_option(String option, List<Employee> employeeList, String column, String condition) throws IllegalArgumentException {
        if (column.equals("name")) {
            if(option.equals("-f"))
                return optionFilter.filter(employeeList, new FirstNameComparable(condition));

            if(option.equals("-l"))
                return optionFilter.filter(employeeList, new LastNameComparable(condition));

            throw new IllegalArgumentException("Invalid name option("+ option +")");
        }

        if (column.equals("phoneNum")) {
            if(option.equals("-m"))
                return optionFilter.filter(employeeList, new MiddleNumberComparable(condition));

            if(option.equals("-l"))
                return optionFilter.filter(employeeList, new LastNumberComparable(condition));

            throw new IllegalArgumentException("Invalid phoneNum option("+ option +")");
        }

        if (column.equals("birthday")) {
            if(option.equals("-y"))
                return optionFilter.filter(employeeList, new BirthYearComparable(condition));

            if(option.equals("-m"))
                return optionFilter.filter(employeeList, new BirthMonthComparable(condition));


            if(option.equals("-d"))
                return optionFilter.filter(employeeList, new BirthDayComparable(condition));

            throw new IllegalArgumentException("Invalid birthday option("+ option +")");
        }


        throw new IllegalArgumentException("Invalid column("+ column +")");
    }
}
