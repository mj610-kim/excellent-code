package com.cra08.excellentcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String INPUT_OUTPUT_FILE_NAME_MATCHER = "^[a-z](?:_?[a-z0-9]+)*(\\.)(txt)$";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Unexpected argument count");
            System.out.println("Exiting...");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        if (!isFileNameAllowed(inputFile) || !isFileNameAllowed(outputFile)) {
            System.out.println("Illegal file name");
            System.out.println("Exiting...");
            return;
        }

        CommandHandler commandHandler = new CommandHandler(inputFile, outputFile);
        commandHandler.run();
    }

    private static boolean isFileNameAllowed(String fileName) {
        Pattern pattern = Pattern.compile(INPUT_OUTPUT_FILE_NAME_MATCHER, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileName);
        return matcher.find();
    }

}
