package com.cra08.excellentcode;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Unexpected argument count");
            System.out.println("Exiting...");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        CommandHandler commandHandler = new CommandHandler(inputFile, outputFile);
        commandHandler.run();
    }
}
