import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {

    @Before
    public void setUp() {
        openMocks(this);
        System.out.println("setUp()");
    }

    @After
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
