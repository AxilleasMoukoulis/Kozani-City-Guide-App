package city_guide_webservice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;


public class DBConnection {

	public static String DBCLASS = "com.mysql.jdbc.Driver";
	private static String DBNAME = "city_guide";
	public static String DBURL = "jdbc:mysql://localhost:3306/" + DBNAME;
	public static String DBUSER = "city_guide";
	public static String DBPASSWORD = "city_guide_2016";
	
	private static Connection connection = null;
	
	public static void createConnection() throws Exception {
		try{
			Class.forName(DBCLASS);
			connection = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}
		catch (Exception e) {
			throw e;
		}	
	}
	
	public static ArrayList<Category> getCategories() throws SQLException, Exception{
		ArrayList<Category> categories = new ArrayList<>();

		try{
			try{
				DBConnection.createConnection();
			}
			catch (Exception e){
				e.printStackTrace();
			}

			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Categories";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				
				Category tmp = new Category(rs.getInt("category_id"), rs.getString("category_name"));
				categories.add(tmp);
			}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
			throw sqle;
		}
		return categories;
	}

	public static ArrayList<Subcategory> getSubcategories() throws SQLException, Exception{
		ArrayList<Subcategory> subcategories = new ArrayList<>();

		try{
			try{
				DBConnection.createConnection();
			}
			catch (Exception e){
				e.printStackTrace();
			}

			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Subcategories";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				Subcategory tmp = new Subcategory(rs.getInt("subcategory_id"), rs.getString("subcategory_parent_id"), rs.getString("subcategory_name"));
				subcategories.add(tmp);
			}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
			throw sqle;
		}
		return subcategories;
	}
	
	public static ArrayList<PointOfInterest> getPointOfInterest(Integer subcategory) throws SQLException, Exception{
		ArrayList<PointOfInterest> pointofinterest = new ArrayList<>();

		try{
			try{
				DBConnection.createConnection();
			}
			catch (Exception e){
				e.printStackTrace();
			}

			Statement stmt = connection.createStatement();
			
			String query = null;
			if (subcategory >= 1 && subcategory <= 10) {query = "SELECT * FROM Points_of_interest WHERE `point_of_interest_subcategory_id`='"+String.valueOf(subcategory)+"'";}
			else if (subcategory == 0) 	{query = "SELECT * FROM Points_of_interest LIMIT 4";}
			else {query = "SELECT * FROM Points_of_interest";}
			
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				PointOfInterest tmp = new PointOfInterest(
						rs.getInt("point_of_interest_id"), 
						rs.getString("point_of_interest_name"),
						rs.getString("point_of_interest_subcategory_id"), 
						rs.getString("point_of_interest_lantitude"), 
						rs.getString("point_of_interest_longtitude"), 
						rs.getString("point_of_interest_address"),
						rs.getString("point_of_interest_description"));
				pointofinterest.add(tmp);
			}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
			throw sqle;
		}
		return pointofinterest;
	}
	
	/*public static Integer setPointOfInterest(String input) throws SQLException, Exception{
		
	    String TAG_POI_NAME = "point_of_interest_name";
	    String TAG_POI_SUBCATEGORY_NAME = "point_of_interest_subcategory_id";
	    String TAG_POI_LANDTITUDE = "point_of_interest_landtitude";
	    String TAG_POI_LONGTITUDE = "point_of_interest_longtitude";
	    String TAG_POI_ADDRESS = "point_of_interest_address";
	    String TAG_POI_DESCRIPTION = "point_of_interest_description";
		
	    JSONObject jsonObj = new JSONObject(input);
		try{
			try{
				DBConnection.createConnection();
			}
			catch (Exception e){
				e.printStackTrace();
			}
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO `Points_of_interest`(`point_of_interest_id`, `point_of_interest_name`, `point_of_interest_subcategory_id`, `point_of_interest_lantitude`, `point_of_interest_longtitude`, `point_of_interest_address`, `point_of_interest_description`) VALUES (\' \' , \"" + String.valueOf(jsonObj.getString(TAG_POI_NAME)) + "\",\""+ String.valueOf(jsonObj.getString(TAG_POI_SUBCATEGORY_NAME)) + "\",\"" + String.valueOf(jsonObj.getString(TAG_POI_SUBCATEGORY_NAME)) + "\",\"" + String.valueOf(jsonObj.getString(TAG_POI_SUBCATEGORY_NAME)) + "\",\"" + String.valueOf(jsonObj.getString(TAG_POI_LANDTITUDE)) + "\",\"" + String.valueOf(jsonObj.getString(TAG_POI_LONGTITUDE)) + "\",\"" + String.valueOf(jsonObj.getString(TAG_POI_ADDRESS)) + "\",\"" + String.valueOf(jsonObj.getString(TAG_POI_DESCRIPTION)) + "\")";                          
	
			stmt.executeUpdate(query);
			return 1;
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
			return -1;
		}
		
	}*/
}
	

	
