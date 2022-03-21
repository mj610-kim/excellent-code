import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

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
