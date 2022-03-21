public class Employee {
    private String employeeNum;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthday;
    private String CERTI;

    public String toString(){
        return "";
    }

    public String getFirstName(){
        return "";
    }

    public String getLastName(){
        return "";
    }

    public String getMiddleNumber(){
        return "";
    }

    public String getLastNumber(){
        return "";
    }

    public String getBirthYear(){
        return "";
    }

    public String getBirthMonth(){
        return "";
    }

    public String getBirthDay(){
        return this.birthday;
    }


    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCERTI(String CERTI) {
        this.CERTI = CERTI;
    }
}