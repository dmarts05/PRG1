package es.unileon.prg1.calendar.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.calendar.events.Event;
import es.unileon.prg1.calendar.events.EventException;

public class UserTest {

	User localUser, fileUser;
	Event event;
	String fileLine;

	@Before
	public void setUp() throws Exception {
		this.localUser = new User("Marcos66", "Marcos", "Garcia");
		this.fileLine = "USER alea Alex Archer";
		this.fileUser = new User(this.fileLine);
		this.event = new Event("EVENT alea Class ULE 11/11/2011 9:00 13:00");
	}

	@Test
	public void testUserStringStringString() {
		assertEquals("Marcos66", this.localUser.getNickname());
		assertEquals("Marcos", this.localUser.getName());
		assertEquals("Garcia", this.localUser.getSurname());
		assertEquals(0, this.localUser.getNumEvents());
	}

	@Test
	public void testUserString() {
		assertEquals("alea", this.fileUser.getNickname());
		assertEquals("Alex", this.fileUser.getName());
		assertEquals("Archer", this.fileUser.getSurname());
		assertEquals(0, this.fileUser.getNumEvents());
	}

	@Test(expected = UserException.class)
	public void testUserStringWrongNumberOfFields() throws UserException {
		new User("USER Alex Archer");
	}

	@Test
	public void testGetNickname() {
		assertEquals("Marcos66", this.localUser.getNickname());
	}

	@Test
	public void testSetGetUser() {
		assertEquals("Marcos", this.localUser.getName());
		this.localUser.setName("Marta");
		assertEquals("Marta", this.localUser.getName());
	}

	@Test
	public void testSetGetSurname() {
		assertEquals("Garcia", this.localUser.getSurname());
		this.localUser.setSurname("Pazos");
		assertEquals("Pazos", this.localUser.getSurname());
	}

	@Test
	public void testGetNumEvents() throws EventException {
		assertEquals(0, this.localUser.getNumEvents());
		this.localUser.add(this.event);
		assertEquals(1, this.localUser.getNumEvents());
	}

	@Test
	public void testIsSameString() {
		assertTrue(this.localUser.isSame("Marcos66"));
		assertFalse(this.localUser.isSame("alea"));
	}

	@Test
	public void testIsSameUser() {
		User user = new User("Marcos66", "Marcos", "Garcia");
		assertTrue(this.localUser.isSame(user));
		assertFalse(this.localUser.isSame(this.fileUser));
	}

	@Test
	public void testAdd() throws EventException {
		assertEquals(0, this.localUser.getNumEvents());
		assertNull(this.localUser.search("Class"));
		this.localUser.add(this.event);
		assertEquals(1, this.localUser.getNumEvents());
		assertNotNull(this.localUser.search("Class"));
	}

	@Test(expected = EventException.class)
	public void testAddEventException() throws EventException {
		this.localUser.add(this.event);
		this.localUser.add(this.event);
	}

	@Test
	public void testSearch() throws EventException {
		assertEquals(0, this.localUser.getNumEvents());
		assertNull(this.localUser.search("Class"));
		this.localUser.add(this.event);
		assertEquals(1, this.localUser.getNumEvents());
		assertNotNull(this.localUser.search("Class"));
	}

	@Test
	public void testRemoveString() throws EventException {
		assertEquals(0, this.localUser.getNumEvents());
		assertNull(this.localUser.search("Class"));
		this.localUser.add(this.event);
		assertEquals(1, this.localUser.getNumEvents());
		assertNotNull(this.localUser.search("Class"));
		this.localUser.remove("Class");
		assertEquals(0, this.localUser.getNumEvents());
		assertNull(this.localUser.search("Class"));
	}

	@Test
	public void testRemoveEvent() throws EventException {
		assertEquals(0, this.localUser.getNumEvents());
		assertNull(this.localUser.search("Class"));
		this.localUser.add(this.event);
		assertEquals(1, this.localUser.getNumEvents());
		assertNotNull(this.localUser.search("Class"));
		this.localUser.remove(this.event);
		assertEquals(0, this.localUser.getNumEvents());
		assertNull(this.localUser.search("Class"));
	}

	@Test
	public void testToAgendaFormat() throws EventException {
		assertEquals("Marcos Garcia (Marcos66)", this.localUser.toAgendaFormat());
		localUser.add(event);
		assertEquals("Marcos Garcia (Marcos66)\n"
				+ "11/11/2011\n"
				+ "	09:00-13:00	Class at ULE\n"
				, this.localUser.toAgendaFormat());
	}
	
	@Test
	public void testToString() {
		assertEquals("Marcos Garcia (Marcos66)", this.localUser.toString());
	}

	@Test
	public void testToFile() {
		assertEquals("USER alea Alex Archer", this.fileUser.toFile());
	}

}
