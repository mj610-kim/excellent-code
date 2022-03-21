public interface OutputWriter {
    boolean open();
    boolean close();
    boolean setNextLine(String line);
}
