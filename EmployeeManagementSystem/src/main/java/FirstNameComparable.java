class FirstNameComparable implements Comparable<Employee> {
    private String firstName;
    public FirstNameComparable(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getFirstName().equals(this.firstName))
            return 0;
        else
            return -1;
    }
}