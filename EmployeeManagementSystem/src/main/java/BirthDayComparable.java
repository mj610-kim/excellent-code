class BirthDayComparable implements Comparable<Employee> {

    private String birthDay;

    public BirthDayComparable(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getBirthDay().equals(this.birthDay)) {
            return 0;
        } else {
            return -1;
        }
    }
}