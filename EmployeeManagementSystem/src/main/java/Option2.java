import java.util.ArrayList;
import java.util.List;

class Fitler<T>  {
    public List<T> filter(List<T> items, Comparable<T> comparable) {
        List<T> result = new ArrayList<T>();
        for (T item : items) {
            if (comparable.compareTo(item) == 0) {
                result.add(item);
            }
        }
        return result;
    }
}

class FirstNameComparable implements Comparable<Employee> {
    private String first_name;
    public FirstNameComparable(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getFirstName().equals(this.first_name))
            return 0;
        else
            return -1;
    }
}

class LastNameComparable implements Comparable<Employee> {
    private String last_name;
    public LastNameComparable(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getLastName().equals(this.last_name))
            return 0;
        else
            return -1;
    }
}

class MiddleNumberComparable implements Comparable<Employee> {
    private String middle_number;
    public MiddleNumberComparable(String middle_number) {
        this.middle_number = middle_number;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getMiddleNumber().equals(this.middle_number))
            return 0;
        else
            return -1;
    }
}

class LastNumberComparable implements Comparable<Employee> {
    private String last_number;
    public LastNumberComparable(String last_number) {
        this.last_number = last_number;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getLastNumber().equals(this.last_number))
            return 0;
        else
            return -1;
    }
}

class BirthYearComparable implements Comparable<Employee> {
    private String birth_year;
    public BirthYearComparable(String birth_year) {
        this.birth_year = birth_year;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthYear().equals(this.birth_year))
            return 0;
        else
            return -1;
    }
}

class BirthMonthComparable implements Comparable<Employee> {
    private String birth_month;
    public BirthMonthComparable(String birth_month) {
        this.birth_month = birth_month;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthMonth().equals(this.birth_month))
            return 0;
        else
            return -1;
    }
}

class BirthDayComparable implements Comparable<Employee> {
    private String birth_day;
    public BirthDayComparable(String birth_day) {
        this.birth_day = birth_day;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthDay().equals(this.birth_day))
            return 0;
        else
            return -1;
    }
}

public class Option2 {
    public List<Employee> process_option(String option, List<Employee> employeeList, String column, String condition) {
        if (column.equals("name")){
            if(option.equals("-f")) {
                Fitler<Employee> option_filter = new Fitler<Employee>();
                FirstNameComparable fname = new FirstNameComparable(condition);

                return option_filter.filter(employeeList, fname);
            }

            if(option.equals("-l")){
                Fitler<Employee> option_filter = new Fitler<Employee>();
                LastNameComparable lname = new LastNameComparable(condition);

                return option_filter.filter(employeeList, lname);
            }

            throw new RuntimeException("Invalid name option("+ option +")");
        }

        if (column.equals("phoneNum")){
            if(option.equals("-m")) {
                Fitler<Employee> option_filter = new Fitler<Employee>();
                MiddleNumberComparable mNumber = new MiddleNumberComparable(condition);

                return option_filter.filter(employeeList, mNumber);
            }

            if(option.equals("-l")){
                Fitler<Employee> option_filter = new Fitler<Employee>();
                LastNumberComparable lNumber = new LastNumberComparable(condition);

                return option_filter.filter(employeeList, lNumber);
            }

            throw new RuntimeException("Invalid phoneNum option("+ option +")");
        }

        if (column.equals("birthday")){
            if(option.equals("-y")) {
                Fitler<Employee> option_filter = new Fitler<Employee>();
                BirthYearComparable birthYear = new BirthYearComparable(condition);

                return option_filter.filter(employeeList, birthYear);
            }

            if(option.equals("-m")){
                Fitler<Employee> option_filter = new Fitler<Employee>();
                BirthMonthComparable birthMonth = new BirthMonthComparable(condition);

                return option_filter.filter(employeeList, birthMonth);
            }

            if(option.equals("-d")){
                Fitler<Employee> option_filter = new Fitler<Employee>();
                BirthDayComparable birthDay = new BirthDayComparable(condition);

                return option_filter.filter(employeeList, birthDay);
            }

            throw new RuntimeException("Invalid birthday option("+ option +")");
        }


        throw new RuntimeException("Invalid column("+ column +")");
    }
}
