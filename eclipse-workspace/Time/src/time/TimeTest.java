package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated  properly", seconds==18305);
	}
	
	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows( StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test 
	public void testGetTotalSecondsBoundaryUpper()
	{
		int seconds = Time.getTotalSeconds("02:00:00");
		assertTrue("The seconds were not calculated  properly", seconds==7200);
	}
	
	@Test 
	public void testGetTotalSecondsBoundaryLower()
	{
		int seconds = Time.getTotalSeconds("02:59:59");
		assertTrue("The seconds were not calculated  properly", seconds==10799);
	}
	

	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05");
		assertTrue("The seconds were not calculated  properly", seconds==5);
	
	}

	@Test
	void testGetSecondsBad() {
		assertThrows( StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalSeconds("10:00");});
	}

	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("05:05:59");
		assertTrue("The seconds were not calculated  properly", seconds==59);
	}

	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05");
		assertTrue("The minutes were not calculated  properly", minutes==05);
	
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows( NumberFormatException.class, 
				 ()-> {Time.getTotalMinutes("05:uu:00");});
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("05:05:59");
		assertTrue("The minutes were not calculated  properly", minutes==05);
	}

	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("05:05:05");
		assertTrue("The hours were not calculated  properly", hours==05);
	
	}


	@Test
	void testGetTotalHoursBad() {
		assertThrows( StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalHours("");});
	}


	@Test
	void testGetTotalHoursBoundary() {
		int hours = Time.getTotalHours("05:59:59");
		assertTrue("The hours were not calculated  properly", hours==05);
	}
	
	void testGetMilliSecondsGood() {
		int milliseconds = Time.getSeconds("01:05:55:005");
		assertTrue("The Milliseconds were not calculated properly", milliseconds == 5);
	}

	void testGetMilliSecondsBad() {
		assertThrows( NumberFormatException.class, 
				 ()-> {Time.getSeconds("05:00:00:abc");});
	}
	
    void testGetMilliSecondsBoundary() {
    	int milliseconds = Time.getSeconds("01:05:55:999");
		assertTrue("The Milliseconds were not calculated properly", milliseconds == 999);
    }

}
