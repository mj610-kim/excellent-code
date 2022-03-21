package com.cra08.excellentcode.io;

public interface OutputWriter {
    boolean open();
    boolean close();
    boolean setNextLine(String line);
}
