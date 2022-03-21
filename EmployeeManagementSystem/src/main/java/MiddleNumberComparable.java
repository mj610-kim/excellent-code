class MiddleNumberComparable implements Comparable<Employee> {

    private String middleNumber;

    public MiddleNumberComparable(String middleNumber) {
        this.middleNumber = middleNumber;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.getMiddleNumber().equals(this.middleNumber)) {
            return 0;
        } else {
            return -1;
        }
    }
}
