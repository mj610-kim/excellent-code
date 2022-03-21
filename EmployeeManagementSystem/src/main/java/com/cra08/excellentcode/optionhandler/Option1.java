package com.cra08.excellentcode.optionhandler;

import com.cra08.excellentcode.Employee;
import java.util.List;

public class Option1 {

    private final int maxPrintCnt = 5;

    public String processOption(String commandName, String option, List<Employee> employeeList)
            throws IllegalArgumentException {

        if (employeeList.size() == 0) {
            return (commandName + "," + "NONE");
        }

        if (option.equals("")) {
            return (commandName + "," + employeeList.size());
        }

        if (option.equals("-p")) {
            String resultString = "";

            int printCnt = 0;

            for (Employee employee : employeeList) {
                if (printCnt > 0) {
                    resultString += "\n";
                }

                resultString += (commandName + "," + employee.toString());
                printCnt++;

                if (printCnt >= maxPrintCnt) {
                    break;
                }

            }

            return resultString;
        }

        throw new IllegalArgumentException("Invalid option(" + option + ")");
    }
}
