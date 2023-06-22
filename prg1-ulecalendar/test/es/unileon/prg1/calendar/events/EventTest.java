package es.unileon.prg1.calendar.events;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.calendar.date.Date;
import es.unileon.prg1.calendar.date.DateException;
import es.unileon.prg1.calendar.date.Time;
import es.unileon.prg1.calendar.date.TimeException;
import es.unileon.prg1.calendar.users.User;
import es.unileon.prg1.calendar.users.UserException;

public class EventTest {

	private Event eventClass, eventMeeting, eventConference;
	private Place ule;
	private Date date;
	private Time startTime, endTime;

	@Before
	public void setUp() throws Exception {
		this.ule = new Place("ULE");
		this.date = new Date(11, 11, 2011);
		this.startTime = new Time(9, 00);
		this.endTime = new Time(13, 00);
		this.eventClass = new Event("Class", this.ule, this.date, this.startTime, this.endTime);
		this.eventMeeting = new Event("EVENT alea Meeting MIC 11/11/2011 13:00 14:00");
		this.eventConference = new Event("EVENT alea Conference MIC 10/11/2011 13:00 14:00");
	}

	@Test
	public void testEventStringPlaceDateTimeTime() {
		assertEquals("Class", this.eventClass.getName());
		assertEquals("ULE", this.eventClass.getPlace().getName());
		assertEquals("11/11/2011", this.eventClass.getDate().toString());
		assertEquals("09:00", this.eventClass.getStartTime().toString());
		assertEquals("13:00", this.eventClass.getEndTime().toString());
	}

	@Test(expected = EventException.class)
	public void testEventStringPlaceDateDateStartAfterEnd() throws EventException, DateException, TimeException {
		new Event("Class", this.ule, this.date, this.endTime, this.startTime);
	}

	@Test(expected = EventException.class)
	public void testEventStringWrongNumberOfFields() throws EventException, DateException, TimeException {
		new Event("EVENT Meeting MIC 11/11/2011 13:00 14:00");
	}

	@Test(expected = EventException.class)
	public void testEventStringWrongStartAfterEnd() throws EventException, DateException, TimeException {
		new Event("EVENT alea Meeting MIC 11/11/2011 15:00 14:00");
	}

	@Test
	public void testGetName() {
		assertEquals("Class", this.eventClass.getName());
	}

	@Test
	public void testGetSetPlace() {
		assertEquals("ULE", this.eventClass.getPlace().toString());
		this.eventClass.setPlace(new Place("USAL"));
		assertEquals("USAL", this.eventClass.getPlace().toString());
	}

	@Test
	public void testGetSetDate() throws DateException, TimeException {
		assertEquals("11/11/2011", this.eventClass.getDate().toString());
		this.eventClass.setDate(new Date(12, 11, 2011));
		assertEquals("12/11/2011", this.eventClass.getDate().toString());
	}
	
	@Test
	public void testGetSetStartTime() throws DateException, TimeException {
		assertEquals("09:00", this.eventClass.getStartTime().toString());
		this.eventClass.setStartTime(new Time(10, 00));
		assertEquals("10:00", this.eventClass.getStartTime().toString());
	}
	
	@Test
	public void testGetSetEndTime() throws DateException, TimeException {
		assertEquals("13:00", this.eventClass.getEndTime().toString());
		this.eventClass.setEndTime(new Time(14, 00));
		assertEquals("14:00", this.eventClass.getEndTime().toString());
	}

	@Test
	public void testIsSame() {
		assertTrue(this.eventClass.isSame("Class"));
		assertFalse(this.eventClass.isSame("Meeting"));
	}

	@Test
	public void testIsAfter() {
		// different days
		assertTrue(this.eventMeeting.isAfter(eventConference));
		assertFalse(this.eventConference.isAfter(eventMeeting));
		// same day
		assertTrue(this.eventMeeting.isAfter(eventClass));
		assertFalse(this.eventClass.isAfter(eventMeeting));
	}

	@Test
	public void testToString() {
		assertEquals("Event: Class en ULE: 11/11/2011 09:00 - 13:00", this.eventClass.toString());
	}

	@Test
	public void testToFile() {
		assertEquals("EVENT alea Class ULE 11/11/2011 09:00 13:00", this.eventClass.toFile("alea"));
	}
}
