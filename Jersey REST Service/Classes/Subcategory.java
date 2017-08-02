package city_guide_webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Subcategory extends Category{

	private String subcategory_name;
	
	public Subcategory(){super(); this.subcategory_name="";}
	public Subcategory(int category_id, String category_name, String subcategory_name)
	{super(category_id, category_name); this.subcategory_name=subcategory_name;}

	public void setSubcategory_id(int category_id) {super.setCategory_id(category_id);}
	public void setSubcategory_parent_name(String parent_name) {super.setCategory_name(parent_name);}
	public void setSubcategory_name(String category_name) {super.setCategory_name(category_name);}

	public int getCategory_id() {return super.getCategory_id();}
	public String getCategory_parent_name() {return super.getCategory_name();}
	public String getCategory_name() {return this.subcategory_name;}
		
	@Override
	public String toString() 
	{return super.toString()+"\nsubcategory_name"+String.valueOf(this.subcategory_name);}

}
