package es.unileon.prg1.calendar.date;

/**
 * Class to generate a complete date for an event. This date is composed
 * by a day, a month and a year.
 * 
 * @version 1.0
 * @author Hector
 * 
 */

public class Date {

	/**
	 * Digit of the day
	 */
	private int day;

	/**
	 * Digit of the month
	 */
	private int month;

	/**
	 * Digit of the year
	 */
	private int year;

	/**
	 * Converts an argument in a whole number to generate a date. Throws an exception if the
	 * date has a wrong format
	 *
	 * @param date Date in String format ("dd/mm/yyyy")
	 * @throws DateException if the date contains a letter instead of a number
	 */
	public Date(String date) throws DateException {
		int slashIndex = date.indexOf('/');
		int nextSlashIndex = date.indexOf('/', slashIndex + 1);

		try {
			this.setMonth(Integer.parseInt(date.substring(slashIndex + 1, nextSlashIndex)));
			this.setDay(Integer.parseInt(date.substring(0, slashIndex)));
			this.setYear(Integer.parseInt(date.substring(nextSlashIndex + 1)));
		} catch (Exception e) {
			throw new DateException("Malformed given date String: " + e.getMessage());
		}
	}

	/**
	 * Establish the values of the params day, month and year
	 *
	 * @param day Digit of the day
	 * @param month Digit of the month
	 * @param year Digit of the year
	 * @throws DateException if one of the params is incorrect
	 */
	public Date(int day, int month, int year) throws DateException {
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}

	/**
	 * Check if the number introduce is correct. If it is correct the day is saved 
	 * but if not throws an exception
	 *
	 * @param day Digit of the day
	 * @throws DateException if the number is negative or if the date introduce is wrong
	 */
	public void setDay(int day) throws DateException {
		if (day <= 0) {
			throw new DateException("Negative days are not allowed - wrong value for day: " + day + "\n");
		} else {
			if (day > this.daysOfMonth(this.month)) {
				throw new DateException("Day/Month wrong combination: " + day + "/" + this.month + "\n");
			} else {
				this.day = day;
			}
		}
	}

	/**
	 * Check if the number introduce is correct. If it is correct the month is saved 
	 * but if not throws an exception
	 *
	 * @param month Digit of the month
	 * @throws DateException if the number is negative or if it is bigger than twelve.
	 */
	public void setMonth(int month) throws DateException {
		if (month <= 0) {
			throw new DateException("Negative months are not allowed - wrong value for month: " + month + "\n");
		} else {
			if (month > 12) {
				throw new DateException("There are only 12 months - wrong value for month: " + month + "\n");
			} else {
				this.month = month;
			}
		}
	}

	/**
	 * Check if the number introduced is correct. If it is, the year is saved 
	 * but if not, throws an exception
	 *
	 * @param year Digit of the year
	 * @throws DateException if the number is negative.
	 */
	public void setYear(int year) throws DateException {
		if (year < 0) {
			throw new DateException("Negative years are not allowed - wrong value for year: " + year + "\n");
		} else {
			this.year = year;
		}
	}

	/**
	 * Save the day that was set
	 * @return Digit of the day
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * Save the month that was set
	 *
	 * @return Digit of the month
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * Save the year that was set
	 *
	 * @return Digit of the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Determine the days of the months
	 *
	 * @param month Digit of the month
	 * @return Number of days of the month
	 */
	private int daysOfMonth(int month) {
		int number;
		switch (month) {
			case 1: // next
			case 3: // next
			case 5: // next
			case 7: // next
			case 8: // next
			case 10: // next
			case 12:
				number = 31;
				break;
			case 4: // next
			case 6: // next
			case 9: // next
			case 11:
				number = 30;
				break;
			default:
				number = 28;
				break;
		}
		return number;
	}

	/**
	 * Check if it is the same year
	 *
	 * @param date Date that is compared with the local date
	 * @return True if they are the same year
	 */
	public boolean isSameYear(Date date) {
		return (date.getYear() == this.year);
	}

	/**
	 * Check if it is the same month
	 *
	 * @param date Date that is compared with the local date
	 * @return True if they are the same month.
	 */
	public boolean isSameMonth(Date date) {
		return (date.getMonth() == this.month);
	}

	/**
	 * Check if it is the same day
	 *
	 * @param date Date that is compared with the local date
	 * @return True if they are the same day.
	 */
	public boolean isSameDay(Date date) {
		return (date.getDay() == this.day);
	}

	/**
	 * Check if it is the same date
	 * @param date Date that is compared with the local date
	 * @return True if they are the same date.
	 */
	public boolean isSame(Date date) {
		return (isSameDay(date) && isSameMonth(date) && isSameYear(date));
	}

	/**
	 * Check which date is after the other
	 * @param date Date that is compared with the local date
	 * @return True if a date is after the other
	 */
	public boolean isAfter(Date date) {
		boolean isAfter = false;
		if (this.getYear() > date.getYear()) {
			isAfter = true;
		} else if (this.getYear() == date.getYear()) {
			if (this.getMonth() > date.getMonth()) {
				isAfter = true;
			} else if (this.getMonth() == date.getMonth()) {
				if (this.getDay() > date.getDay()){
					isAfter = true;
				}
			}
		}
		return isAfter;
	}

	/**
	 * Convert the date into string type
	 *
	 * @return String with formatted date
	 */
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
