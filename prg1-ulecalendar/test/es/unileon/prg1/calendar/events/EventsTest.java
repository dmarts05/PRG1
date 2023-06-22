package es.unileon.prg1.calendar.events;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.calendar.date.Date;
import es.unileon.prg1.calendar.date.DateException;
import es.unileon.prg1.calendar.date.Time;
import es.unileon.prg1.calendar.date.TimeException;

public class EventsTest {

	private Events localEvents;
	private Event eventClass, eventMeeting, eventLunch;
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
		this.eventLunch = new Event("EVENT alea Lunch Cafeteria 11/11/2011 14:00 15:00");
		this.localEvents = new Events(3);
		this.localEvents.add(this.eventClass);
		this.localEvents.add(this.eventMeeting);
	}

	@Test
	public void testEvents() {
		assertEquals(2, this.localEvents.getNum());
	}

	@Test
	public void testGetNum() throws EventException {
		assertEquals(2, this.localEvents.getNum());
		this.localEvents.add(this.eventLunch);
		assertEquals(3, this.localEvents.getNum());
	}

	@Test
	public void testAdd() throws EventException {
		assertEquals(2, this.localEvents.getNum());
		assertNull(this.localEvents.search("Lunch"));
		this.localEvents.add(this.eventLunch);
		assertEquals(3, this.localEvents.getNum());
		assertNotNull(this.localEvents.search("Lunch"));
	}

	@Test(expected = EventException.class)
	public void testAddNoMoreRoom() throws EventException, DateException, TimeException {
		this.localEvents.add(this.eventLunch);
		this.localEvents.add(new Event("EVENT bonb Study Library 11/11/2011 13:00 14:00"));
	}

	@Test(expected = EventException.class)
	public void testAddRepeatedEvent() throws EventException, DateException {
		this.localEvents.add(this.eventMeeting);
	}

	@Test
	public void testSearch() {
		assertNotNull(this.localEvents.search("Meeting"));
		assertNull(this.localEvents.search("Lunch"));
	}

	@Test
	public void testRemoveString() throws EventException {
		assertEquals(2, this.localEvents.getNum());
		this.localEvents.add(this.eventLunch);
		assertEquals(3, localEvents.getNum());
		assertNotNull(this.localEvents.search("Lunch"));
		this.localEvents.remove("Lunch");
		assertEquals(2, this.localEvents.getNum());
		assertNull(this.localEvents.search("Lunch"));
	}

	@Test
	public void testRemoveStringNoEvents() throws EventException {
		this.localEvents = new Events(2);
		assertEquals(0, this.localEvents.getNum());
		this.localEvents.remove("Lunch");
		assertEquals(0, this.localEvents.getNum());
	}

	@Test
	public void testRemoveEvent() throws EventException {
		assertEquals(2, this.localEvents.getNum());
		this.localEvents.add(this.eventLunch);
		assertEquals(3, localEvents.getNum());
		assertNotNull(this.localEvents.search("Lunch"));
		this.localEvents.remove(this.eventLunch);
		assertEquals(2, this.localEvents.getNum());
		assertNull(this.localEvents.search("Lunch"));
	}

	@Test
	public void testSortNoChanges() {
		this.localEvents.sort();
		assertEquals("Event: Class en ULE: 11/11/2011 09:00 - 13:00\n"
				+ "Event: Meeting en MIC: 11/11/2011 13:00 - 14:00"
				, this.localEvents.toString());
	}
	
	@Test
	public void testSort() throws EventException, DateException, TimeException {
		this.localEvents = new Events(10);
		this.localEvents.add(new Event("EVENT alea ClassF ULE 15/11/2011 9:00 13:00"));
		this.localEvents.add(new Event("EVENT alea LunchF Cafeteria 15/11/2011 14:00 15:00"));
		this.localEvents.add(new Event("EVENT alea ClassM ULE 11/11/2011 9:00 13:00"));
		this.localEvents.add(new Event("EVENT alea LunchM Cafeteria 11/11/2011 14:00 15:00"));
		this.localEvents.add(new Event("EVENT alea ClassT ULE 12/11/2011 9:00 13:00"));
		this.localEvents.add(new Event("EVENT alea LunchT Cafeteria 12/11/2011 14:00 15:00"));
		this.localEvents.add(new Event("EVENT alea ClassW ULE 13/11/2011 9:00 13:00"));
		this.localEvents.add(new Event("EVENT alea LunchW Cafeteria 13/11/2011 14:00 15:00"));
		this.localEvents.add(new Event("EVENT alea ClassH ULE 14/11/2011 9:00 13:00"));
		this.localEvents.add(new Event("EVENT alea LunchH Cafeteria 14/11/2011 14:00 15:00"));
		this.localEvents.sort();
		assertEquals("Event: ClassM en ULE: 11/11/2011 09:00 - 13:00\n"
				+ "Event: LunchM en Cafeteria: 11/11/2011 14:00 - 15:00\n"
				+ "Event: ClassT en ULE: 12/11/2011 09:00 - 13:00\n"
				+ "Event: LunchT en Cafeteria: 12/11/2011 14:00 - 15:00\n"
				+ "Event: ClassW en ULE: 13/11/2011 09:00 - 13:00\n"
				+ "Event: LunchW en Cafeteria: 13/11/2011 14:00 - 15:00\n"
				+ "Event: ClassH en ULE: 14/11/2011 09:00 - 13:00\n"
				+ "Event: LunchH en Cafeteria: 14/11/2011 14:00 - 15:00\n"
				+ "Event: ClassF en ULE: 15/11/2011 09:00 - 13:00\n"
				+ "Event: LunchF en Cafeteria: 15/11/2011 14:00 - 15:00"
				, this.localEvents.toString());
	}
	
	@Test
	public void testToAgendaFormat() throws EventException, DateException, TimeException {
		localEvents = new Events(10);
		localEvents.add(new Event("EVENT alea ClassF ULE 15/11/2011 9:00 13:00"));
		localEvents.add(new Event("EVENT alea LunchF Cafeteria 15/11/2011 14:00 15:00"));
		localEvents.add(new Event("EVENT alea ClassM ULE 11/11/2011 9:00 13:00"));
		localEvents.add(new Event("EVENT alea LunchM Cafeteria 11/11/2011 14:00 15:00"));
		localEvents.add(new Event("EVENT alea ClassT ULE 12/11/2011 9:00 13:00"));
		localEvents.add(new Event("EVENT alea LunchT Cafeteria 12/11/2011 14:00 15:00"));
		localEvents.add(new Event("EVENT alea ClassW ULE 13/11/2011 9:00 13:00"));
		localEvents.add(new Event("EVENT alea LunchW Cafeteria 13/11/2011 14:00 15:00"));
		localEvents.add(new Event("EVENT alea ClassH ULE 14/11/2011 9:00 13:00"));
		localEvents.add(new Event("EVENT alea LunchH Cafeteria 14/11/2011 14:00 15:00"));
		assertEquals("11/11/2011\n"
				+ "	09:00-13:00	ClassM at ULE\n"
				+ "	14:00-15:00	LunchM at Cafeteria\n"
				+ "12/11/2011\n"
				+ "	09:00-13:00	ClassT at ULE\n"
				+ "	14:00-15:00	LunchT at Cafeteria\n"
				+ "13/11/2011\n"
				+ "	09:00-13:00	ClassW at ULE\n"
				+ "	14:00-15:00	LunchW at Cafeteria\n"
				+ "14/11/2011\n"
				+ "	09:00-13:00	ClassH at ULE\n"
				+ "	14:00-15:00	LunchH at Cafeteria\n"
				+ "15/11/2011\n"
				+ "	09:00-13:00	ClassF at ULE\n"
				+ "	14:00-15:00	LunchF at Cafeteria\n"
				, localEvents.toAgendaFormat());
	}
	
	@Test
	public void testToString() {
		assertEquals("Event: Class en ULE: 11/11/2011 09:00 - 13:00\n"
				+ "Event: Meeting en MIC: 11/11/2011 13:00 - 14:00", localEvents.toString());
	}

	@Test
	public void testToFile() {
		assertEquals("EVENT alea Class ULE 11/11/2011 09:00 13:00\n" + "EVENT alea Meeting MIC 11/11/2011 13:00 14:00",
				localEvents.toFile("alea"));
	}
}
