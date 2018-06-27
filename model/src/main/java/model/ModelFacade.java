package model;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import model.dao.ExampleDAO;
import model.map.Map;
import model.save.SaveManager;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }

	@Override
	public Map getMapById(int id) {
		URL url;
		StringBuilder scn = new StringBuilder();
		String score = null;
		String rows = null;
		String columns = null;
		
		try {
			String s = SaveManager.getMapUrlFromDB(id);
			score = SaveManager.GetScoreMapId(id);
			rows = SaveManager.GetMapRow(id);
			columns = SaveManager.GetMapColumn(id);
			url = new URL(s);
			URLConnection yc = url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        String outputLine;
	        while ((outputLine = in.readLine()) != null) {
	        	scn.append(outputLine + System.getProperty("line.separator"));
	        }
	           
	        in.close();
	        System.out.print(scn.toString());
	        return new Map(Integer.parseInt(rows), Integer.parseInt(columns), id, Integer.parseInt(score), 0, scn.toString());
	        
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}

	@Override
	public Rectangle getMapRectangleById(int id) {
		// TODO Auto-generated method stub
		return new Rectangle(0, 0, 20, 11);
	}
	
	

}
