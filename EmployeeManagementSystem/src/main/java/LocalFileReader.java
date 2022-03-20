import java.io.IOException;

public class LocalFileReader implements InputReader {

    String inputFilePath;

    public LocalFileReader(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public boolean open() {
        return false;
    }

    @Override
    public boolean close() {
        return false;
    }

    @Override
    public String getNextLine() throws IOException {
        return null;
    }

}
