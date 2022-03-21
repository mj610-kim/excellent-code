package com.cra08.excellentcode.io;

import java.io.IOException;

public interface InputReader {
    boolean open();
    boolean close();
    String getNextLine() throws IOException;
}
