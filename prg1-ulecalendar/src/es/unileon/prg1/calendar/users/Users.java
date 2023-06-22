package es.unileon.prg1.calendar.users;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that manages the different users
 *
 * @author Adriana, Daniel
 * @version 1.0
 */

public class Users {

    static final Logger logger = LogManager.getLogger(Users.class.getName());

    /**
     * Array of users
     *
     */
    private User[] arrUsers;

    /**
     * Next empty place in users array
     *
     */
    private int next;

    /**
     * Constructor that establishes the initial length of users array and next in 0
     */
    public Users() {
        this.arrUsers = new User[3];
        this.next = 0;
    }

    /**
     * Duplicates the length of an array when it is full
     *
     * @param arr Array which length is going to be duplicated
     * @return Initial array with duplicated length
     */
    private User[] increaseSize(User[] arr) {
        // Creating an aux array which doubles the capacity
        User[] aux = new User[arr.length * 2];
        // Copying the elements from the original array to the aux one
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
        }

        logger.debug("Size of users array increased. New size: " + aux.length);
        return aux;
    }

    /**
     * Adds a user
     *
     * @param user User that will be added
     * @throws UserException if the user already exists
     */
    public void add(User user) throws UserException {
        next = getNum();

        if (search(user.getNickname()) != null) {
            throw new UserException("Can't add a duplicated user: " + user.getNickname() + "\n");
        } else {
            if (next == this.arrUsers.length) {
                arrUsers = increaseSize(arrUsers);
            }

            this.arrUsers[next] = user;
        }
    }

    /**
     * Removes a user
     *
     * @param nickname Nickname of the user that will be removed
     * @return true if the user was successfully removed
     *         false if the user couldn't be removed
     */
    public boolean remove(String nickname) {
        boolean removed = false;

        if (search(nickname) != null) {
            int userIndex = searchUserIndex(nickname);

            logger.info("User removed: " + this.arrUsers[userIndex]);
            this.arrUsers[userIndex] = null;
            removeNullBetweenUsers();
            removed = true;
        }

        return removed;
    }

    /**
     * Identifies the number of users in the array
     *
     * @return Number of users in the array
     */
    public int getNum() {
        next = 0;

        while ((next < this.arrUsers.length) && (this.arrUsers[next] != null)) {
            next++;
        }
        return next;
    }

    /**
     * Exchanges the position of two users in an array
     *
     * @param i First user's index
     * @param j Second user's index
     */
    private void swap(int i, int j) {
        User aux;

        aux = arrUsers[i];
        arrUsers[i] = arrUsers[j];
        arrUsers[j] = aux;
    }

    /**
     * Searches for a user in users array
     *
     * @param nickname Nickname of the user that will be searched
     * @return A user if found or null if it's not found
     */
    public User search(String nickname) {
        User found = null;
        int counter = 0;

        while (counter < this.getNum()) {
            if (this.arrUsers[counter].getNickname().equals(nickname)) {
                found = this.arrUsers[counter];
                break;
            }

            counter++;
        }

        return found;
    }

    /**
     * Gets the index of an existing user in users array
     *
     * @param nickname Nickname of the user whose index will be searched
     * @return Index of the given user in users array
     */
    public int searchUserIndex(String nickname) {
        int index = 0;

        for (int i = 0; i < this.getNum(); i++) {
            if (this.arrUsers[i].isSame(nickname)) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Removes null spaces between users in users array by swapping them
     *
     */
    private void removeNullBetweenUsers() {
        int counter = 0;
        while (counter < (this.arrUsers.length - 1)) {
            if (this.arrUsers[counter] == null) {
                swap(counter, counter + 1);
            }
            counter++;
        }
    }

    /**
     * Formats every user to a String format
     *
     * @return String with formatted users
     */
    public String toString() {
        StringBuilder usersString = new StringBuilder();
        int counter = 0;

        while (counter < this.getNum()) {
            usersString.append(this.arrUsers[counter].toString());
            if (counter != (this.getNum() - 1)) {
                usersString.append("\n\n");
            }
            counter++;
        }
        return usersString.toString();
    }

    /**
     * Formats every user to a String file format, so it can be saved in a document
     *
     * @return String with formatted users
     */
    public String toFile() {
        StringBuilder usersString = new StringBuilder();
        int counter = 0;

        while (counter < this.getNum()) {
            usersString.append(this.arrUsers[counter].toFile());
            if (counter != (this.getNum() - 1)) {
                usersString.append("\n");
            }
            counter++;
        }
        return usersString.toString();
    }

}