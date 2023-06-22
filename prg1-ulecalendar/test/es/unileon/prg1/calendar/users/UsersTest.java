package es.unileon.prg1.calendar.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsersTest {
    Users localUsers;
    User userAlex, userBonnie, userColin;

    @Before
    public void setUp() throws Exception {
        this.localUsers = new Users();
        this.userAlex = new User("USER alea Alex Archer");
        this.userBonnie = new User("USER bonb Bonnie Bird");
        this.userColin = new User("USER colc Colin Cook");
        this.localUsers.add(this.userAlex);
        this.localUsers.add(this.userBonnie);
    }

    @Test
    public void testUsers() {
        assertEquals(2, this.localUsers.getNum());
    }

    @Test
    public void testGetNum() throws UserException {
        assertEquals(2, this.localUsers.getNum());
        this.localUsers.add(this.userColin);
        assertEquals(3, this.localUsers.getNum());
    }

    @Test
    public void testAdd() throws UserException {
        assertEquals(2, this.localUsers.getNum());
        assertNull(this.localUsers.search("colc"));
        this.localUsers.add(this.userColin);
        assertEquals(3, this.localUsers.getNum());
        assertNotNull(this.localUsers.search("colc"));
    }

    @Test
    public void testAddDoubleCapacity() throws UserException {
        this.localUsers.add(this.userColin);
        this.localUsers.add(new User("USER dand Danielle Davidson"));
        assertEquals(4, this.localUsers.getNum());
    }

    @Test(expected = UserException.class)
    public void testAddRepeatedUser() throws UserException {
        this.localUsers.add(new User("USER alea Alexander Albany"));
    }

    @Test
    public void testSearch() throws UserException {
        assertEquals(2, this.localUsers.getNum());
        assertNull(this.localUsers.search("colc"));
        this.localUsers.add(this.userColin);
        assertEquals(3, this.localUsers.getNum());
        assertNotNull(this.localUsers.search("colc"));
    }

    @Test
    public void testRemove() throws UserException {
        assertEquals(2, this.localUsers.getNum());
        this.localUsers.add(this.userColin);
        assertEquals(3, this.localUsers.getNum());
        assertNotNull(this.localUsers.search("bonb"));
        assertTrue(this.localUsers.remove("bonb"));
        assertEquals(2, this.localUsers.getNum());
        assertNull(this.localUsers.search("bonb"));
    }

    @Test
    public void testRemoveEmpty() throws UserException {
    	this.localUsers = new Users();
        assertFalse(this.localUsers.remove("bonb"));
    }

    @Test
    public void testToString() {
        assertEquals("Alex Archer (alea)\n\n" // no events
                + "Bonnie Bird (bonb)" // no events
                , this.localUsers.toString());
    }

    @Test
    public void testToFile() {
        assertEquals("USER alea Alex Archer\n" + "USER bonb Bonnie Bird", this.localUsers.toFile());
    }

}
