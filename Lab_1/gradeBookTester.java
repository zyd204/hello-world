import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * JUnit test class to test GradeBook.java. 
 */

public class gradeBookTester {
    
    private GradeBook g1;
    private GradeBook g2;
    
    @Before
    public void setUp() throws Exception {
	
	g1 = new GradeBook(5);
	g1.addScore(50);
	g1.addScore(75);
	g1.addScore(95);
	
	g2 = new GradeBook(9);
	g2.addScore(68);
	g2.addScore(72);
	g2.addScore(80);
	g2.addScore(90);
	
    }

    @After
    public void tearDown() throws Exception {
	
	g1 = null;
	g2 = null;
    }

    /*
     *  Tests a number of scores in an object. 
     */
    @Test
    public void testGetScoreSize() {

	assertEquals(3, g1.getScoreSize());
	
	assertEquals(4, g2.getScoreSize());
	
    }

   
    /*
     *  Tests scores have been added to an object correctly
     */
    @Test
    public void testAddScore() {
		
	// g1 added: 50, 75, and 95. 
	assertTrue(g1.toString().equals("50.0 75.0 95.0 "));
	
	// g2 added 68, 72, 80, 90.
	assertTrue(g2.toString().equals("68.0 72.0 80.0 90.0 "));
	
	assertEquals(3, g1.getScoreSize());
	
	assertEquals(4, g2.getScoreSize());
	
    }


    /*
     *  Tests a sum of scores of an object
     */
    @Test
    public void testSum() {
	
	// g1 sum = 50 + 75 + 95 = 220
	assertEquals(220, g1.sum(), .0001);
	
	// g2 sum = 68 + 72 + 80 + 90 = 310
	assertEquals(310, g2.sum(), .0001);
	
    }

    /*
     *  Tests the minimum score in an object
     */
    @Test
    public void testMinimum() {
	
	assertEquals(50.0, g1.minimum(), .001);
	
	assertEquals(68.0, g2.minimum(), .001);
    }

    /*
     *  Tests a final score of an object
     *  In each object, drops the lowest score, then adds up the rest of scores.
     */
    @Test
    public void testFinalScore() {
	
	// g1 final score is 75 + 95 = 170, the lowest score 50 is dropped
	assertEquals(170, g1.finalScore(), .01);
	
	// g2 final score is 72+80+90 = 242, the lowest score 68 is dropped.
	assertEquals(242, g2.finalScore(), .01);
    }

}
