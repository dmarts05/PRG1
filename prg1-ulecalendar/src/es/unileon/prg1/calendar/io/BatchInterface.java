package es.unileon.prg1.calendar.io;

import es.unileon.prg1.calendar.Calendar;
import es.unileon.prg1.calendar.date.DateException;
import es.unileon.prg1.calendar.date.TimeException;
import es.unileon.prg1.calendar.users.User;
import es.unileon.prg1.calendar.users.UserException;
import es.unileon.prg1.calendar.events.Event;
import es.unileon.prg1.calendar.events.EventException;

import java.util.StringTokenizer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BatchInterface {

	private String fileName;

	static final Logger logger = LogManager.getLogger(BatchInterface.class.getClass());

	/**
	 * Constructor
	 * 
	 * @param fileName Name of the file containing the state of the calendar
	 */
	public BatchInterface(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Creates a new Calendar using the information loaded from the file. The file is defined  in the constructor.
	 * 
	 * @return Calendar A calendar object loaded with the file information. 
	 * @throws UserException if a user can't be added
	 * @throws DateException if a date is not correct
	 * @throws EventException if an event can't be added
	 * @throws TimeException if a time is not correct
	 * @throws FileException if a file line is malformed
	 *
	 */
	public Calendar createCalendar() throws UserException, DateException, EventException, TimeException, FileException {
		Calendar calendar = new Calendar();
		File file = new File(this.fileName);
		String content, line;
		StringTokenizer tokens;
		StringBuilder errors;
		
		errors = new StringBuilder();
		content = file.readElements();
		tokens = new StringTokenizer(content, System.getProperty("line.separator"));
		int numTokens = tokens.countTokens();

		for (int i = 0; i < numTokens; i++) {
			line = tokens.nextToken();

			if (line.toUpperCase().startsWith("USER")) {
				User user = new User(line);
				calendar.add(user);
				logger.info("User created: " + user);
			} else if (line.toUpperCase().startsWith("EVENT")) {
				Event event = new Event(line);
				String user = line.substring(line.indexOf(" ") + 1, line.indexOf(" ", line.indexOf(" ") + 1));
				calendar.add(user, event);
				logger.info("Event created: " + event);
			} else {
				errors.append("ERROR: Malformed line discarded -> ").append(line);
			}
		}
		if (errors.length() != 0) {
			logger.fatal(errors.toString());
			throw new FileException(errors.toString());
		}

		return calendar;
	}
}
