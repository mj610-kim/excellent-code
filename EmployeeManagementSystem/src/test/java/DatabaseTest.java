import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DatabaseTest {
    @Mock
    Database mockDB;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTest(){
        when(mockDB.add("18050301")).thenReturn(true);
        assertTrue(mockDB.add("18050301"));
    }

    @Test
    void delTest(){
        when(mockDB.del("18050301")).thenReturn(true);
        assertTrue(mockDB.del("18050301"));
    }

    @Test
    void schTest(){
        when(mockDB.sch("18050301")).thenReturn(true);
        assertTrue(mockDB.sch("18050301"));
    }

    @Test
    void modTest(){
        when(mockDB.mod("18050301", "18050101")).thenReturn(true);
        assertTrue(mockDB.mod("18050301", "18050101"));
    }
}