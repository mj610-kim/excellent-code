package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.column.IColumn;

import java.util.List;

public class OptionHandler {

    private Option1 option1;
    private Option2 option2;
    //private Option3 option3;

    private String outputString;

    public OptionHandler() {
        option1 = new Option1();
        option2 = new Option2();
        //option3 = new Option3();
    }

    public List<Employee> processOptions(String commandName, List<String> optionList, IColumn column, String condition,
                                         List<Employee> employeeList) {
        //List<Employee> filteredEmployeeList = option3.processOption(optionList.get(2), employeeList, column, condition);
        List<Employee> filteredEmployeeList = option2.processOption(optionList.get(1), employeeList, column, condition);
        outputString = option1.processOption(commandName, optionList.get(0), filteredEmployeeList);

        return filteredEmployeeList;
    }

    public String toString() {
        return outputString;
    }
}
