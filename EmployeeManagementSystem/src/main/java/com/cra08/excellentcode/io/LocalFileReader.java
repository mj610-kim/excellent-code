package com.cra08.excellentcode.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LocalFileReader implements InputReader {

    private final String inputFilePath;
    private BufferedReader bufferedReader;

    public LocalFileReader(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public boolean open() {
        if (bufferedReader != null) {
            System.out.println("File is already open...");
            return false;
        }

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file...");
            return false;
        }

        return true;
    }

    @Override
    public boolean close() {
        if (bufferedReader == null) {
            System.out.println("File is not opened...");
            return false;
        }

        try {
            bufferedReader.close();
            bufferedReader = null;
        } catch (IOException e) {
            System.out.println("IOException while trying to close file...");
            return false;
        }

        return true;
    }

    @Override
    public String getNextLine() throws IOException {
        return bufferedReader.readLine();
    }

}
