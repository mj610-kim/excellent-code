import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {
    final int CMD_POS = 0;
    final int OPT1_POS = 1;
    final int OPT2_POS = 2;
    final int OPT3_POS = 3;

    String[] cmdLine;
    public void setCommandLine(String cmdLine){
        this.cmdLine = cmdLine.split(",");
    }

    public String getCommand(){
        return cmdLine[CMD_POS];
    }

    public ArrayList<String> getOption(){
        return new ArrayList<>(Arrays.asList(cmdLine).subList(OPT1_POS, OPT3_POS));
    }

    public Employee getEmployee() {
        String employeeNum = cmdLine[4];
        String name = cmdLine[5];
        String cl = cmdLine[6];
        String phoneNum = cmdLine[7];
        String birthDay = cmdLine[8];
        String certi = cmdLine[9];

        Employee employee = new Employee(
                employeeNum, name, cl, phoneNum, birthDay, certi
        );

        return employee;
    }

    public ArrayList<String> getColumnData() {
        return new ArrayList<>(Arrays.asList(cmdLine).subList(OPT3_POS+1, cmdLine.length));
    }
}



