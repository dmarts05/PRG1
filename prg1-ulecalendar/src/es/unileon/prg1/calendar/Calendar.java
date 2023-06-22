package es.unileon.prg1.calendar;

import es.unileon.prg1.calendar.users.*;
import es.unileon.prg1.calendar.events.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that manages users and events
 * @version 1.0
 * @author Hector, Daniel
 */

public class Calendar {

    /**
     * Users associated with the calendar
     */
    private Users users = new Users();
    
    /**
     * Adds a user
     *
     * @param user User that will be added
     * @throws UserException if adding the user fails
     */
    public void add(User user) throws UserException {
        this.users.add(user);
    }

    /**
     * Adds an event to a user given an event and a user's name
     *
     * @param user Name of the user that will hold the event
     * @param event Event that will be added
     * @throws EventException if the event can't be added
     * @throws UserException if the user does not exist
     */
    public void add(String user, Event event) throws EventException, UserException {
        if (this.search(user) != null) {
            this.search(user).add(event);
        } else {
            throw new UserException("Unable to add an event for a user that doesn't exist: " + user + "\n");
        }
    }

    /**
     * Adds an event to a user given a user and an event
     *
     * @param user User that will hold the event
     * @param event Event that will be added
     * @throws EventException if the event can't be added
     * @throws UserException if the user does not exist
     */
    public void add(User user, Event event) throws EventException, UserException {
        if (this.search(user.getNickname()) != null) {
            this.search(user.getNickname()).add(event);
        } else {
            throw new UserException("Unable to add an event for a user that doesn't exist: " + user + "\n");
        }
    }

    /**
     * Removes a user given its nickname
     *
     * @param nickname Nickname of the user that will be removed
     * @return true if the user has been removed
     *         false if the user couldn't be removed
     * @throws UserException if the user does not exist.
     */
    public boolean remove(String nickname) throws UserException {
        User user = this.search(nickname);
        boolean removed;

        if (user != null) {
            removed = this.users.remove(nickname);
        } else {
            throw new UserException("Unable to remove a user that doesn't exist: " + nickname + "\n");
        }

        return removed;
    }

    /**
     * Removes an event of a user
     *
     * @param nickname Nickname of the user
     * @param event Event that will be removed of the user
     * @return true if the event has been removed
     *         false if the event couldn't be removed
     * @throws UserException if the user does not exist.
     */
    public boolean remove(String nickname, String event) throws UserException {
        User user = this.search(nickname);
        boolean removed;

        if (user != null) {
            removed = user.remove(event);
        } else {
            throw new UserException("Unable to remove an event of a user that doesn't exist: " + nickname + "\n");
        }

        return removed;
    }

    /**
     * Searches a user
     *
     * @param nickname Nickname of the user that will be searched
     * @return A user if found or null if it's not found
     */
    public User search(String nickname) {
        return this.users.search(nickname);
    }

    /**
     * Formats the calendar to a String format
     *
     * @return String with formatted calendar
     */
    public String toString() {
        return "CALENDAR\n" + users.toString();
    }

    /**
     * Formats the calendar to a String file format, so it can be saved in a document
     *
     * @return String with formatted calendar
     */
    public String toFile() {
        return users.toFile();
    }
}