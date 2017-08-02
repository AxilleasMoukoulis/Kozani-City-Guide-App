package city_guide_webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PointOfInterest {
	
	private int point_of_interest_id;
	private String point_of_interest_name;
	private String point_of_interest_subcategory_id;
	private String point_of_interest_landtitude;
	private String point_of_interest_longtitude;
	private String point_of_interest_address;
	private String point_of_interest_description;

	public PointOfInterest() 
	{
		this.point_of_interest_id = 0; 
		this.point_of_interest_name = ""; 
		this.point_of_interest_subcategory_id = ""; 
		this.point_of_interest_landtitude = ""; 
		this.point_of_interest_longtitude = ""; 
		this.point_of_interest_address = "";
		this.point_of_interest_description = "";
	}
	
	public PointOfInterest(
			int point_of_interest_id, 
			String point_of_interest_name, 
			String point_of_interest_subcategory_id, 
			String point_of_interest_landtitude, 
			String point_of_interest_longtitude, 
			String point_of_interest_address, 
			String point_of_interest_description) 
	{
		this.point_of_interest_id = point_of_interest_id; 
		this.point_of_interest_name = point_of_interest_name; 
		this.point_of_interest_subcategory_id = point_of_interest_subcategory_id; 
		this.point_of_interest_landtitude = point_of_interest_landtitude; 
		this.point_of_interest_longtitude = point_of_interest_longtitude; 
		this.point_of_interest_address = point_of_interest_address;
		this.point_of_interest_description = point_of_interest_description;
	}
	
	public void setPoint_of_interest_id(int point_of_interest_id) {this.point_of_interest_id = point_of_interest_id;}
	public void setPoint_of_interest_name(String point_of_interest_name) {this.point_of_interest_name = point_of_interest_name;}
	public void setPoint_of_interest_subcategory_id(String point_of_interest_subcategory_id) {this.point_of_interest_subcategory_id = point_of_interest_subcategory_id;}
	public void setPoint_of_interest_landtitude(String point_of_interest_landtitude) {this.point_of_interest_landtitude = point_of_interest_landtitude;}
	public void setPoint_of_interest_longtitude(String point_of_interest_longtitude) {this.point_of_interest_longtitude = point_of_interest_longtitude;}
	public void setPoint_of_interest_address(String point_of_interest_address) {this.point_of_interest_address = point_of_interest_address;}
	public void setPoint_of_interest_description(String point_of_interest_description) {this.point_of_interest_description = point_of_interest_description;}

	public int getPoint_of_interest_id() {return this.point_of_interest_id;}
	public String getPoint_of_interest_name() {return this.point_of_interest_name;}
	public String getPoint_of_interest_subcategory_id() {return this.point_of_interest_subcategory_id;}
	public String getPoint_of_interest_landtitude() {return this.point_of_interest_landtitude;}
	public String getPoint_of_interest_longtitude() {return this.point_of_interest_longtitude;}
	public String getPoint_of_interest_address() {return this.point_of_interest_address;}	
	public String getPoint_of_interest_description() {return this.point_of_interest_description;}

	@Override
	public String toString()
	{return "point_of_interest_id:"+String.valueOf(this.point_of_interest_id)+
			"\npoint_of_interest_name:"+String.valueOf(this.point_of_interest_name)+
			"\npoint_of_interest_subcategory_id:"+String.valueOf(this.point_of_interest_subcategory_id)+
			"\npoint_of_interest_landtitude:"+String.valueOf(this.point_of_interest_landtitude)+
			"\npoint_of_interest_longtitude:"+String.valueOf(this.point_of_interest_longtitude)+
			"\npoint_of_interest_address:"+String.valueOf(this.point_of_interest_address)+
			"\npoint_of_interest_description:"+String.valueOf(this.point_of_interest_description);}
	
}
