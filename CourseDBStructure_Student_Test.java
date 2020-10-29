package ass_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class tests readFile method. It reads it and writes it in to an ArrayList.
 * 
 * @author Student Zuyi Ding
 */
public class CourseDBStructure_Student_Test {
    private CourseDBManagerInterface dataMgr = new CourseDBManager();

    /**
     * Create an instance of CourseDBManager
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	dataMgr = new CourseDBManager();

    }

    /**
     * Set dataMgr reference to null
     * 
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	dataMgr = null;
    }

    /**
     * Test read method
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testRead() throws FileNotFoundException {
	// Sample file course.txt copied from assigment 4

// 0	CMSC100 21551 2 Distance-Learning Janet Joy 
// 1	CMSC100 22352 2 SW217 Gloria Barron	 
// 2    CMSC100 22953 2 Distance-Learning Janet Joy
// 3	CMSC110 21554 3 SC451 Rabiha Kayed
// 4	CMSC110 20455 3 HT300 Madhvi Shah 	
// 5	CMSC110 23356 3 SC451 Sascha Simkanich 	
// 6	CMSC110 21557 3 Distance-Learning Janet Joy
// 7	CMSC110 21558 3 SC451 Behzad Maghami
// 8	CMSC110 21559 3 SC450 Behzad Maghami
	/*
	 * course.txt is located in the same package ass_4 under \src folder. 
	 * Please change to your package name in order to find the file.
	 */
	File file = new File(".\\src\\ass_4\\courses.txt");  // locates the file

	CourseDBManager db = new CourseDBManager();

	db.readFile(file); // reads and writes in to ArrayList CDBFile

	assertEquals(9, db.CDBFile.size());
	
	String line0 = "CMSC100 21551 2 Distance-Learning Janet Joy";
	assertEquals(line0, db.CDBFile.get(0));
	
	String line8 = "CMSC110 21559 3 SC450 Behzad Maghami";
	assertEquals(line8, db.CDBFile.get(8));
	
    }
}
