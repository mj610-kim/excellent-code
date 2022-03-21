import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {

    final static int CMD_POS = 0;
    final static int OPT1_POS = 1;
    final static int OPT2_POS = 2;
    final static int OPT3_POS = 3;

    private static String[] parseCommandLine(String cmdLine) {
        return cmdLine.split(",");
    }

    public static String getCommand(String cmdLine) {
        return parseCommandLine(cmdLine)[CMD_POS];
    }

    public static ArrayList<String> getOption(String cmdLine) {
        return new ArrayList<>(Arrays.asList(parseCommandLine(cmdLine)).subList(OPT1_POS, OPT3_POS));
    }

    public static Employee getEmployee(String cmdLine) {
        String[] cmd = parseCommandLine(cmdLine);
        String employeeNum = cmd[4];
        String name = cmd[5];
        String cl = cmd[6];
        String phoneNum = cmd[7];
        String birthDay = cmd[8];
        String certi = cmd[9];

        Employee employee = new Employee(employeeNum, name, cl, phoneNum, birthDay, certi);

        return employee;
    }

    public static ArrayList<String> getColumnData(String cmdLine) {
        String[] cmd = parseCommandLine(cmdLine);
        return new ArrayList<>(Arrays.asList(cmd).subList(OPT3_POS + 1, cmd.length));
    }
}



