package model.element;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.motionless.MotionlessElementFactory;

public class ElementTest {
	Element bone;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MotionlessElementFactory.loadAllImage();
		bone = MotionlessElementFactory.createBone();
	

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSprite() {
		char expected = 'W';
		assertEquals(expected, this.bone.getSprite());
	}

	@Test
	public void testGetTile() {
		assertNotNull(this.bone.getTile());
	}

	@Test
	public void testSetTile() {
		Tile expected = new Tile("purse.png");
		this.bone.setTile(expected);
		assertEquals(expected, this.bone.getTile());
	}

}
