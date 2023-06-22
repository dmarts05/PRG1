package es.unileon.prg1.calendar.events;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaceTest {

	Place mic;

	@Before
	public void setUp() throws Exception {
		this.mic = new Place("MIC");
	}

	@Test
	public void testPlace() {
		assertEquals("MIC", this.mic.toString());
	}

	@Test
	public void testGetSetName() {
		assertEquals("MIC", this.mic.getName());
		this.mic.setName("ULE");
		assertEquals("ULE", this.mic.getName());
	}

	@Test
	public void testToString() {
		assertEquals("MIC", this.mic.toString());
	}

}
