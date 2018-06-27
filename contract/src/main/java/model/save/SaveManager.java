package model.save;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.dao.AbstractDAO;
import model.map.Map;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author dpbou
 *
 *This class manage the save.
 */

public abstract class SaveManager extends AbstractDAO {
	
	
	/**
	 * The sql request for the DB
	 */
	 private static String sqlproGetMapColumn = "{call proGetMapColumn(?)}";
	 private static String sqlproGetMapRow = "{call proGetMapRow(?)}";
	 private static String sqlproSetSave   = "{call proSetSave(?, ?)}";
	 private static String sqlproSetMapInfo = "{call proSetMapInfo(?, ?, ?, ?, ?, ?)}";
	 private static String sqlproSetMapUrl = "{call proSetMapUrl(?, ?)}";
	 private static String sqlproGetMapUrl = "{call proGetMapUrl(?)}";
	 private static String sqlproGetSave = "{call proGetSave(?)}";
	 private static String sqlproGetAllSave = "{call proGetAllSave}";
	 private static String sqlproGetMap = "{call proGetMap(?)}";
	 private static String sqlproGetMapInfo = "{call proGetMapInfo(?)}";
	 private static String sqlproGetScoreMapId = "{call proGetScoreMapId(?)}";
	 private static String sqlproSetMapLine = "{call proSetMapLine(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	
	 /**
	  * The attribute for sql request
	  */ /*
	 private static int level = 1;
	 private static int score = 2;
	 private static int width = 3;
	 private static int heigth =4;
	 private static int startX =5;
	 private static int startY =6;
	 private static int scoreMap =7;*/

//---------------------------------------------------------------------------------------------------------
//		Save score in local
//---------------------------------------------------------------------------------------------------------
	 /**
 *  write the score make in each map of the game in a text file.
 *  Delete the old file of the map and rewrite the score save of all map load in a new file.
 * @param boardMap
 */
	public static void writeLocalSave(Map[] boardMap) {
		
		FileWriter wsave = null;
		BufferedWriter save = null;
		String lineFeed = System.getProperty("line.separator");
		String delimiter = ";";
		String pathFile = "Save.txt";
		
		
		try {
			
			/**
			 * Delete the old save file.
			 */
			File file = new File(pathFile);
        	file.delete();
    		
			/**
			 * Instanced new object for write on the text
			 */
			wsave = new FileWriter(pathFile, true);
			save = new BufferedWriter(wsave);
			
			/**
			 * Cross the board send in parameter
			 */ 
			for(int i=0; i< boardMap.length; i++) { 
				
				/**
				 * take maps in the board and get the level and the score of the map
				 */
				String content = (boardMap[i].getLevel() + delimiter + boardMap[i].getScoreSave() + lineFeed);

				save.write(content);
			};
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(save != null)
					save.close();
				if(wsave != null)
					wsave.close();
				
			}catch (IOException ex) {
				
				
				ex.printStackTrace();
			}
		}
	}
	
//---------------------------------------------------------------------------------------------------------
//		Save score in DB
//---------------------------------------------------------------------------------------------------------
	/**
 *  write the score make in each map of the game in a DB, call the SQL request
 * @param boardMap
 * @throws SQLException
 */
	public static void writeDBSave(Map[] boardMap) throws SQLException {
		
		/**
		 * Cross the board for save the player's score in a DB
		 */
		for(int i=0; i < boardMap.length; i++) {
			final CallableStatement callStatement = prepareCall(sqlproSetSave);
			/**
			 * Set the parameter of the request
			 */
			callStatement.setInt(1, boardMap[i].getLevel());
			callStatement.setInt(2, boardMap[i].getScoreSave());
			callStatement.executeQuery();
		}
		
	}

//---------------------------------------------------------------------------------------------------------
//		Save map in local
//---------------------------------------------------------------------------------------------------------
/**
 * Save a map in local.
 * Write in the file of the characteristics of the map select.
 * 
 * @param level
 * @param width
 * @param height
 * @param scoreMax
 * @param lineMap
 */
	public static void writeLocalSaveMap(int level, int width, int height, int scoreMax, String lineMap) {
		
		FileWriter wsave = null;
		BufferedWriter mapsave = null;
		/**
		 * Define few parameter to format the save
		 */
		String lineFeed = System.getProperty("line.separator");
		String nameFile = "map_" + level;
		String pathFile = "../Map/" + nameFile + ".txt";
		
		try {
		
			wsave = new FileWriter(pathFile);
			mapsave = new BufferedWriter(wsave);
			
			/**
			 * Set the content for write in the file
			 */
			String content = width + lineFeed;
			mapsave.write(content);
			content = height + lineFeed;
			mapsave.write(content);
			content = scoreMax + lineFeed;
			mapsave.write(content);
			content = lineMap;
			mapsave.write(content);
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(mapsave != null)
					mapsave.close();
				if(wsave != null)
					wsave.close();
				
			}catch (IOException ex) {
				
				
				ex.printStackTrace();
			}
		}
	}

	
