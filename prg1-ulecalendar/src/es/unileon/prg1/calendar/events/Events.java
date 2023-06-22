package es.unileon.prg1.calendar.events;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that manages all the events of a specific user
 *
 * @author Mario
 * @version 1.0
 */

public class Events {

    static final Logger logger = LogManager.getLogger(Events.class.getName());

    /**
     * Array of events
     *
     */
    private Event[] arrEvents;

    /**
     * Next empty place in events array
     *
     */
    private int next;

    /**
     * Constructor that establishes events array
     *
     * @param numberOfEvents Number of events that the array can hold
     */
    public Events(int numberOfEvents) {
        this.arrEvents = new Event[numberOfEvents];
    }

    /**
     * Identifies the number of events in the array
     *
     * @return Number of events in the array
     */
    public int getNum() {
        next = 0;

        while ((next < this.arrEvents.length) && (this.arrEvents[next] != null)) {
            next++;
        }

        return next;
    }

    /**
     * Adds a new event to the array
     *
     * @param event Event that will be added
     * @throws EventException if the event already exists
     *                        if the array of events is already full
     */
    public void add(Event event) throws EventException {
        next = getNum();
        if (search(event.getName()) != null) {
            throw new EventException("Can't add a duplicated event: " + event.getName() + "\n");
        } else if (next >= this.arrEvents.length) {
            throw new EventException("Can't add more than 10 events: " + event.getName() + "\n");
        } else {
            this.arrEvents[next] = event;
            next = getNum();
        }
    }

    /**
     * Searches an event in events array
     *
     * @param name Name of the event that will be searched
     * @return Found event or null if the event was not found
     */
    public Event search(String name) {
        Event found = null;
        int counter = 0;

        while (counter < this.getNum()) {
            if (this.arrEvents[counter].getName().equals(name)) {
                found = new Event(this.arrEvents[counter]);
            }

            counter++;
        }

        return found;
    }

    /**
     * Removes an event from the array given its name
     *
     * @param name Name of the event that will be removed
     * @return true if the event was successfully removed
     *         false if the event couldn't be removed
     */
    public boolean remove(String name) {
        boolean removed = false;

        if (search(name) != null) {
            int eventIndex = searchEventIndex(name);

            logger.info("Event removed: " + this.arrEvents[eventIndex]);
            this.arrEvents[eventIndex] = null;
            removeNullBetweenEvents();
            removed = true;
        }

        return removed;
    }

    /**
     * Removes an event from the events array given an event
     *
     * @param event Event that will be removed
     * @return true if the event was successfully removed
     *         false if the event couldn't be removed
     */
    public boolean remove(Event event) {
        return remove(event.getName());
    }

    /**
     * Removes null spaces between events in events array by swapping them
     *
     */
    private void removeNullBetweenEvents() {
        int counter = 0;
        while (counter < (this.arrEvents.length - 1)) {
            if (this.arrEvents[counter] == null) {
                swap(counter, counter + 1);
            }
            counter++;
        }
    }

    /**
     * Gets the index of an existing event in events array
     *
     * @param name Name of the event whose index will be searched
     * @return Index of the given event in events array
     */
    public int searchEventIndex(String name) {
        int index = 0;

        for (int i = 0; i < this.getNum(); i++) {
            if (this.arrEvents[i].isSame(name)) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Exchanges the position of two events in the array
     *
     * @param i First event's index
     * @param j Second event's index
     */
    private void swap(int i, int j) {
        Event aux;

        aux = arrEvents[i];
        arrEvents[i] = arrEvents[j];
        arrEvents[j] = aux;
    }

    /**
     * Orders all the events by the date and time they are going to happen
     *
     */
    public void sort() {
        int upperLimit, lowerLimit;
        boolean end, changed;

        upperLimit = this.next;
        lowerLimit = -1;
        end = false;

        while ((lowerLimit < upperLimit) && !end) {
            lowerLimit++;
            upperLimit--;
            changed = false;
            // Travels along the array(left to right) and order the events according to which occurs before.
            for (int j = lowerLimit; j < upperLimit; j++) {
                if (arrEvents[j].isAfter(arrEvents[j + 1])) {
                    swap(j, j + 1);
                    changed = true;
                }
            }

            if (!changed) {
                end = true;
            } else {
                changed = false;
                // Travels along the array(right to left) and order the events according to which occurs before.
                for (int j = upperLimit; --j >= lowerLimit; ) {
                    if (arrEvents[j].isAfter(arrEvents[j + 1])) {
                        swap(j, j + 1);
                        changed = true;
                    }
                }
                if (!changed) {
                    end = true;
                }
            }
        }
    }

    /**
     * Formats every event to appear in an agenda view
     *
     * @return String with formatted events for agenda view
     */
    public String toAgendaFormat() {
        StringBuilder eventsString = new StringBuilder();
        int counter = 0;
        this.sort();

        while ((counter < this.arrEvents.length) && (this.arrEvents[counter] != null)) {
            if (counter != 0) {
                eventsString.append("\n");

                if (this.arrEvents[counter].getDate().isSame(this.arrEvents[counter - 1].getDate())) {
                    eventsString.append(this.eventAgendaFormat(this.arrEvents[counter]));
                } else {
                    eventsString.append(this.arrEvents[counter].getDate()).append("\n").append(this.eventAgendaFormat(this.arrEvents[counter]));
                }
            } else {
                eventsString.append(this.arrEvents[counter].getDate()).append("\n").append(this.eventAgendaFormat(this.arrEvents[counter]));
            }

            counter++;
        }

        eventsString.append("\n");

        return eventsString.toString();
    }

    /**
     * Formats an event as required in method toAgendaFormat()
     *
     * @param event Event that will be formatted
     * @return String with formatted event for agenda view
     */
    private String eventAgendaFormat(Event event) {
        return "\t" + event.getStartTime() + "-" + event.getEndTime() + "\t" + event.getName() + " at " + event.getPlace();
    }

    /**
     * Formats every event to a String format
     *
     * @return String with formatted events
     */
    public String toString() {
        StringBuilder eventsString = new StringBuilder();
        int counter = 0;

        while (counter < this.getNum()) {
            if (counter != 0) {
                eventsString.append("\n");
            }
            eventsString.append(this.arrEvents[counter].toString());
            counter++;
        }
        return eventsString.toString();
    }

    /**
     * Formats every event to a String file format, so it can be saved in a document
     *
     * @param nickname Nickname of the user associated with the events
     * @return String with formatted events
     */
    public String toFile(String nickname) {
        StringBuilder eventsString = new StringBuilder();

        for (int i = 0; i < this.getNum(); i++) {
            eventsString.append(this.arrEvents[i].toFile(nickname));
            if (i != (this.getNum() - 1)) {
                eventsString.append("\n");
            }
        }

        return eventsString.toString();
    }
}