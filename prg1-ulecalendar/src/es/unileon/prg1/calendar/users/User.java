package es.unileon.prg1.calendar.users;

import java.util.StringTokenizer;

import es.unileon.prg1.calendar.events.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that manages all the information related to a user
 *
 * @author Adriana, Daniel
 * @version 1.0
 */

public class User {

    static final Logger logger = LogManager.getLogger(User.class.getName());

    /**
     * Nickname of the user
     */
    private String nickname;

    /**
     * Name of the user
     */
    private String name;

    /**
     * Surname of the user
     */
    private String surname;

    /**
     * Maximum amount of events per user
     */
    private final int NUM_MAX_EVENTS = 10;

    /**
     * Events associated with the user
     */
    private Events events = new Events(NUM_MAX_EVENTS);

    /**
     * Constructor that establishes every aspect related to the user
     *
     * @param nickname Nickname of the user
     * @param name Name of the user
     * @param surname Surname of the user
     */
    public User(String nickname, String name, String surname) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Constructor that establishes every aspect related to the user given a file text
     *
     * @param file String that contains every parameter of the user
     * @throws UserException if the chain doesn't have the correct form
     */
    public User(String file) throws UserException {
        // Divides the file string into different substrings containing the parameters
        StringTokenizer tokens = new StringTokenizer(file, " ");
        int numTokens = tokens.countTokens();

        if (numTokens != 4) {
            // Throws an exception if the chain does not have 4 fields
            throw new UserException("User error: malformed line " + file + "\n");
        } else {
            // Sets user's parameters using tokens
            tokens.nextToken();
            this.setNickname(tokens.nextToken());
            this.setName(tokens.nextToken());
            this.setSurname(tokens.nextToken());
        }
    }

    /**
     * Gets the nickname of a user
     *
     * @return Nickname of the user
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Gets the name of a user
     *
     * @return Name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the surname of a user
     *
     * @return Surname of the user
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the nickname of a user
     *
     * @param nickname Nickname of the user
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Sets the name of a user
     *
     * @param name Name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the surname of a user
     *
     * @param surname Surname of the user
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Identifies the number of events of a user
     *
     * @return Number of events of a user
     */
    public int getNumEvents() {
        return this.events.getNum();
    }

    /**
     * Identifies if a user has the same nickname as another one given a user
     *
     * @param user User that will be compared
     * @return true if both users have the same nickname
     *         false if they don't have the same nickname
     */
    public boolean isSame(User user) {
        return this.getNickname().equals(user.getNickname());
    }

    /**
     * Identifies if a user has the same nickname as another one given a nickname
     *
     * @param nickname Nickname of a user that will be compared
     * @return true if both users have the same nickname
     *         false if they don't have the same nickname
     */
    public boolean isSame(String nickname) {
        return this.getNickname().equals(nickname);
    }

    /**
     * Searches an event of a user
     *
     * @param name Name of the event that will be searched
     * @return An event if found or null if it's not found
     */
    public Event search(String name) {
        return this.events.search(name);
    }

    /**
     * Adds an event
     *
     * @param event Event that will be added
     * @throws EventException if the event couldn't be added
     */
    public void add(Event event) throws EventException {
        try {
            this.events.add(event);
        } catch (EventException e) {
            logger.warn(e.getMessage());
            throw new EventException(e.getMessage());
        }
    }

    /**
     * Removes an event
     *
     * @param event Event that will be removed from a user
     * @return true if it correctly removes the event
     *         false if it couldn't remove the event
     */
    public boolean remove(Event event) {
        return this.events.remove(event);
    }

    /**
     * Remove an event given the name of the event
     *
     * @param name Name of the event that will be removed
     * @return true if it correctly removes the event
     *         false if it couldn't remove the event
     */
    public boolean remove(String name) {
        return this.events.remove(name);
    }

    /**
     * Formats a user and its events to appear in an agenda view
     *
     * @return String with formatted user for agenda view
     */
    public String toAgendaFormat() {
        StringBuilder userString = new StringBuilder();

        userString.append(this.userAgendaFormat());

        if (this.getNumEvents() != 0) {
            userString.append("\n").append(this.events.toAgendaFormat());
        }
        return userString.toString();
    }

    /**
     * Formats a user as required in method toAgendaFormat()
     *
     * @return String with formatted user for agenda view
     */
    public String userAgendaFormat() {
        return this.getName() + " " + this.getSurname() + " (" + this.getNickname() + ")";
    }

    /**
     * Formats a user and its events to a String format
     *
     * @return String with formatted user and its events
     */
    public String toString() {
        StringBuilder userString = new StringBuilder();

        userString.append(this.getName()).append(" ").append(this.getSurname()).append(" (").append(this.getNickname()).append(")");

        if (this.getNumEvents() != 0) {
            userString.append("\n").append(this.events.toString());
        }
        return userString.toString();
    }

    /**
     * Formats a user to a String file format, so it can be saved in a document
     *
     * @return String with formatted user
     */
    public String toFile() {
        StringBuilder userString = new StringBuilder();

        userString.append("USER ").append(this.getNickname()).append(" ").append(this.getName()).append(" ").append(this.getSurname());
        if (this.getNumEvents() != 0) {
            userString.append("\n").append(this.events.toFile(this.getNickname()));
        }
        return userString.toString();
    }
}