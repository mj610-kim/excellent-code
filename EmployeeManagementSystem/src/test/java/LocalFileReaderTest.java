import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalFileReaderTest {

    InputReader localFileReaderUnderTest;

    @BeforeEach
    public void setUp() {
        localFileReaderUnderTest = new LocalFileReader();
    }

    @AfterEach
    public void tearDown() {
        localFileReaderUnderTest = null;
    }

    @Test
    public void getNextLine() {

    }

}
