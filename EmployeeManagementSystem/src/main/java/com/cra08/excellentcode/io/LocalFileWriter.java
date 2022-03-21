package com.cra08.excellentcode.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LocalFileWriter implements OutputWriter {

    private final String outputFilePath;
    private BufferedWriter bufferedWriter;

    public LocalFileWriter(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public boolean open() {
        if (bufferedWriter != null) {
            System.out.println("File is already open...");
            return false;
        }

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));
        } catch (IOException e) {
            System.out.println("Failed to open file...");
            return false;
        }

        return true;
    }

    @Override
    public boolean close() {
        if (bufferedWriter == null) {
            System.out.println("File is not opened...");
            return false;
        }

        try {
            bufferedWriter.close();
            bufferedWriter = null;
        } catch (IOException e) {
            System.out.println("IOException while trying to close file...");
            return false;
        }

        return true;
    }

    @Override
    public boolean setNextLine(String line) {
        try {
            bufferedWriter.write(line);
            bufferedWriter.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("IOException while trying to write to file...");
            return false;
        }

        return true;
    }

}
