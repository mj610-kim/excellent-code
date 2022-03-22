package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import com.cra08.excellentcode.option.EmptyOption;
import com.cra08.excellentcode.option.IOption;
import com.cra08.excellentcode.option.PrintOption;

import java.util.List;

public class Option1 {

    private String makePrintString(String commandName, List<Employee> employeeList) {
        final int maxPrintCnt = 5;

        String resultString = "";

        int printCnt = 0;

        for (Employee employee : employeeList) {
            if (printCnt > 0) {
                resultString += "\n";
            }

            resultString += (commandName + "," + employee.toString());
            printCnt++;

            if (printCnt >= maxPrintCnt) {
                return resultString;
            }
        }

        return resultString;
    }

    public String processOption(String commandName, IOption option, List<Employee> employeeList)
            throws IllegalArgumentException {

        if (employeeList.size() == 0) {
            return (commandName + "," + "NONE");
        }

        if (option instanceof EmptyOption) {
            return (commandName + "," + employeeList.size());
        }

        if (option instanceof PrintOption) {
            return makePrintString(commandName, employeeList);
        }

        throw new IllegalArgumentException("Invalid option(" + option + ")");
    }
}
