package com.cra08.excellentcode;

import com.cra08.excellentcode.datatype.Cmd;
import com.cra08.excellentcode.io.InputReader;
import com.cra08.excellentcode.io.LocalFileReader;
import com.cra08.excellentcode.io.LocalFileWriter;
import com.cra08.excellentcode.io.OutputWriter;
import com.cra08.excellentcode.optionhandler.OptionHandler;
import com.cra08.excellentcode.storage.Database;
import java.io.IOException;


public class CommandHandler {

    public static final boolean IS_DEBUG_MODE = true;

    private final String inputFile;
    private final String outputFile;
    private final Database database;

    private static final OptionHandler optionHandler = new OptionHandler();

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

        String sCmd = CommandParser.getCommand(input);
        Cmd cmd = Cmd.valueOf(sCmd);
        return cmd.run(input, database);
    }

    private void printLog(String log) {
        if (IS_DEBUG_MODE) {
            System.out.println(log);
        }
    }
}
