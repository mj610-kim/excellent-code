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

    private static final boolean IS_DEBUG_MODE = false;

    private final String inputFile;
    private final String outputFile;
    private final Database database;

    public CommandHandler(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.database = new Database();
    }

    public void run() {
        InputReader localFileReader = new LocalFileReader(inputFile);
        localFileReader.open();

        OutputWriter localFileWriter = new LocalFileWriter(outputFile);
        localFileWriter.open();

        try {
            runCore(localFileReader, localFileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            localFileReader.close();
            localFileWriter.close();
        }
    }

    public void runCore(InputReader inputReader, OutputWriter outputWriter) throws IOException {
        while (true) {
            String input = inputReader.getNextLine();
            if (input == null) {
                return;
            }

            String output = handleInput(input);
            printLog("output: " + output);
            if (output != null) {
                outputWriter.setNextLine(output);
            }
        }
    }

    private String handleInput(String input) {
        printLog("input: " + input);
        String cmd = CommandParser.getCommand(input);

        switch (cmd) {
            case "ADD":
                handleAddCmd(input);
                return null;
            case "DEL":
                return handleDelCmd(input);
            case "SCH":
                return handleSchCmd(input);
            case "MOD":
                return handleModCmd(input);
            default:
                throw new IllegalArgumentException("Unexpected cmd...");
        }
    }

    private void handleAddCmd(String input) {
        Employee employee = CommandParser.getEmployee(input);
        printLog("cmd: ADD, employee: " + employee);
        database.add(employee);
    }

    private String handleDelCmd(String input) {
        String cmd = CommandParser.getCommand(input);
        List<String> employees = CommandParser.getColumnData(input);
        printLog("cmd: DEL, employees: " + Arrays.toString(employees.toArray()));

        String sColName = CommandParser.getColumnData(input).get(0);
        IColumn colName = getColumnType(sColName);
        String colVal = CommandParser.getColumnData(input).get(1);
        List<String> optionsList = CommandParser.getOption(input);

        printLog("sColName: " + sColName + ", colVal: " + colVal
                + ", optionsList: " + Arrays.toString(optionsList.toArray()));

        List<Employee> employeesToDelete = database.sch(colName, colVal);
        OptionHandler optionHandler = new OptionHandler();
        List<Employee> employeesToDeleteFiltered = optionHandler.processOptions(cmd, optionsList, sColName, colVal,
                employeesToDelete);

        database.del(employeesToDeleteFiltered);

        return optionHandler.toString();
    }

    private String handleSchCmd(String input) {
        String cmd = CommandParser.getCommand(input);
        List<String> employees = CommandParser.getColumnData(input);
        printLog("cmd: SCH, employees: " + Arrays.toString(employees.toArray()));

        String sColName = CommandParser.getColumnData(input).get(0);
        IColumn colName = getColumnType(sColName);
        String colVal = CommandParser.getColumnData(input).get(1);
        List<String> optionsList = CommandParser.getOption(input);

        printLog("sColName: " + sColName + ", colVal: " + colVal
                + ", optionsList: " + Arrays.toString(optionsList.toArray()));

        List<Employee> employeesToSearch = database.sch(colName, colVal);
        OptionHandler optionHandler = new OptionHandler();
        optionHandler.processOptions(cmd, optionsList, sColName, colVal, employeesToSearch);

        return optionHandler.toString();
    }

    private String handleModCmd(String input) {
        String cmd = CommandParser.getCommand(input);
        List<String> employees = CommandParser.getColumnData(input);
        printLog("cmd: MOD, employees: " + Arrays.toString(employees.toArray()));

        String sSearchColName = CommandParser.getColumnData(input).get(0);
        IColumn searchColName = getColumnType(sSearchColName);
        String searchColVal = CommandParser.getColumnData(input).get(1);
        String sModifyColName = CommandParser.getColumnData(input).get(2);
        IColumn modifyColName = getColumnType(sModifyColName);
        String modifyColVal = CommandParser.getColumnData(input).get(3);
        List<String> optionsList = CommandParser.getOption(input);

        printLog("sSearchColName: " + sSearchColName + ", searchColVal: " + searchColVal
                + ", searchColName: " + sModifyColName + ", sModifyColName: " + modifyColVal
                + ", modifyColVal: " + Arrays.toString(optionsList.toArray()));

        List<Employee> employeesToMod = database.sch(searchColName, searchColVal);
        OptionHandler optionHandler = new OptionHandler();
        List<Employee> employeesToModifyFiltered = optionHandler.processOptions(cmd, optionsList, sModifyColName,
                modifyColVal, employeesToMod);

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

    private void printLog(String log) {
        if (IS_DEBUG_MODE) {
            System.out.println(log);
        }
    }
}
