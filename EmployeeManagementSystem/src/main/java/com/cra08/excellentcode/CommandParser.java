package com.cra08.excellentcode;

import com.cra08.excellentcode.datatype.Cmd;

import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.ColumnCerti;
import com.cra08.excellentcode.column.ColumnCl;
import com.cra08.excellentcode.column.ColumnEmployeeNum;
import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;
import com.cra08.excellentcode.option.BirthDayOption;
import com.cra08.excellentcode.option.BirthMonthOption;
import com.cra08.excellentcode.option.BirthYearOption;
import com.cra08.excellentcode.option.EmptyOption;
import com.cra08.excellentcode.option.FirstNameOption;
import com.cra08.excellentcode.option.IOption;
import com.cra08.excellentcode.option.LastNameOption;
import com.cra08.excellentcode.option.LastNumberOption;
import com.cra08.excellentcode.option.MiddleNumberOption;
import com.cra08.excellentcode.option.PrintOption;
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

    public static String getCommand(String cmdLine) throws IllegalArgumentException {
        String cmd = parseCommandLine(cmdLine)[CMD_POS];

        if (!isValidCommand(cmd)) {
            throw new IllegalArgumentException("Invalid command (" + cmd + ")");
        }

        return cmd;
    }

    public static boolean isValidCommand(String cmd) {
        return Arrays.stream(Cmd.values()).anyMatch(s -> s.name().equals(cmd));
    }

    public static List<IOption> getOptionsList(String cmdLine) {
        List<String> optionStringList = getOption(cmdLine);
        String sColumn = getColumnData(cmdLine).get(0);
        IColumn column = getColumnType(sColumn);
        String compareString = CommandParser.getColumnData(cmdLine).get(1);

        List<IOption> optionTypeList = new ArrayList<IOption>();

        for (String optionString : optionStringList) {
            if (optionString.equals("")) {
                optionTypeList.add(EmptyOption.getInstance());
                continue;
            }

            if (optionString.equals("-p")) {
                optionTypeList.add(PrintOption.getInstance());
                continue;
            }

            if (optionString.equals("-f")) {
                optionTypeList.add(FirstNameOption.getInstance(compareString));
                continue;
            }

            if (optionString.equals("-l")) {
                if (column instanceof ColumnName) {
                    optionTypeList.add(LastNameOption.getInstance(compareString));
                    continue;
                }

                if (column instanceof ColumnPhoneNum) {
                    optionTypeList.add(LastNumberOption.getInstance(compareString));
                    continue;
                }
            }

            if (optionString.equals("-m")) {
                if (column instanceof ColumnPhoneNum) {
                    optionTypeList.add(MiddleNumberOption.getInstance(compareString));
                    continue;
                }

                if (column instanceof ColumnBirthday) {
                    optionTypeList.add(BirthMonthOption.getInstance(compareString));
                    continue;
                }
            }

            if (optionString.equals("-y")) {
                optionTypeList.add(BirthYearOption.getInstance(compareString));
                continue;
            }

            if (optionString.equals("-d")) {
                optionTypeList.add(BirthDayOption.getInstance(compareString));
                continue;
            }

            throw new IllegalArgumentException("Cannot parse option type from input: " + optionString);
        }

        return optionTypeList;
    }

    private static ArrayList<String> getOption(String cmdLine) {
        ArrayList<String> options = new ArrayList<>(Arrays.asList(parseCommandLine(cmdLine))
                .subList(OPT1_POS, OPT3_POS + 1));

        for (int i = 0; i < options.size(); i++) {
            options.set(i, removeBlanks(options.get(i)));
        }

        return options;
    }

    public static IColumn getColumnType(String sColName) {
        switch (sColName) {
            case "employeeNum":
                return ColumnEmployeeNum.getInstance();
            case "name":
                return ColumnName.getInstance();
            case "cl":
                return ColumnCl.getInstance();
            case "phoneNum":
                return ColumnPhoneNum.getInstance();
            case "birthday":
                return ColumnBirthday.getInstance();
            case "certi":
                return ColumnCerti.getInstance();
            default:
                throw new IllegalArgumentException("Cannot parse column type from input: " + sColName);
        }
    }

    public static Employee getEmployee(String cmdLine) {
        String[] cmd = parseCommandLine(cmdLine);

        final int employeeVarCnt = 6;
        if (!isValidDataLength(cmd, OPT3_POS + employeeVarCnt + 1)) {
            throw new IllegalArgumentException("Invalid Data Length");
        }

        String employeeNum = cmd[OPT3_POS + 1];
        String name = cmd[OPT3_POS + 2];
        String cl = cmd[OPT3_POS + 3];
        String phoneNum = cmd[OPT3_POS + 4];
        String birthDay = cmd[OPT3_POS + 5];
        String certi = cmd[OPT3_POS + 6];

        Employee employee = new Employee(employeeNum, name, cl, phoneNum, birthDay, certi);

        return employee;
    }

    public static ArrayList<String> getColumnData(String cmdLine) {
        String[] cmd = parseCommandLine(cmdLine);

        final int cmdOptionLen = OPT3_POS + 1;
        final int oneColumnDataLen = cmdOptionLen + 2;
        final int twoColumnDataLen = cmdOptionLen + 4;
        if (!isValidDataLength(cmd, oneColumnDataLen, twoColumnDataLen)) {
            throw new IllegalArgumentException("Invalid Data Length");
        }

        ArrayList<String> columnData = new ArrayList<>(Arrays.asList(cmd).subList(OPT3_POS + 1, cmd.length));

        columnData.set(0, removeBlanks(columnData.get(0)));
        if (columnData.size() == 4) {
            columnData.set(2, removeBlanks(columnData.get(2)));
        }

        return columnData;
    }

    public static String removeBlanks(String str) {
        return str.replaceAll("\\p{Z}", "");
    }

    public static boolean isValidDataLength(String[] cmd, int validLength) {
        return cmd.length == validLength;
    }

    public static boolean isValidDataLength(String[] cmd, int validLength1, int validLength2) {
        return isValidDataLength(cmd, validLength1) || isValidDataLength(cmd, validLength2);
    }
}



