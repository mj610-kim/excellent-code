package com.cra08.excellentcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {

    static final int CMD_POS = 0;
    static final int OPT1_POS = 1;
    static final int OPT2_POS = 2;
    static final int OPT3_POS = 3;

    private static String[] parseCommandLine(String cmdLine) {
        return cmdLine.split(",");
    }

    public static String getCommand(String cmdLine) throws IllegalArgumentException{

        String cmd = parseCommandLine(cmdLine)[CMD_POS];

        if(!isValidCommand(cmd)) {
            throw new IllegalArgumentException("Invalid command (" + cmd + ")");
        }

        return cmd;
    }

    public static boolean isValidCommand(String cmd) {
        List<String> validCommands = Arrays.asList("ADD", "DEL", "SCH", "MOD");
        return validCommands.stream().anyMatch(s -> s.equals(cmd));
    }


    public static ArrayList<String> getOption(String cmdLine) {
        return new ArrayList<>(Arrays.asList(parseCommandLine(cmdLine)).subList(OPT1_POS, OPT3_POS+1));
    }

    public static Employee getEmployee(String cmdLine) {

        String[] cmd = parseCommandLine(cmdLine);

        String employeeNum = cmd[OPT3_POS+1];
        String name = cmd[OPT3_POS+2];
        String cl = cmd[OPT3_POS+3];
        String phoneNum = cmd[OPT3_POS+4];
        String birthDay = cmd[OPT3_POS+5];
        String certi = cmd[OPT3_POS+6];

        Employee employee = new Employee(employeeNum, name, cl, phoneNum, birthDay, certi);

        return employee;
    }

    public static ArrayList<String> getColumnData(String cmdLine) {
        String[] cmd = parseCommandLine(cmdLine);
        return new ArrayList<>(Arrays.asList(cmd).subList(OPT3_POS + 1, cmd.length));
    }
}



