package es.unileon.prg1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.unileon.prg1.calendar.users.UserTest;
import es.unileon.prg1.calendar.users.UsersTest;
import es.unileon.prg1.calendar.events.EventTest;
import es.unileon.prg1.calendar.events.EventsTest;
import es.unileon.prg1.calendar.events.PlaceTest;
import es.unileon.prg1.calendar.io.BatchInterfaceTest;
import es.unileon.prg1.calendar.io.FileTest;
import es.unileon.prg1.calendar.CalendarTest;
import es.unileon.prg1.calendar.date.DateTest;
import es.unileon.prg1.calendar.date.TimeTest;

@RunWith(Suite.class)
@SuiteClasses({ UsersTest.class, UserTest.class, EventTest.class, EventsTest.class, PlaceTest.class,
                BatchInterfaceTest.class, FileTest.class, CalendarTest.class, DateTest.class, TimeTest.class })
public class AllTests {

}
