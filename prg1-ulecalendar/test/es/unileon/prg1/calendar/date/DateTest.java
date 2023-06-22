package es.unileon.prg1.calendar.date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {

    Date today;
    String line;

    @Before
    public void setUp() throws Exception {
        this.today = new Date(1, 1, 2017);
        this.line = "01/01/2017";
    }

    @Test
    public void testDateIntIntInt() throws DateException {
        assertEquals(1, this.today.getDay());
        assertEquals(1, this.today.getMonth());
        assertEquals(2017, this.today.getYear());
    }

    @Test(expected = DateException.class)
    public void testDateNegativeDay() throws DateException {
        new Date(-1, 1, 2017);
    }

    @Test(expected = DateException.class)
    public void testDateNegativeMonth() throws DateException {
        new Date(1, -1, 2017);
    }

    @Test(expected = DateException.class)
    public void testDateMonthOutOfRange() throws DateException {
        new Date(1, 13, 2017);
    }

    @Test(expected = DateException.class)
    public void testDateWrongDayMonth() throws DateException {
        new Date(31, 2, 2017);
    }

    @Test(expected = DateException.class)
    public void testDateNegativeYear() throws DateException {
        new Date(1, 1, -1);
    }

    @Test
    public void testDateString() {
        assertEquals(1, this.today.getDay());
        assertEquals(1, this.today.getMonth());
        assertEquals(2017, this.today.getYear());    	
    }
  
    @Test(expected = DateException.class)
    public void testDateLineNegativeDay() throws DateException {
    	this.line = "-1/01/2017";
    	new Date(this.line);
    }

    @Test(expected = DateException.class)
    public void testDateLineNegativeMonth() throws DateException {
    	this.line = "1/-1/2017";
    	new Date(this.line);
    }

    @Test(expected = DateException.class)
    public void testDateLineMonthOutOfRange() throws DateException {
    	this.line = "01/13/2017";
    	new Date(this.line);
    }

    @Test(expected = DateException.class)
    public void testDateLineWrongDayMonth() throws DateException {
    	this.line = "31/02/2017";
    	new Date(this.line);
    }

    @Test(expected = DateException.class)
    public void testDateLineNegativeYear() throws DateException {
    	this.line = "1/1/-1";
    	new Date(this.line);
    }

    @Test(expected = DateException.class)
    public void testDateLineNotNumbers() throws DateException {
    	this.line = "1/1/Y";
    	new Date(this.line);
    }

    @Test
    public void testSetGetDay() throws DateException {
        assertEquals(1, this.today.getDay());
        this.today.setDay(2);
        assertEquals(2, this.today.getDay());
    }

    @Test(expected = DateException.class)
    public void testSetDayNegativeDay() throws DateException {
        this.today.setDay(-1);
    }

    @Test(expected = DateException.class)
    public void testSetDayWrongDayMonth() throws DateException {
        this.today.setMonth(4);
        this.today.setDay(31);
    }

    @Test
    public void testSetGetMonth() throws DateException {
        assertEquals(1, this.today.getMonth());
        this.today.setMonth(2);
        assertEquals(2, this.today.getMonth());
    }

    @Test(expected = DateException.class)
    public void testSetMonthNegative() throws DateException {
        this.today.setMonth(-1);
    }

    @Test(expected = DateException.class)
    public void testSetMonthOutOfRange() throws DateException {
        this.today.setMonth(13);
    }

    @Test
    public void testSetGetYear() throws DateException {
        assertEquals(2017, this.today.getYear());
        this.today.setYear(2013);
        assertEquals(2013, this.today.getYear());
    }

    @Test(expected = DateException.class)
    public void testSetYearNegative() throws DateException {
        this.today.setYear(-1);
    }

    @Test
    public void testIsSame() throws DateException {
        Date aDay = new Date(1, 1, 2017);
        assertEquals(true, this.today.isSame(aDay));
    }

    @Test
    public void testIsSameNotDay() throws DateException {
        Date aDay = new Date(10, 1, 2017);
        assertEquals(false, this.today.isSame(aDay));
    }

    @Test
    public void testIsSameNotMonth() throws DateException {
        Date aDay = new Date(1, 10, 2017);
        assertEquals(false, this.today.isSame(aDay));
    }

    @Test
    public void testIsSameNotYear() throws DateException {
        Date aDay = new Date(1, 1, 2010);
        assertEquals(false, this.today.isSame(aDay));
    }

    @Test
    public void testIsSameNotDayNotMonthNotYear() throws DateException {
        Date aDay = new Date(3, 3, 2013);
        assertEquals(false, this.today.isSame(aDay));
    }

    @Test
    public void testIsAfterYear() throws DateException {
        Date other = new Date(1, 1, 2016);
        assertTrue(this.today.isAfter(other));
    }

    @Test
    public void testIsAfterMonth() throws DateException {
        this.today.setMonth(2);
        Date other = new Date(1, 1, 2017);
        assertTrue(this.today.isAfter(other));
    }

    @Test
    public void testIsAfterDay() throws DateException {
        this.today.setDay(2);
        Date other = new Date(1, 1, 2017);
        assertTrue(this.today.isAfter(other));
    }

    @Test
    public void testIsAfterNoYear() throws DateException {
        Date other = new Date(1, 1, 2018);
        assertFalse(this.today.isAfter(other));
    }

    @Test
    public void testIsAfterNoMonth() throws DateException {
        Date other = new Date(1, 2, 2017);
        assertFalse(this.today.isAfter(other));
    }

    @Test
    public void testIsAfterNoDay() throws DateException {
        Date other = new Date(2, 1, 2017);
        assertFalse(this.today.isAfter(other));
    }

    @Test
    public void testIsAfterNoSame() throws DateException {
        Date other = new Date(1, 1, 2017);
        assertFalse(this.today.isAfter(other));
    }

    @Test
    public void testToString() throws DateException {
        assertEquals("1/1/2017", this.today.toString());
        this.today.setDay(25);
        this.today.setMonth(8);
        this.today.setYear(2017);
        assertEquals("25/8/2017", this.today.toString());
    }

}