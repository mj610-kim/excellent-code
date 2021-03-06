package com.cra08.excellentcode.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class LocalFileReaderTest {

    private static final String[] SAMPLE_INPUT_FILE_LINES = new String[]{
            "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV",
            "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO",
            "ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV",
            "ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO",
            "ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO",
            "ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO",
            "ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO",
            "ADD, , , ,08123556,WN XV,CL1,010-7986-5047,20100614,PRO",
            "ADD, , , ,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV",
            "ADD, , , ,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO",
            "ADD, , , ,14130827,RPO JK,CL4,010-3231-1698,20090201,ADV",
            "ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO",
            "ADD, , , ,08108827,RTAH VNUP,CL4,010-9031-2726,19780417,ADV",
            "ADD, , , ,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV",
            "ADD, , , ,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV",
            "ADD, , , ,10127115,KBU MHU,CL3,010-3284-4054,19660814,ADV",
            "ADD, , , ,12117017,LFIS JJIVL,CL1,010-7914-4067,20120812,PRO",
            "ADD, , , ,11125777,TKOQKIS HC,CL1,010-6734-2289,19991001,PRO",
            "ADD, , , ,11109136,QKAHCEX LTODDO,CL4,010-2627-8566,19640130,PRO",
            "ADD, , , ,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO",
            "SCH,-p,-d, ,birthday,04", "MOD,-p, , ,name,FB NTAWR,birthday,20050520",
            "SCH, , , ,employeeNum,79110836", "DEL, , , ,employeeNum,18115040",
            "DEL,-p,-l, ,name,MPOSXU", "SCH,-p, , ,certi,PRO", "SCH, , , ,certi,ADV",
            "SCH,-p, , ,cl,CL4", "SCH, ,-m, ,birthday,09", "MOD,-p, , ,name,FB NTAWR,cl,CL3",
            "MOD,-p, , ,employeeNum,08123556,birthday,20110706", "SCH,-p,-y, ,birthday,2003",
            "SCH,-p, , ,employeeNum,05101762", "SCH,-p,-m, ,phoneNum,3112",
            "SCH,-p,-l, ,phoneNum,4605", "SCH,-p, , ,employeeNum,10127115",
            "MOD,-p, , ,phoneNum,010-8900-1478,certi,PRO", "SCH, ,-f, ,name,LDEXRI",
            "MOD, , , ,name,VCUHLE HMU,birthday,19910808", "SCH, , , ,name,FB NTAWR"
    };
    private static final String SAMPLE_INPUT_FILE_NAME = "input.txt";

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryInputFile;

    private InputReader localFileReaderUnderTest;

    @Before
    public void setUp() throws IOException {
        createTemporaryInputFile("com.cra08.excellentcode.io.LocalFileReaderTest", SAMPLE_INPUT_FILE_NAME);
        localFileReaderUnderTest = new LocalFileReader(temporaryInputFile.getPath());
    }

    @After
    public void tearDown() {
        localFileReaderUnderTest.close();
        localFileReaderUnderTest = null;
    }

    @Test
    public void open() {
        assertTrue(localFileReaderUnderTest.open());
    }

    @Test
    public void open_illegalFilePath() {
        localFileReaderUnderTest = new LocalFileReader("!@#$%^&*()_+<>\\/'\"");
        assertFalse(localFileReaderUnderTest.open());
    }

    @Test
    public void close() {
        localFileReaderUnderTest.open();
        assertTrue(localFileReaderUnderTest.close());
    }

    @Test
    public void close_fileAlreadyClosed() {
        localFileReaderUnderTest.open();
        assertTrue(localFileReaderUnderTest.close());
        assertFalse(localFileReaderUnderTest.close());
    }

    @Test
    public void getNextLine() throws IOException {
        localFileReaderUnderTest.open();

        for (String line : SAMPLE_INPUT_FILE_LINES) {
            assertEquals(line, localFileReaderUnderTest.getNextLine());
        }
        assertNull(localFileReaderUnderTest.getNextLine());
    }

    @Test
    public void getNextLine_beforeOpening() {
        assertThrows(NullPointerException.class, () -> localFileReaderUnderTest.getNextLine());
    }

    private void createTemporaryInputFile(String folderName, String fileName) throws IOException {
        File temporaryDirectory = temporaryFolder.newFolder(folderName);
        temporaryInputFile = new File(temporaryDirectory, fileName);

        FileWriter fileWriter = new FileWriter(temporaryInputFile);
        for (String line : SAMPLE_INPUT_FILE_LINES) {
            fileWriter.write(line);
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.close();
    }

}
