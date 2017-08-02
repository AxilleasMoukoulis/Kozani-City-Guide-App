package city_guide_webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

@Path("/")
public class Server {

	@GET
	@Path("/getCategories")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Category>  getCategory(){
		ArrayList<Category> categories = null;
		try{
			categories = DBConnection.getCategories();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	@GET
	@Path("/getSubcategories")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Subcategory>  getSubcategory(){
		ArrayList<Subcategory> subcategories = null;
		try{
			subcategories = DBConnection.getSubcategories();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return subcategories;
	}
	
	@GET
	@Path("/getPointOfInterest")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<PointOfInterest>  getPointOfInterest(@QueryParam("subcategory") String subcategory){
		ArrayList<PointOfInterest> pointofinterest = null;
		try{
			pointofinterest = DBConnection.getPointOfInterest(Integer.valueOf(subcategory));
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return pointofinterest;
	}
	
	/*@POST
	@Path("/setPointOfInterest")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setPointOfInterest(InputStream incomingData) throws IOException
	{
		StringBuilder pushData = new StringBuilder();
		Integer res = 0;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while((line = in.readLine()) != null)
			{
				pushData = pushData.append(line);			
			}
			res = DBConnection.setPointOfInterest(pushData.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(res.toString() +" "+ pushData.toString()).build();
	}*/
	
}







