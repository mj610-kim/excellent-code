import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ExampleTest {

    @BeforeEach
    public void setUp() {
        openMocks(this);
        System.out.println("setUp()");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    public void exampleTest() {
        System.out.println("exampleTest()");
        assertEquals(1, 1);
        assertNotEquals(1, 2);
    }

}
