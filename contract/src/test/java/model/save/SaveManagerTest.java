package model.save;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.map.Map;


public class SaveManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWriteLocalSave() {
	}

	@Test
	public void testWriteDBSave() {
	}

	@Test
	public void testWriteLocalSaveMap() {
	}

	@Test
	public void testWriteDBMapInfo() {
	}

	@Test
	public void testWriteDBMap() {
	}

	@Test
	public void testWriteDBMapUrl() {
	}

	@Test
	public void testGetLocalScore() {
		
		final String expected = "";
		assertEquals(expected, SaveManager.getLocalScore(1));
	}

	@Test
	public void testGetAllLocalScore() {
		
		final String expected = "";
		assertEquals(expected, SaveManager.getAllLocalScore());
	}

	@Test
	public void testGetScoreFromDB() throws SQLException {
			
		final String expected = null;
		assertEquals(expected, SaveManager.getScoreFromDB(1));
	}

	@Test
	public void testGetAllScoreFromDB() throws SQLException {
			
		final String expected = "";
		assertEquals(expected, SaveManager.getAllScoreFromDB());
	}

	@Test
	public void testGetMapFromLocal() throws NumberFormatException, IOException {
			
		Map myreturnObject = SaveManager.getMapFromLocal(1);
		assertTrue(myreturnObject instanceof Map);
	}

	@Test
	public void testGetMapFromDB() throws FileNotFoundException, SQLException {
		
		Map myreturnObject = SaveManager.getMapFromDB(1);
		assertTrue(myreturnObject instanceof Map);
	}

	@Test
	public void testGetMapUrlFromDB() throws SQLException {
		
		final String expected = "http://192.168.43.121/loraan/map/map_1.txt";
		assertEquals(expected, SaveManager.getMapUrlFromDB(1));
	}

}
