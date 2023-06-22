package es.unileon.prg1.calendar.io;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileTest {

	private File file;
	private String fileName;

	@Before
	public void setUp() throws Exception {
		this.fileName = "./test/rightCalendar.txt";
		this.file = new File(this.fileName);
	}

	@Test
	public void testFile() {
		assertEquals(this.fileName, this.file.getName());
	}

	@Test
	public void testReadElements() throws FileException {
		assertEquals("USER alea Alex Archer\n" + "USER bonb Bonnie Bird\n" + "USER colc Colin Cook\n"
				+ "EVENT alea Class ULE 11/11/2011 9:00 13:00\n" + "EVENT alea Meeting MIC 11/11/2011 13:00 14:00\n"
				+ "EVENT alea Lunch Cafeteria 11/11/2011 14:00 15:00\n"
				+ "EVENT bonb Class ULE 11/11/2011 15:00 19:00\n"
				+ "EVENT bonb Meeting Library 11/11/2011 13:00 14:00\n", this.file.readElements());
	}

	@Test
	public void testWriteElements() throws FileException {

		File f = new File("./test/test.txt");

		boolean succeed = f.writeElements("USER colc Colin Cook\n" + "EVENT colc Class ULE 11/11/2011 09:00 13:00\n");
		assertTrue(succeed);
		assertEquals("USER colc Colin Cook\n" + "EVENT colc Class ULE 11/11/2011 09:00 13:00\n", f.readElements());

		succeed = f.writeElements(this.file.readElements());
		assertTrue(succeed);
		assertEquals("USER alea Alex Archer\n" + "USER bonb Bonnie Bird\n" + "USER colc Colin Cook\n"
				+ "EVENT alea Class ULE 11/11/2011 9:00 13:00\n" + "EVENT alea Meeting MIC 11/11/2011 13:00 14:00\n"
				+ "EVENT alea Lunch Cafeteria 11/11/2011 14:00 15:00\n"
				+ "EVENT bonb Class ULE 11/11/2011 15:00 19:00\n"
				+ "EVENT bonb Meeting Library 11/11/2011 13:00 14:00\n", f.readElements());

		succeed = f.delete();
		assertTrue(succeed);

	}

}
