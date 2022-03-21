import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {
    String[] cmdLine;
    public void setCommandLine(String cmdLine){
        this.cmdLine = cmdLine.split(",");
    }

    public String getCommand(){
        return cmdLine[0];
    }

    public ArrayList<String> getOption(){
//        ArrayList<String> options = new ArrayList<> ();
//        options.add(cmdLine[1]);
//        options.add(cmdLine[2]);
//        options.add(cmdLine[3]);
        return new ArrayList<>(Arrays.asList(cmdLine).subList(1, 3));

//        return options;
    }

    public Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeNum(cmdLine[4]);
        employee.setName(cmdLine[5]);
        employee.setCl(cmdLine[6]);
        employee.setPhoneNum(cmdLine[7]);
        employee.setBirthday(cmdLine[8]);
        employee.setCERTI(cmdLine[9]);
        return employee;
    }

    public ArrayList<String> getColumnData(){
        return new ArrayList<>(Arrays.asList(cmdLine).subList(4, cmdLine.length));
    }
}



