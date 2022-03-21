class BirthMonthComparable implements Comparable<Employee> {
    private String birthMonth;
    public BirthMonthComparable(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthMonth().equals(this.birthMonth))
            return 0;
        else
            return -1;
    }
}