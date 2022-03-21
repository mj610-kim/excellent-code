package com.cra08.excellentcode.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class LocalFileWriterTest {

    private static final String[] SAMPLE_OUTPUT_FILE_LINES = new String[]{
            "SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV",
            "MOD,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO", "SCH,NONE", "DEL,1",
            "DEL,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV",
            "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO",
            "SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO",
            "SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO",
            "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO",
            "SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO", "SCH,6",
            "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO",
            "SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO",
            "SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV",
            "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO",
            "SCH,08108827,RTAH VNUP,CL4,010-9031-2726,19780417,ADV", "SCH,1",
            "MOD,17112609,FB NTAWR,CL4,010-5645-6122,20050520,PRO",
            "MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO",
            "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO",
            "SCH,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO",
            "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO",
            "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV", "SCH,NONE",
            "SCH,10127115,KBU MHU,CL3,010-3284-4054,19660814,ADV",
            "MOD,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV", "SCH,NONE", "MOD,1", "SCH,1"
    };
    private static final String SAMPLE_OUTPUT_FILE_NAME = "output.txt";

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryDirectory;

    private OutputWriter localFileWriterUnderTest;

    @Before
    public void setUp() throws IOException {
        temporaryDirectory = temporaryFolder.newFolder("com.cra08.excellentcode.io.LocalFileWriterTest");
        localFileWriterUnderTest = new LocalFileWriter(temporaryDirectory.getPath() + SAMPLE_OUTPUT_FILE_NAME);
    }

    @After
    public void tearDown() {
        localFileWriterUnderTest.close();
        localFileWriterUnderTest = null;
    }

    @Test
    public void open() {
        assertTrue(localFileWriterUnderTest.open());
    }

    @Test
    public void open_illegalFilePath() {
        localFileWriterUnderTest = new LocalFileWriter("!@#$%^&*()_+<>\\/'\"");
        assertFalse(localFileWriterUnderTest.open());
    }

    @Test
    public void close() {
        localFileWriterUnderTest.open();
        assertTrue(localFileWriterUnderTest.close());
    }

    @Test
    public void close_fileAlreadyClosed() {
        localFileWriterUnderTest.open();
        assertTrue(localFileWriterUnderTest.close());
        assertFalse(localFileWriterUnderTest.close());
    }

    @Test
    public void setNextLine() throws IOException {
        localFileWriterUnderTest.open();
        writeOutput(SAMPLE_OUTPUT_FILE_LINES);
        localFileWriterUnderTest.close();

        verifyFile(temporaryDirectory.getPath() + SAMPLE_OUTPUT_FILE_NAME, SAMPLE_OUTPUT_FILE_LINES);
    }

    private void writeOutput(String[] fileLines) {
        for (String line : fileLines) {
            assertTrue(localFileWriterUnderTest.setNextLine(line));
        }
    }

    private void verifyFile(String filePath, String[] fileLines) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        for (String line : fileLines) {
            assertEquals(line, bufferedReader.readLine());
        }
        assertNull(bufferedReader.readLine());
    }

}
