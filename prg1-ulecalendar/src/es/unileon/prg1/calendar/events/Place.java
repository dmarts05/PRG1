package es.unileon.prg1.calendar.events;

/**
 * Class to manage the place where an event is going to take place
 *
 * @version 1.0
 * @author Daniel
 */

public class Place {
    /**
     * Name of the place
     */
    private String name;

    /**
     * Constructor that establish the name of the place
     *
     * @param name Name of the place
     */
    public Place(String name) {
        this.name = name;
    }

    /**
     * Saves the name of the place where an event is going to happen
     *
     * @return Name of the place.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the place where the event is going to happen
     *
     * @param name Name of the place
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Converts the params into String type
     *
     * @return Name of the place.
     */
    public String toString() {
        return this.getName();
    }
}