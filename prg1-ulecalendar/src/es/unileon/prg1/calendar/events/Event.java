package es.unileon.prg1.calendar.events;

import java.util.StringTokenizer;

import es.unileon.prg1.calendar.date.*;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that manages all the information related to an event
 *
 * @author Mario
 * @version 1.0
 */

public class Event {

    /**
     * Name of the event
     */
    private String name;

    /**
     * Place where the event happens
     */
    private Place place;

    /**
     * Date in which the event takes place
     */
    private Date date;

    /**
     * Time in which the event starts
     */
    private Time startTime;

    /**
     * Time in which the event ends
     */
    private Time endTime;

    /**
     * Constructor that establishes every aspect related to the event
     *
     * @param name      Name of the event
     * @param place     Place where the event happens
     * @param date      Date in which the event takes place
     * @param startTime Time in which the event starts
     * @param endTime   Time in which the event ends
     * @throws EventException if the start time is after the end time
     */
    public Event(String name, Place place, Date date, Time startTime, Time endTime) throws EventException {
        this.setName(name);
        this.setPlace(place);
        this.setDate(date);

        if (startTime.isAfter(endTime)) {
            throw new EventException("Start time can't be configured after end time\n");
        } else {
            setStartTime(startTime);
            setEndTime(endTime);
        }
    }

    /**
     * Constructor that establishes every aspect related to the event given a file text
     *
     * @param file String that contains every parameter of the event
     * @throws EventException if the chain doesn't have the correct form
     * @throws DateException if the date is not correct
     * @throws TimeException if the time is not correct
     */
    public Event(String file) throws EventException, DateException, TimeException {
        // Divides the file string into different substrings containing the parameters
        StringTokenizer tokens = new StringTokenizer(file, " ");
        int numTokens = tokens.countTokens();

        if (numTokens != 7) {
            // Throws an exception if the chain does not have 7 tokens
            throw new EventException("Event error: malformed line " + file);
        } else {
            // Sets event's parameters using tokens
            tokens.nextToken();
            tokens.nextToken();
            setName(tokens.nextToken());
            setPlace(new Place(tokens.nextToken()));
            setDate(new Date(tokens.nextToken()));

            Time startTime = new Time(tokens.nextToken());
            Time endTime = new Time(tokens.nextToken());
            if (startTime.isAfter(endTime)) {
                // Throws an exception if the start time is after the end time
                throw new EventException("Start time can't be configured after end time\n");
            } else {
                setStartTime(startTime);
                setEndTime(endTime);
            }
        }
    }

    /**
     * Constructor that creates an event with the same parameters given of an existing event
     *
     * @param event Event from which the parameters will be extracted
     */
    public Event(Event event) {
        setName(event.getName());
        setPlace(event.getPlace());
        setDate(event.getDate());
        setStartTime(event.getStartTime());
        setEndTime(event.getEndTime());
    }

    /**
     * Sets the name of an event
     *
     * @param name Name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the place where an event is going to happen
     *
     * @param place Place where the event happens
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * Sets the date when an event is going to take place
     *
     * @param date Date in which the event takes place
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the time when an event is going to start
     *
     * @param startTime Time in which the event starts
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets the time when an event is going to end
     *
     * @param endTime Time in which the event ends
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the name that was set for an event
     *
     * @return Name of the event
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the place that was set for an event
     *
     * @return Place where an event is going to happen
     */
    public Place getPlace() {
        return this.place;
    }

    /**
     * Gets the date that was set for an event
     *
     * @return Date when the event takes place
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets the start time that was set for an event
     *
     * @return Start time of the event
     */
    public Time getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the end time that was set for an event
     *
     * @return End time of the event
     */
    public Time getEndTime() {
        return this.endTime;
    }

    /**
     * Identifies if two events have the same name
     *
     * @param name Name of an event
     * @return true if both events have the same name
     * false if the events have different names
     */
    public boolean isSame(String name) {
        return this.getName().equals(name);
    }

    /**
     * Checks if an event takes place after another one
     *
     * @param event Event that will be compared
     * @return true if the given event happens before the other event
     * false if the given event happens after the other event
     */
    public boolean isAfter(Event event) {
        boolean isAfter = false;

        if (this.getDate().isAfter(event.getDate())) {
            isAfter = true;
        } else if (this.getDate().isSame(event.getDate())) {
            if (this.getStartTime().isAfter(event.getStartTime())) {
                isAfter = true;
            }
        }
        return isAfter;
    }

    /**
     * Formats the whole event to a String format
     *
     * @return String with formatted event
     */
    public String toString() {
        return "Event: " + this.getName() + " en " + this.getPlace() + ": " + this.getDate() + " " + this.getStartTime() + " - " + this.getEndTime();
    }

    /**
     * Formats the whole event to a String file format so that it can be saved in a document
     *
     * @param nickname Nickname of the user associated with the event
     * @return String with formatted event
     */
    public String toFile(String nickname) {
        return "EVENT " + nickname + " " + this.getName() + " " + this.getPlace() + " " + this.getDate() + " " + this.getStartTime() + " " + this.getEndTime();
    }
}