package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TileTest {

	Tile tile;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tile = new Tile("gate_open.png");
		
		tile.loadImage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.tile.getImage());	
	}

	@Test
	public void testGetImageName() {
		String expected = "gate_open.png";
		assertEquals(expected, this.tile.getImageName());
	}

}
