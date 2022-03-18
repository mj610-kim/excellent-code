import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class LocalFileReaderTest {

    private static final String INPUT_FILE_FIRST_LINE = "this is the first line of input.txt";

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryInputFile;

    private InputReader localFileReaderUnderTest;

    @Before
    public void setUp() throws IOException {
        createTemporaryInputFile();
        localFileReaderUnderTest = new LocalFileReader(temporaryInputFile.getPath());
    }

    @After
    public void tearDown() {
        localFileReaderUnderTest = null;
    }

    @Test
    public void getNextLine() {
        assertEquals(INPUT_FILE_FIRST_LINE, localFileReaderUnderTest.getNextLine());
    }

    private void createTemporaryInputFile() throws IOException {
        File temporaryDirectory = temporaryFolder.newFolder("LocalFileReaderTest");
        temporaryInputFile = new File(temporaryDirectory, "input.txt");

        FileWriter fileWriter = new FileWriter(temporaryInputFile);
        fileWriter.write(INPUT_FILE_FIRST_LINE);
        fileWriter.close();

        checkFileIsCreated();
    }

    private void checkFileIsCreated() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(temporaryInputFile.getPath()));
        String curLine;
        do {
            curLine = br.readLine();
            System.out.println(curLine);
        } while (curLine != null);
    }

}
