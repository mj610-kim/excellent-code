package com.cra08.excellentcode.datatype;

import static com.cra08.excellentcode.CommandHandler.IS_DEBUG_MODE;

import com.cra08.excellentcode.CommandParser;
import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.*;
import com.cra08.excellentcode.option.*;
import com.cra08.excellentcode.optionhandler.OptionHandler;
import com.cra08.excellentcode.storage.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Cmd {
    ADD {
        @Override
        public String run(String input, Database database) {
            Employee employee = CommandParser.getEmployee(input);
            printLog("cmd: ADD, employee: " + employee);
            database.add(employee);
            return null;
        }
    },
    DEL {
        @Override
        public String run(String input, Database database) {
            String cmd = CommandParser.getCommand(input);
            List<String> employees = CommandParser.getColumnData(input);
            printLog("cmd: DEL, employees: " + Arrays.toString(employees.toArray()));

            String sColName = CommandParser.getColumnData(input).get(0);
            IColumn colName = getColumnType(sColName);
            String colVal = CommandParser.getColumnData(input).get(1);
            List<IOption> optionsList = getOptionList(CommandParser.getOption(input), colName, colVal);

            printLog("sColName: " + sColName + ", colVal: " + colVal
                    + ", optionsList: " + Arrays.toString(optionsList.toArray()));

            List<Employee> employeesToDelete = database.sch(colName, colVal);
            OptionHandler optionHandler = new OptionHandler();

            List<Employee> employeesToDeleteFiltered = optionHandler.processOptions(cmd, optionsList, colName, employeesToDelete);

            database.del(employeesToDeleteFiltered);

            return optionHandler.toString();
        }
    },
    SCH {
        @Override
        public String run(String input, Database database) {
            String cmd = CommandParser.getCommand(input);
            List<String> employees = CommandParser.getColumnData(input);
            printLog("cmd: SCH, employees: " + Arrays.toString(employees.toArray()));

            String sColName = CommandParser.getColumnData(input).get(0);
            IColumn colName = getColumnType(sColName);
            String colVal = CommandParser.getColumnData(input).get(1);
            List<IOption> optionsList = getOptionList(CommandParser.getOption(input), colName, colVal);

            printLog("sColName: " + sColName + ", colVal: " + colVal
                    + ", optionsList: " + Arrays.toString(optionsList.toArray()));

            List<Employee> employeesToSearch = database.sch(colName, colVal);
            OptionHandler optionHandler = new OptionHandler();
            optionHandler.processOptions(cmd, optionsList, colName, employeesToSearch);

            return optionHandler.toString();
        }
    },
    MOD {
        @Override
        public String run(String input, Database database) {
            String cmd = CommandParser.getCommand(input);
            List<String> employees = CommandParser.getColumnData(input);
            printLog("cmd: MOD, employees: " + Arrays.toString(employees.toArray()));

            String sSearchColName = CommandParser.getColumnData(input).get(0);
            IColumn searchColName = getColumnType(sSearchColName);
            String searchColVal = CommandParser.getColumnData(input).get(1);
            String sModifyColName = CommandParser.getColumnData(input).get(2);
            IColumn modifyColName = getColumnType(sModifyColName);
            String modifyColVal = CommandParser.getColumnData(input).get(3);
            List<IOption> optionsList = getOptionList(CommandParser.getOption(input), searchColName, searchColVal);

            printLog("sSearchColName: " + sSearchColName + ", searchColVal: " + searchColVal
                    + ", sModifyColName: " + sModifyColName + ", modifyColVal: " + modifyColVal
                    + ", optionsList: " + Arrays.toString(optionsList.toArray()));

            List<Employee> employeesToMod = database.sch(searchColName, searchColVal);
            OptionHandler optionHandler = new OptionHandler();
            List<Employee> employeesToModifyFiltered = optionHandler.processOptions(cmd, optionsList, searchColName, employeesToMod);

            database.mod(employeesToModifyFiltered, modifyColName, modifyColVal);

            return optionHandler.toString();
        }
    };

    public abstract String run(String input, Database database);

    private static IColumn getColumnType(String sColName) {
        switch (sColName) {
            case "employeeNum":
                return new ColumnEmployeeNum();
            case "name":
                return new ColumnName();
            case "cl":
                return new ColumnCl();
            case "phoneNum":
                return new ColumnPhoneNum();
            case "birthday":
                return new ColumnBirthday();
            case "certi":
                return new ColumnCerti();
            default:
                throw new IllegalArgumentException("Cannot parse column type from input: " + sColName);
        }
    }

    private static List<IOption> getOptionList(List<String> optionStringList, IColumn column, String compareString ) {
        List<IOption> optionTypeList = new ArrayList<IOption>();

        for (String optionString : optionStringList) {
            if (optionString.equals("")) {
                optionTypeList.add(new EmptyOption());
                continue;
            }

            if (optionString.equals("-p")) {
                optionTypeList.add(new PrintOption());
                continue;
            }

            if (optionString.equals("-f")) {
                optionTypeList.add(new FirstNameOption(compareString));
                continue;
            }

            if (optionString.equals("-l")) {
                if (column instanceof ColumnName){
                    optionTypeList.add(new LastNameOption(compareString));
                    continue;
                }

                if (column instanceof ColumnPhoneNum){
                    optionTypeList.add(new LastNumberOption(compareString));
                    continue;
                }
            }

            if (optionString.equals("-m")) {
                if (column instanceof ColumnPhoneNum){
                    optionTypeList.add(new MiddleNumberOption(compareString));
                    continue;
                }

                if (column instanceof ColumnBirthday){
                    optionTypeList.add(new BirthMonthOption(compareString));
                    continue;
                }
            }

            if (optionString.equals("-y")) {
                optionTypeList.add(new BirthYearOption(compareString));
                continue;
            }

            if (optionString.equals("-d")) {
                optionTypeList.add(new BirthDayOption(compareString));
                continue;
            }

            throw new IllegalArgumentException("Cannot parse option type from input: " + optionString);
        }

        return optionTypeList;
    }

    private static void printLog(String log) {
        if (IS_DEBUG_MODE) {
            System.out.println(log);
        }
    }
}
