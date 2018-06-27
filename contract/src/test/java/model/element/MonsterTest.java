package model.element;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.IA.Arbarr;

public class MonsterTest {
	Monster monster;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		monster = new Monster("arbarr.png", new Arbarr(), 4, 8);
		monster.loadImage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX() {
		int expected = 4;
		assertEquals(expected, this.monster.getX());
	}

	@Test
	public void testGetY() {
		int expected = 8;
		assertEquals(expected, this.monster.getY());
	}

	@Test
	public void testGetPosition() {
		Point expected = new Point(4, 8);
		assertEquals(expected, this.monster.getPosition());
	}

	@Test
	public void testSetPositionPoint() {
		Point expected = new Point(5, 9);
		this.monster.setPosition(expected);
		assertEquals(expected, this.monster.getPosition());
	}

	@Test
	public void testSetPositionIntInt() {
		Point expected = new Point(6,7);
		
		this.monster.setPosition(expected.x, expected.y);
		
		assertEquals(expected, this.monster.getPosition());
		
	}

}
