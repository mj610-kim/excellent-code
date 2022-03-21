package com.cra08.excellentcode;

import com.cra08.excellentcode.column.ColumnBirthday;
import com.cra08.excellentcode.column.ColumnCerti;
import com.cra08.excellentcode.column.ColumnCl;
import com.cra08.excellentcode.column.ColumnEmployeeNum;
import com.cra08.excellentcode.column.ColumnName;
import com.cra08.excellentcode.column.ColumnPhoneNum;
import com.cra08.excellentcode.column.IColumn;
import com.cra08.excellentcode.io.InputReader;
import com.cra08.excellentcode.io.LocalFileReader;
import com.cra08.excellentcode.io.LocalFileWriter;
import com.cra08.excellentcode.io.OutputWriter;
import com.cra08.excellentcode.optionhandler.OptionHandler;
import com.cra08.excellentcode.storage.Database;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CommandHandler {

    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    private Database database;

    public CommandHandler() {
        database = new Database();
    }

    public void run() throws IOException {
        InputReader localFileReader = new LocalFileReader(INPUT_FILE);
        localFileReader.open();

        OutputWriter localFileWriter = new LocalFileWriter(OUTPUT_FILE);
        localFileWriter.open();

        while (true) {
            String input = localFileReader.getNextLine();
            if (input == null) {
                localFileReader.close();
                localFileWriter.close();
                return;
            }
            String output = handleInput(input);
            System.out.println("output: " + output);
            localFileWriter.setNextLine(output);
        }
    }

    private String handleInput(String input) {
        System.out.println("input: " + input);
        String cmd = CommandParser.getCommand(input);
        System.out.println("cmd: " + cmd);

        String result = "TODO: implement this";
        switch (cmd) {
            case "ADD":
                handleAddCmd(input);
                break;
            case "DEL":
                result = handleDelCmd(input);
                break;
            case "SCH":
                result = handleSchCmd(input);
                break;
            case "MOD":
                result = handleModCmd(input);
                break;

        }

        return result;
    }

    private void handleAddCmd(String input) {
        Employee employee = CommandParser.getEmployee(input);
        System.out.println("employee: " + employee);
        database.add(employee);
    }

    private String handleDelCmd(String input) {
        String cmd = CommandParser.getCommand(input);
        List<String> employees = CommandParser.getColumnData(input);
        System.out.println("employee: " + Arrays.toString(employees.toArray()));

        String sColName = CommandParser.getColumnData(input).get(0);
        IColumn colName = getColumnType(sColName);
        String colVal = CommandParser.getColumnData(input).get(1);
        List<String> optionsList = CommandParser.getOption(input);

        System.out.println("sColName: " + sColName + ", colVal: " + colVal + ", optionsList: " + Arrays.toString(optionsList.toArray()));

        List<Employee> employeesToDelete = database.sch(colName, colVal);
        OptionHandler optionHandler = new OptionHandler();
        List<Employee> employeesToDeleteFiltered = optionHandler.processOptions(cmd, optionsList, sColName, colVal, employeesToDelete);

        database.del(employeesToDeleteFiltered);

        return optionHandler.toString();
    }

    private String handleSchCmd(String input) {
        String cmd = CommandParser.getCommand(input);
        List<String> employees = CommandParser.getColumnData(input);
        System.out.println("employee: " + Arrays.toString(employees.toArray()));

        String sColName = CommandParser.getColumnData(input).get(0);
        IColumn colName = getColumnType(sColName);
        String colVal = CommandParser.getColumnData(input).get(1);
        List<String> optionsList = CommandParser.getOption(input);

        System.out.println("sColName: " + sColName + ", colVal: " + colVal + ", optionsList: " + Arrays.toString(optionsList.toArray()));

        List<Employee> employeesToSearch = database.sch(colName, colVal);
        OptionHandler optionHandler = new OptionHandler();
        optionHandler.processOptions(cmd, optionsList, sColName, colVal, employeesToSearch);

        return optionHandler.toString();
    }

    private String handleModCmd(String input) {
        String cmd = CommandParser.getCommand(input);
        List<String> employees = CommandParser.getColumnData(input);
        System.out.println("employee: " + Arrays.toString(employees.toArray()));

        String sSearchColName = CommandParser.getColumnData(input).get(0);
        IColumn searchColName = getColumnType(sSearchColName);
        String searchColVal = CommandParser.getColumnData(input).get(1);
        String sModifyColName = CommandParser.getColumnData(input).get(2);
        IColumn modifyColName = getColumnType(sModifyColName);
        String modifyColVal = CommandParser.getColumnData(input).get(3);
        List<String> optionsList = CommandParser.getOption(input);

        System.out.println("sSearchColName: " + sSearchColName + ", searchColVal: " + searchColVal + ", searchColName: " + sModifyColName + ", sModifyColName: " + modifyColVal + ", modifyColVal: " + Arrays.toString(optionsList.toArray()));

        List<Employee> employeesToMod = database.sch(searchColName, searchColVal);
        OptionHandler optionHandler = new OptionHandler();
        List<Employee> employeesToModifyFiltered = optionHandler.processOptions(cmd, optionsList, sModifyColName, modifyColVal, employeesToMod);

        database.mod(employeesToModifyFiltered, modifyColName, modifyColVal);

        return optionHandler.toString();
    }

    private IColumn getColumnType(String sColName) {
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
}