package es.unileon.prg1.calendar.date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {

    Time time;
    String line;

    @Before
    public void setUp() throws Exception {
        this.time = new Time(9, 30);
        this.line = "09:30";
    }

    @Test
    public void testTimeIntInt() throws TimeException {
        assertEquals(9, this.time.getHour());
        assertEquals(30, this.time.getMinute());
    }

    @Test(expected = TimeException.class)
    public void testTimeNegativeHour() throws TimeException {
        new Time(-1, 30);
    }

    @Test(expected = TimeException.class)
    public void testTime24Hour() throws TimeException {
        new Time(24, 30);
    }
    
    @Test(expected = TimeException.class)
    public void testTimeNegativeMinute() throws TimeException {
        new Time(9, -1);
    }

    @Test(expected = TimeException.class)
    public void testTime61Minute() throws TimeException {
        new Time(9, 61);
    }
    
    @Test
    public void testTimeString() throws TimeException {
        this.time = new Time(this.line);
        assertEquals(9, this.time.getHour());
        assertEquals(30, this.time.getMinute());
    }
    
    @Test(expected = TimeException.class)
    public void testTimeFileNegativeHour() throws TimeException {
        this.line = "-1:30";
        new Time(this.line);
    }

    @Test(expected = TimeException.class)
    public void testTimeFile24Hour() throws TimeException {
        this.line = "24:30";
        new Time(this.line);
    }
    
    @Test(expected = TimeException.class)
    public void testTimeFileNegativeMinute() throws TimeException {
        this.line = "09:-1";
        new Time(this.line);
    }

    @Test(expected = TimeException.class)
    public void testTimeFile61Minute() throws TimeException {
        this.line = "09:61";
        new Time(this.line);
    }
 
    @Test(expected = TimeException.class)
    public void testTimeFileNotNumber() throws TimeException {
        this.line = "09:H";
        new Time(this.line);
    }
 
    @Test
    public void testSetGetHour() throws TimeException {
        assertEquals(9, this.time.getHour());
        this.time.setHour(11);
        assertEquals(11, this.time.getHour());
    }

    @Test
    public void testSetGetMinute() throws TimeException {
        assertEquals(30, this.time.getMinute());
        this.time.setMinute(45);
        assertEquals(45, this.time.getMinute());
    }

    @Test
    public void testIsSame() throws TimeException {
        Time other = new Time(9, 30);
        assertTrue(this.time.isSame(other));
    }

    @Test
    public void testIsSameNoHour() throws TimeException {
        Time other = new Time(10, 30);
        assertFalse(this.time.isSame(other));
    }

    @Test
    public void testIsSameNoMinute() throws TimeException {
        Time other = new Time(9, 31);
        assertFalse(this.time.isSame(other));
    }

    @Test
    public void testIsAfterHour() throws TimeException {
        Time other = new Time(8, 0);
        assertTrue(this.time.isAfter(other));
    }

    @Test
    public void testIsAfterMinute() throws TimeException {
        Time other = new Time(9, 0);
        assertTrue(this.time.isAfter(other));
    }

    @Test
    public void testIsAfterNoHour() throws TimeException {
        Time other = new Time(10, 0);
        assertFalse(this.time.isAfter(other));
    }

    @Test
    public void testIsAfterNoMinute() throws TimeException {
        Time other = new Time(9, 31);
        assertFalse(this.time.isAfter(other));
    }

    @Test
    public void testIsAfterNoSame() throws TimeException {
        Time other = new Time(9, 30);
        assertFalse(this.time.isAfter(other));
    }
    
    @Test
    public void testIsBeforeHour() throws TimeException {
        Time other = new Time(8, 0);
        assertFalse(this.time.isBefore(other));
    }

    @Test
    public void testIsBeforeMinute() throws TimeException {
        Time other = new Time(9, 0);
        assertFalse(this.time.isBefore(other));
    }

    @Test
    public void testIsBeforeNoHour() throws TimeException {
        Time other = new Time(10, 0);
        assertTrue(this.time.isBefore(other));
    }

    @Test
    public void testIsBeforeNoMinute() throws TimeException {
        Time other = new Time(9, 31);
        assertTrue(this.time.isBefore(other));
    }

    @Test
    public void testIsBeforeNoSame() throws TimeException {
        Time other = new Time(9, 30);
        assertFalse(this.time.isBefore(other));
    }
    @Test
    public void testToString() {
    	assertEquals("09:30", this.time.toString());
    }
}