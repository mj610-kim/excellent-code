import java.util.List;

public abstract class EmployeeFilter {

    protected Filter<Employee> optionFilter;

    public EmployeeFilter() {
        optionFilter = new Filter<Employee>();
    }

    public abstract boolean checkValidOption(String option);

    public abstract List<Employee> process(String option, List<Employee> employeeList, String condition);
}
