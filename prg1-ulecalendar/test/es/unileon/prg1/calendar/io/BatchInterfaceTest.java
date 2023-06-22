package es.unileon.prg1.calendar.io;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.calendar.Calendar;
import es.unileon.prg1.calendar.date.DateException;
import es.unileon.prg1.calendar.date.TimeException;
import es.unileon.prg1.calendar.events.EventException;
import es.unileon.prg1.calendar.users.UserException;

public class BatchInterfaceTest {
	
	private BatchInterface io;
	private String rightCalendar;
	private String wrongUserCalendar;
	private String wrongEventCalendar;
	private String wrongDateCalendar;	
	private String wrongTimeCalendar;	
	private String wrongElementCalendar;	

	@Before
	public void setUp() throws Exception {
		this.rightCalendar = "./test/rightCalendar.txt";
		this.wrongUserCalendar = "./test/wrongUserCalendar.txt";
		this.wrongEventCalendar = "./test/wrongEventCalendar.txt";
		this.wrongDateCalendar = "./test/wrongDateCalendar.txt";
		this.wrongTimeCalendar = "./test/wrongTimeCalendar.txt";
		this.wrongElementCalendar = "./test/wrongElementCalendar.txt";
		this.io = new BatchInterface(this.rightCalendar);
	}

	@Test
	public void testBatchInterface() {
		assertEquals(this.rightCalendar, io.getFileName());
	}

	@Test
	public void testCreateCalendar() throws UserException, DateException, EventException, TimeException, FileException {
		Calendar calendar;
		calendar = this.io.createCalendar();
		assertEquals( "CALENDAR\n"
				+ "Alex Archer (alea)\n"
				+ "Event: Class en ULE: 11/11/2011 09:00 - 13:00\n"
				+ "Event: Meeting en MIC: 11/11/2011 13:00 - 14:00\n"
				+ "Event: Lunch en Cafeteria: 11/11/2011 14:00 - 15:00\n"
				+ "\n"
				+ "Bonnie Bird (bonb)\n"
				+ "Event: Class en ULE: 11/11/2011 15:00 - 19:00\n"
				+ "Event: Meeting en Library: 11/11/2011 13:00 - 14:00\n"
				+ "\n"
				+ "Colin Cook (colc)"
				, calendar.toString());
	}
	
	@Test (expected = UserException.class)
	public void testMalformedUser() throws UserException, DateException, EventException, TimeException, FileException {
		this.io = new BatchInterface(this.wrongUserCalendar);
		this.io.createCalendar();		
	}

	@Test (expected = EventException.class)
	public void testMalformedEvent() throws UserException, DateException, EventException, TimeException, FileException {
		this.io = new BatchInterface(this.wrongEventCalendar);
		this.io.createCalendar();		
	}

	@Test (expected = DateException.class)
	public void testMalformedDate() throws UserException, DateException, EventException, TimeException, FileException {
		this.io = new BatchInterface(this.wrongDateCalendar);
		this.io.createCalendar();				
	}

	@Test (expected = TimeException.class)
	public void testMalformedTime() throws UserException, DateException, EventException, TimeException, FileException {
		this.io = new BatchInterface(this.wrongTimeCalendar);
		this.io.createCalendar();						
	}

	@Test (expected = FileException.class)
	public void testMalformedElement() throws UserException, DateException, EventException, TimeException, FileException {
		this.io = new BatchInterface(this.wrongElementCalendar);
		this.io.createCalendar();						
	}

}