//---------------------------------------------------------------------------------------------------------
//		Save map info in DB
//---------------------------------------------------------------------------------------------------------
	/**
	 * Call the request for save the map info in the BDD
	 * @param level
	 * @param width
	 * @param heigth
	 * @param startX
	 * @param startY
	 * @param scoreMax
	 * @throws SQLException
	 */
	public static void writeDBMapInfo(int level, int width, int heigth, int startX, int startY, int scoreMax) throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproSetMapInfo);
		
		callStatement.setInt(1, level);
		callStatement.setInt(2, width);
		callStatement.setInt(3, heigth);
		callStatement.setInt(4, startX);
		callStatement.setInt(5, startY);
		callStatement.setInt(6, scoreMax);
		callStatement.executeQuery();
	}
	
//---------------------------------------------------------------------------------------------------------
//		Save map Line in DB
//---------------------------------------------------------------------------------------------------------

	public static void writeDBMap(int level, String map) throws SQLException {
		
		
		
		if(map.length() <= 264) {
			
			String separator = "\n";
			String[] mapLine = map.split(separator);
			final CallableStatement callStatement = prepareCall(sqlproSetMapLine);
			
			for(int y=0; y < 12 ; y++) {
				System.out.println(mapLine[y]);
			}
			callStatement.setInt(1, level);
			callStatement.setString(2, mapLine[0]);
			callStatement.setString(3, mapLine[1]);
			callStatement.setString(4, mapLine[2]);
			callStatement.setString(5, mapLine[3]);
			callStatement.setString(6, mapLine[4]);
			callStatement.setString(7, mapLine[5]);
			callStatement.setString(8, mapLine[6]);
			callStatement.setString(9, mapLine[7]);
			callStatement.setString(10, mapLine[8]);
			callStatement.setString(11, mapLine[9]);
			callStatement.setString(12, mapLine[10]);
			callStatement.setString(13, mapLine[11]);
			callStatement.execute();

		}else {
			System.out.println("Caractere manquant dans le fichier map");
		}
	}

//---------------------------------------------------------------------------------------------------------
//	Save map url in DB
//---------------------------------------------------------------------------------------------------------
/**
 * Sabe the url map in DB
 * @param level
 * @param url
 * @throws SQLException
 */
	public static void writeDBMapUrl(int level, String url) throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproSetMapUrl);
		
		callStatement.setInt(1, level);
		callStatement.setString(2, url);
		callStatement.executeQuery();
	}


	
	
	
//---------------------------------------------------------------------------------------------------------
//		Get one score from local
//---------------------------------------------------------------------------------------------------------
	/**
	 * Get the score from local's save file.	
	 * @param level
	 * @return
	 */
	public static String getLocalScore(int level) {
		
		BufferedReader br = null;
		FileReader fr = null;
		String score ="";
		String line = "";
		String[] arrayline = null;
		
		try {
			
			fr = new FileReader("Save.txt");
			br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				arrayline = line.split(";");
				if((Integer.parseInt(arrayline[0])) == level) {
					score = score + arrayline[0] + ";" + arrayline[1] + "\n";
				}
			}
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
	}
		System.out.println(score);
		return score;
}

//---------------------------------------------------------------------------------------------------------
//		Get all score from Local
//---------------------------------------------------------------------------------------------------------
	/**
	 * return all the score save in local file
	 * @return
	 */
	public static String getAllLocalScore() {
		
		BufferedReader br = null;
		FileReader fr = null;
		String score ="";
		String line = "";
		String[] arrayline;
		ArrayList<Integer> arrayScore = new ArrayList();
		int i=0;
		int pomme;
		
		try {
			
			fr = new FileReader("Save.txt");
			br = new BufferedReader(fr);
			
			
			while((line = br.readLine()) != null) {
				arrayline = line.split(";");
				score =  score + arrayline[0] + ";" +arrayline[1] + "\n";				
			}
			
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		System.out.println(score);
		return score;
	}
	
//---------------------------------------------------------------------------------------------------------
//		Get one score from DB
//---------------------------------------------------------------------------------------------------------
	/**
	 * Return the score of one map select from DB
	 * @param level
	 * @return
	 * @throws SQLException
	 */
	public static String getScoreFromDB(int level) throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproGetSave);
		String score = "";
		
		callStatement.setInt(1, level);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
		if (result.first()) {
            score = result.getString(1);
        }
        result.close();
		
		}
		return score;
	}
	
