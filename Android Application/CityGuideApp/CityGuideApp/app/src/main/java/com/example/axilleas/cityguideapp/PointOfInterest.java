package com.example.axilleas.cityguideapp;

import android.util.Log;

import java.util.Comparator;

/**
 * Created by paris on 19/01/16.
 */
public class PointOfInterest implements Comparable<PointOfInterest> {

    private int point_of_interest_id;
    private String point_of_interest_name;
    private String point_of_interest_subcategory_id;
    private Double point_of_interest_landtitude;
    private Double point_of_interest_longtitude;
    private String point_of_interest_address;
    private String point_of_interest_description;
    private double point_of_interest_euclidean_distance;

    public PointOfInterest()
    {
        this.point_of_interest_id = 0;
        this.point_of_interest_name = "";
        this.point_of_interest_subcategory_id = "";
        this.point_of_interest_landtitude = 0.0;
        this.point_of_interest_longtitude = 0.0;
        this.point_of_interest_address = "";
        this.point_of_interest_description = "";
        this.point_of_interest_euclidean_distance = 0.0;
    }

    public PointOfInterest(int point_of_interest_id, String point_of_interest_name, String point_of_interest_subcategory_id,
                           Double point_of_interest_landtitude,Double point_of_interest_longtitude, String point_of_interest_address, String point_of_interest_description)
    {
        this.point_of_interest_id = point_of_interest_id;
        this.point_of_interest_name = point_of_interest_name;
        this.point_of_interest_subcategory_id = point_of_interest_subcategory_id;
        this.point_of_interest_landtitude = point_of_interest_landtitude;
        this.point_of_interest_longtitude = point_of_interest_longtitude;
        this.point_of_interest_address = point_of_interest_address;
        this.point_of_interest_description = point_of_interest_description;
        this.point_of_interest_euclidean_distance = 0.0;
    }

    public void setPoint_of_interest_id(int point_of_interest_id) {this.point_of_interest_id = point_of_interest_id;}
    public void setPoint_of_interest_name(String point_of_interest_name) {this.point_of_interest_name = point_of_interest_name;}
    public void setPoint_of_interest_subcategory_name(String point_of_interest_subcategory_id) {this.point_of_interest_subcategory_id = point_of_interest_subcategory_id;}
    public void setPoint_of_interest_landtitude(Double point_of_interest_landtitude) {this.point_of_interest_landtitude = point_of_interest_landtitude;}
    public void setPoint_of_interest_longtitude(Double point_of_interest_longtitude) {this.point_of_interest_longtitude = point_of_interest_longtitude;}
    public void setPoint_of_interest_address(String point_of_interest_address) {this.point_of_interest_address = point_of_interest_address;}
    public void setPoint_of_interest_description(String point_of_interest_description) {this.point_of_interest_description = point_of_interest_description;}
    public void setPoint_of_interest_euclidean_distance(Double point_of_interest_euclidean_distance) {this.point_of_interest_euclidean_distance = point_of_interest_euclidean_distance;}

    public int getPoint_of_interest_id() {return this.point_of_interest_id;}
    public String getPoint_of_interest_name() {return this.point_of_interest_name;}
    public String getPoint_of_interest_subcategory_id() {return this.point_of_interest_subcategory_id;}
    public Double getPoint_of_interest_landtitude() {return this.point_of_interest_landtitude;}
    public Double getPoint_of_interest_longtitude() {return this.point_of_interest_longtitude;}
    public String getPoint_of_interest_address() {return this.point_of_interest_address;}
    public String getPoint_of_interest_description() {return this.point_of_interest_description;}
    public Double getPoint_of_interest_eucledian_disatnce() {return this.point_of_interest_euclidean_distance;}

    public void printPoint_of_interest() {Log.d("POINT OF INTEREST: ", this.toString());}

    @Override
    public String toString()
    {return "\npoint_of_interest_id:"+String.valueOf(this.point_of_interest_id)+"\npoint_of_interest_name:"+String.valueOf(this.point_of_interest_name)+"\npoint_of_interest_subcategory_id:"+String.valueOf(this.point_of_interest_subcategory_id)+"\npoint_of_interest_landtitude:"+String.valueOf(this.point_of_interest_landtitude)+"\npoint_of_interest_longtitude:"+String.valueOf(this.point_of_interest_longtitude)+"\npoint_of_interest_address:"+String.valueOf(this.point_of_interest_address)+"\npoint_of_interest_description:"+String.valueOf(this.point_of_interest_description)+"\npoint_of_interest_eucledian_distance:"+String.valueOf(this.point_of_interest_euclidean_distance);}

    public static class OrderByEucledianDistance implements Comparator<PointOfInterest> {

        @Override
        public int compare(PointOfInterest poi_1, PointOfInterest poi_2) {
            return poi_1.getPoint_of_interest_eucledian_disatnce() > poi_2.getPoint_of_interest_eucledian_disatnce() ? 1 :
                    (poi_1.getPoint_of_interest_eucledian_disatnce() < poi_2.getPoint_of_interest_eucledian_disatnce() ? -1 : 0);
        }
    }

    @Override
    public int compareTo(PointOfInterest other) {
        return this.point_of_interest_euclidean_distance > other.getPoint_of_interest_eucledian_disatnce() ? 1 : (this.point_of_interest_euclidean_distance < other.getPoint_of_interest_eucledian_disatnce() ? -1 : 0);
    }

    public String convertAddress() {
        return this.point_of_interest_address.replace(' ', '+');

    }

    public String convertName() {
        return this.point_of_interest_name.replace(" ", "%20");

    }
}

