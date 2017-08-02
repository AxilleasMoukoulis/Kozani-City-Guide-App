package city_guide_webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category {
	
	private int category_id;
	private String category_name;

	public Category() {this.category_id=0; this.category_name="";}
	public Category(int category_id, String category_name) {this.category_id=category_id;this.category_name=category_name;}
	
	public void setCategory_id(int category_id) {this.category_id=category_id;}
	public void setCategory_name(String category_name) {this.category_name=category_name;}

	public int getCategory_id() {return this.category_id;}
	public String getCategory_name() {return this.category_name;}
	
	@Override
	public String toString() 
	{return "category_id:"+String.valueOf(this.category_id)+"\ncategory_name:"+String.valueOf(this.category_name);}

}