//---------------------------------------------------------------------------------------------------------
//		Get all score from DB
//---------------------------------------------------------------------------------------------------------
	/**
	 * Return all save from DB
	 * @return
	 * @throws SQLException
	 */
	public static String getAllScoreFromDB() throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproGetAllSave);
		String score = "";
		
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				
				while(result != null) {
					
					score = score + result.getString(1) + ";" + result.getString(2) + "\n";
					if(result.next() != true) {
						break;
					}
				}
				
			}
			result.close();
		}	
		System.out.println(score);
		return score;
	}
	
//---------------------------------------------------------------------------------------------------------
//		Get the map from local files
//---------------------------------------------------------------------------------------------------------
/**
 * Get map from local file's map
 * @param level
 * @return
 * @throws IOException 
 * @throws NumberFormatException 
 */
	public static Map getMapFromLocal(int level) throws NumberFormatException, IOException  {
		
		String pathFile = "../Map/map_" + level + ".txt";
		int width =0;
		int heigth =0;
		int scoreMax =0;
		String lineRead = "";
		String caractmap = "";
		
		try {
			
			/**
			 * create bufferedReader for read the file
			 */
			InputStream ips = new FileInputStream(pathFile);
			InputStreamReader ipsr= new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			
			width = Integer.parseInt(br.readLine());
			System.out.println(width);
			heigth = Integer.parseInt(br.readLine());
			System.out.println(heigth);
			scoreMax = Integer.parseInt(br.readLine());
			System.out.println(scoreMax);
			
			while((lineRead = br.readLine()) !=null) {
				caractmap = caractmap + lineRead;
			}
			
			System.out.println(caractmap);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("The request levelis not available");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}	
		
		Map mapLoad = new Map(width, heigth, level, scoreMax, 0, caractmap);
		
		return mapLoad;
	}

//---------------------------------------------------------------------------------------------------------
//		Get the map from DB
//---------------------------------------------------------------------------------------------------------
	/**
	 * Get the map from the DB and return them
	 * @param level
	 * @return
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public static Map getMapFromDB(int level) throws SQLException, FileNotFoundException {
		
		int width =0;
		int heigth =0;
		int scoreMax =0;
		int startX = 0;
		int startY =0;
		String mapInfo ="";
		String mapLine ="";
		int i=1;
		String[] arrayline;
		
		CallableStatement callStatement = prepareCall(sqlproGetMapInfo);
		
		callStatement.setInt(1, level);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				while(result != null) {
					mapInfo = mapInfo + result.getLong(i) + ";";
					i++;
					if(i == 6) {
						break;
					}
				}
				arrayline = mapInfo.split(";");
				width = Integer.parseInt(arrayline[0]);
				heigth = Integer.parseInt(arrayline[1]);
				startX = Integer.parseInt(arrayline[2]);
				startY = Integer.parseInt(arrayline[3]);
				scoreMax = Integer.parseInt(arrayline[4]);
				
			}
		result.close();
		}
		
		callStatement = prepareCall(sqlproGetMap);
		callStatement.setInt(1, level);
		
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				while(result != null) {
					mapLine = mapLine + result.getString(i) + "\n";
					i++;
					if(i == 13) {
						break;
					}
				}
				System.out.println(mapLine);
				
			}
		result.close();
		}
		
		Map mapLoad;
		try {
			mapLoad = new Map(width, heigth, level, scoreMax, 0, mapLine);
			return mapLoad;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

//---------------------------------------------------------------------------------------------------------
//		Get the map url from DB
//---------------------------------------------------------------------------------------------------------
	/**
	 * Get the map url from the DB
	 * @param level
	 * @return
	 * @throws SQLException
	 */
	public static String getMapUrlFromDB(int level) throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproGetMapUrl);
		String url = " ";
		
		callStatement.setInt(1, level);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
		if (result.first()) {
            url = result.getString(1);
        }
        result.close();
    }
		
		return url;
	}
	
	public static String GetScoreMapId(int level) throws SQLException {
			
		final CallableStatement callStatement = prepareCall(sqlproGetScoreMapId);
		String url = " ";
		
		callStatement.setInt(1, level);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
		if (result.first()) {
            url = result.getString(1);
        }
        result.close();
    }
		
		return url;
	}
	
	public static String GetMapRow(int level) throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproGetMapRow);
		String url = " ";
		
		callStatement.setInt(1, level);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
		if (result.first()) {
            url = result.getString(1);
        }
        result.close();
    }
		
		return url;
	}
	
	public static String GetMapColumn(int level) throws SQLException {
		
		final CallableStatement callStatement = prepareCall(sqlproGetMapColumn);
		String url = " ";
		
		callStatement.setInt(1, level);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
		if (result.first()) {
            url = result.getString(1);
        }
        result.close();
    }
		
		return url;
	}
	
	
}

