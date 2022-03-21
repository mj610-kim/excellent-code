package com.cra08.excellentcode;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, ExcellentCode team!");
        CommandHandler commandHandler = new CommandHandler();
        try {
            commandHandler.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
