package es.unileon.prg1.calendar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.calendar.Calendar;
import es.unileon.prg1.calendar.io.BatchInterface;
import es.unileon.prg1.calendar.users.UserException;
import es.unileon.prg1.calendar.users.User;
import es.unileon.prg1.calendar.events.EventException;
import es.unileon.prg1.calendar.events.Event;
import es.unileon.prg1.calendar.date.DateException;
import es.unileon.prg1.calendar.date.TimeException;

public class CalendarTest {
    private BatchInterface io;
    private Calendar calendar;

    @Before
    public void setUp() throws Exception {
        this.io = new BatchInterface("./test/rightCalendar.txt");
        this.calendar = this.io.createCalendar();
    }
    
    @Test
    public void testAddUser() throws UserException {
    	Calendar otherCalendar = new Calendar();
    	assertEquals("CALENDAR\n", otherCalendar.toString());
    	User dummyUser = new User("nickname", "Name", "Surname");
    	otherCalendar.add(dummyUser);
    	assertEquals("CALENDAR\nName Surname (nickname)", otherCalendar.toString());
    }
    
    @Test(expected = UserException.class)
    public void testAddRepeatedUser() throws UserException {
    	User repeatedUser = new User("alea", "Name", "Surname");
    	calendar.add(repeatedUser);
    }
    
    @Test
    public void testRemoveUser() throws UserException {
    	Calendar otherCalendar = new Calendar();
    	User dummyUser = new User("nickname", "Name", "Surname");
    	otherCalendar.add(dummyUser);
    	assertEquals("CALENDAR\nName Surname (nickname)", otherCalendar.toString());
    	otherCalendar.remove(dummyUser.getNickname());
    	assertEquals("CALENDAR\n", otherCalendar.toString());
    }
    
    @Test(expected = UserException.class)
    public void testRemoveUserEmptyCalendar() throws UserException {
    	Calendar emptyCalendar = new Calendar();
    	emptyCalendar.remove("noUser");
    }
    
    @Test(expected = UserException.class)
    public void testRemoveUserNotExists() throws UserException {
    	calendar.remove("noUser");
    }
    
    @Test
    public void testSearchUser() throws UserException {
    	User user = new User("nickname", "Name", "Surname");
    	calendar.add(user);
    	User retrievedUser = calendar.search("nickname");
    	assertEquals(user.toString(), retrievedUser.toString());
    }
    
    @Test
    public void testSearchNoUser() throws UserException {
    	User retrievedUser = calendar.search("noUser");
    	assertNull(retrievedUser);
    }
    
    @Test
    public void testAddUserEvent() throws UserException, EventException, DateException, TimeException {
        User alea = this.calendar.search("alea");
        assertEquals(alea.getNumEvents(), 3);
        this.calendar.add(alea, new Event("EVENT alea Dinner Cafeteria 11/11/2011 21:00 22:00"));
        assertEquals(alea.getNumEvents(), 4);
    }

    @Test(expected = UserException.class)
    public void testAddUserEventNoUser() throws UserException, EventException, DateException, TimeException {
        this.calendar.add(new User("noone", "No", "One"), new Event("EVENT alea Dinner Cafeteria 11/11/2011 21:00 22:00"));
    }

    @Test
    public void testAddStringEvent() throws UserException, EventException, DateException, TimeException {
        User alea = this.calendar.search("alea");
        assertEquals(alea.getNumEvents(), 3);
        this.calendar.add("alea", new Event("EVENT alea Dinner Cafeteria 11/11/2011 21:00 22:00"));
        assertEquals(alea.getNumEvents(), 4);
    }

    @Test(expected = UserException.class)
    public void testAddStringEventNoUser() throws UserException, EventException, DateException, TimeException {
        this.calendar.add("noUser", new Event("EVENT alea Dinner Cafeteria 11/11/2011 21:00 22:00"));
    }

    @Test
    public void testRemoveEvent() throws UserException {
        User alea = this.calendar.search("alea");
        assertEquals(alea.getNumEvents(), 3);
        this.calendar.remove("alea", "Class");
        assertEquals(alea.getNumEvents(), 2);
    }

    @Test(expected = UserException.class)
    public void testRemoveEventNoUser() throws UserException {
        this.calendar.remove("noUser", "Class");
    }
    
    @Test
    public void testToString() {
    	assertEquals("CALENDAR\n"
    			+ "Alex Archer (alea)\n"
    			+ "Event: Class en ULE: 11/11/2011 09:00 - 13:00\n"
    			+ "Event: Meeting en MIC: 11/11/2011 13:00 - 14:00\n"
    			+ "Event: Lunch en Cafeteria: 11/11/2011 14:00 - 15:00\n\n"
    			+ "Bonnie Bird (bonb)\n"
    			+ "Event: Class en ULE: 11/11/2011 15:00 - 19:00\n"
    			+ "Event: Meeting en Library: 11/11/2011 13:00 - 14:00\n\n"
    			+ "Colin Cook (colc)", calendar.toString());
    }
    
    @Test
    public void testToStringEmptyCalendar() {
    	Calendar emptyCalendar = new Calendar();
    	assertEquals("CALENDAR\n", emptyCalendar.toString());
    }

    @Test
    public void testToFile() throws UserException, DateException, EventException {
        assertEquals(
                "USER alea Alex Archer\n" + "EVENT alea Class ULE 11/11/2011 09:00 13:00\n"
                        + "EVENT alea Meeting MIC 11/11/2011 13:00 14:00\n"
                        + "EVENT alea Lunch Cafeteria 11/11/2011 14:00 15:00\n" + "USER bonb Bonnie Bird\n"
                        + "EVENT bonb Class ULE 11/11/2011 15:00 19:00\n"
                        + "EVENT bonb Meeting Library 11/11/2011 13:00 14:00\n" + "USER colc Colin Cook",
                this.calendar.toFile());
    }

}
