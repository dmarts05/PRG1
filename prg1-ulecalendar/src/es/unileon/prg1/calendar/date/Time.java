package es.unileon.prg1.calendar.date;

import java.util.StringTokenizer;

/**
 * Class to manage a time compose by an hour and minutes 
 * specific for each event.
 * @version 1.0
 * @author Daniel
 */

public class Time {

    /**
     * Digit of the hour
     */
    private int hour;

    /**
     * Digit of the minute
     */
    private int minute;

    /**
     * Establish the values of the params hour and minute
     *
     * @param hour Number of the hour
     * @param minute Number of the minute
     * @throws TimeException if the parameters are not in int type
     */
    public Time(int hour, int minute) throws TimeException {
        this.setHour(hour);
        this.setMinute(minute);
    }

    /**
     * Converts the arguments into whole numbers to determine the time
     *
     * @param file Time set in a String form
     * @throws TimeException if the chain introduced does not have the correct format
     */
    public Time(String file) throws TimeException {
        //Divides a string into different substrings.
        StringTokenizer tokens = new StringTokenizer(file, ":");
        int numTokens = tokens.countTokens();

        if (numTokens != 2) {
            //throws an exection if the chain does not have 2 fields.
            throw new TimeException("Time error: malformed line " + file + "\n");
        } else {
            //Give to each param a substring chain.
            try {
                this.setHour(Integer.parseInt(tokens.nextToken()));
                this.setMinute(Integer.parseInt(tokens.nextToken()));
            } catch (NumberFormatException e) {
                //throws an exception if the chain contains letters.
                throw new TimeException("This time contains a letter instead of a number: " + e.getMessage() + "\n");
            }
        }
    }

    /**
     * Saved the hour that was set
     *
     * @return An hour for an event
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Saved the minutes that were set
     *
     * @return The minutes for an event
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Set the hour of a time and throws an exception if 
     * it does not have the correct format
     *
     * @param hour Number of the hour
     * @throws TimeException if it is negative, or if it is bigger than 24
     */
    public void setHour(int hour) throws TimeException {
        if (hour < 0) {
            throw new TimeException("Negative hours are not allowed - wrong value for hour: " + hour + "\n");
        } else {
            if (hour >= 24) {
                throw new TimeException("Hour exceeds 24: " + hour + "\n");
            } else {
                this.hour = hour;
            }
        }
    }

    /**
     * Set the minutes of a time and throws an exception if 
     * it does not have the correct format
     *
     * @param minute Number of the minutes
     * @throws TimeException if it is negative, or if it is bigger than 60
     */
    public void setMinute(int minute) throws TimeException {
        if (minute < 0) {
            throw new TimeException("Negative minutes are not allowed - wrong value for minute: " + minute + "\n");
        } else {
            if (minute >= 60) {
                throw new TimeException("Minutes exceed 60: " + minute + "\n");
            } else {
                this.minute = minute;
            }
        }
    }

    /**
     * Identifies if the hour and minutes are repeated or not
     *
     * @param time Time compared with the local time
     * @return True if they are the same time
     */
    public boolean isSame(Time time) {
        return (this.getHour() == time.getHour()) && (this.getMinute() == time.getMinute());
    }

    /**
     * Compare the hours and minutes to identify which time is after the other
     *
     * @param time Time compared with the local time
     * @return True if the time inserted goes after and false if not
     */
    public boolean isAfter(Time time) {
        boolean isAfter = false;
        if (this.getHour() > time.getHour()) {
            isAfter = true;
        } else if (this.getHour() == time.getHour()) {
            if (this.getMinute() > time.getMinute()) {
                isAfter = true;
            }
        }
        return isAfter;
    }

    /**
     * Compare the hours and minutes to identify which time is before the other
     *
     * @param time Time compared with the local time
     * @return True if the time inserted is before and false if not
     */
    public boolean isBefore(Time time) {
        boolean isBefore = false;
        if (this.getHour() < time.getHour()) {
            isBefore = true;
        } else if (this.getHour() == time.getHour()) {
            if (this.getMinute() < time.getMinute()) {
                isBefore = true;
            }
        }
        return isBefore;
    }

    /**
     * Convert the time into string type
     * If the hour or minutes that were inserted are smaller than ten
     * a zero is inserted before
     *
     * @return Digital time
     */
    public String toString() {
        StringBuilder hour = new StringBuilder();
        StringBuilder minute = new StringBuilder();

        if (this.getHour() < 10) {
            hour.append("0").append(this.getHour());
        } else {
            hour.append(this.getHour());
        }

        if (this.getMinute() < 10) {
            minute.append("0").append(this.getMinute());
        } else {
            minute.append(this.getMinute());
        }

        return hour + ":" + minute;
    }
}
