public class Employee {
    private String employeeNum;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthday;
    private String CERTI;

    private String firstName;
    private String lastName;
    private String middleNumber;
    private String lastNumber;
    private String birthYear;
    private String birthMonth;
    private String birthDay;

    public Employee(String employeeNum, String name, String cl, String phoneNum, String birthday, String CERTI) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthDay = birthday;
        this.CERTI = CERTI;

        this.firstName = name.split(" ")[1];
        this.lastName = name.split(" ")[0];
        this.middleNumber = phoneNum.split("-")[1];
        this.lastNumber = phoneNum.split("-")[2];
        this.birthYear = birthday.substring(0, 4);
        this.birthMonth = birthday.substring(4, 6);
        this.birthDay = birthday.substring(6, 8);
    }

    public String getEmployeeNum(){
        return employeeNum;
    }

    public String getName(){
        return name;
    }

    public String getCl(){
        return cl;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public String getBirthday(){
        return birthday;
    }

    public String getCERTI(){
        return CERTI;
    }

    public String toString(){
        return employeeNum+","+name+","+cl+","+phoneNum+","+birthday+","+CERTI;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getMiddleNumber() {
        return middleNumber;
    }

    public String getLastNumber() {
        return lastNumber;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }
}