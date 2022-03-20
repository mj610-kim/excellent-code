import java.io.IOException;

public class LocalFileReader implements InputReader {

    String inputFilePath;

    public LocalFileReader(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public String getNextLine() throws IOException {
        return null;
    }

}
