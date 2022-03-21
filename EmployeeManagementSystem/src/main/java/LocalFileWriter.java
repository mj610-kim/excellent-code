public class LocalFileWriter implements OutputWriter {

    private final String outputFilePath;

    public LocalFileWriter(String outputFilePath) {
        this.outputFilePath = outputFilePath;
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
    public boolean setNextLine(String line) {
        return false;
    }

}
