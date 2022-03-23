package com.cra08.excellentcode.datatype;

import static com.cra08.excellentcode.CommandHandler.IS_DEBUG_MODE;

import com.cra08.excellentcode.CommandParser;
import com.cra08.excellentcode.Employee;

import com.cra08.excellentcode.storage.Database;

import com.cra08.excellentcode.column.IColumn;

import com.cra08.excellentcode.option.IOption;
import com.cra08.excellentcode.optionhandler.OptionHandler;

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
            List<String> employees = CommandParser.getColumnData(input);
            printLog("cmd: DEL, employees: " + Arrays.toString(employees.toArray()));

            String sColName = CommandParser.getColumnData(input).get(0);
            IColumn colName = CommandParser.getColumnType(sColName);
            String colVal = CommandParser.getColumnData(input).get(1);
            List<IOption> optionsList = CommandParser.getOptionsList(input);

            printLog("sColName: " + sColName + ", colVal: " + colVal
                    + ", optionsList: " + Arrays.toString(optionsList.toArray()));

            List<Employee> employeesToDelete = database.sch(colName, colVal);
            OptionHandler optionHandler = new OptionHandler();

            List<Employee> employeesToDeleteFiltered = optionHandler.processOptions(this.name(), optionsList, colName,
                    employeesToDelete);

            database.del(employeesToDeleteFiltered);

            return optionHandler.toString();
        }
    },
    SCH {
        @Override
        public String run(String input, Database database) {
            List<String> employees = CommandParser.getColumnData(input);
            printLog("cmd: SCH, employees: " + Arrays.toString(employees.toArray()));

            String sColName = CommandParser.getColumnData(input).get(0);
            IColumn colName = CommandParser.getColumnType(sColName);
            String colVal = CommandParser.getColumnData(input).get(1);
            List<IOption> optionsList = CommandParser.getOptionsList(input);

            printLog("sColName: " + sColName + ", colVal: " + colVal
                    + ", optionsList: " + Arrays.toString(optionsList.toArray()));

            List<Employee> employeesToSearch = database.sch(colName, colVal);
            OptionHandler optionHandler = new OptionHandler();
            optionHandler.processOptions(this.name(), optionsList, colName, employeesToSearch);

            return optionHandler.toString();
        }
    },
    MOD {
        @Override
        public String run(String input, Database database) {
            List<String> employees = CommandParser.getColumnData(input);
            printLog("cmd: MOD, employees: " + Arrays.toString(employees.toArray()));

            String sSearchColName = CommandParser.getColumnData(input).get(0);
            IColumn searchColName = CommandParser.getColumnType(sSearchColName);
            String searchColVal = CommandParser.getColumnData(input).get(1);
            String sModifyColName = CommandParser.getColumnData(input).get(2);
            IColumn modifyColName = CommandParser.getColumnType(sModifyColName);
            String modifyColVal = CommandParser.getColumnData(input).get(3);
            List<IOption> optionsList = CommandParser.getOptionsList(input);

            printLog("sSearchColName: " + sSearchColName + ", searchColVal: " + searchColVal
                    + ", sModifyColName: " + sModifyColName + ", modifyColVal: " + modifyColVal
                    + ", optionsList: " + Arrays.toString(optionsList.toArray()));

            List<Employee> employeesToMod = database.sch(searchColName, searchColVal);
            OptionHandler optionHandler = new OptionHandler();
            List<Employee> employeesToModifyFiltered = optionHandler.processOptions(this.name(), optionsList,
                    searchColName, employeesToMod);

            database.mod(employeesToModifyFiltered, modifyColName, modifyColVal);

            return optionHandler.toString();
        }
    };

    public abstract String run(String input, Database database);

    private static void printLog(String log) {
        if (IS_DEBUG_MODE) {
            System.out.println(log);
        }
    }
}
