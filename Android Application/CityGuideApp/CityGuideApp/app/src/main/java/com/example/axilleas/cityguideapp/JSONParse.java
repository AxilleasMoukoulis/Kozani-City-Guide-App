package com.example.axilleas.cityguideapp;

import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by paris on 18/01/16.
 */
public class JSONParse {

    //Point of Interest TAGS
    private static final String TAG_POI = "pointOfInterest";
    private static final String TAG_POI_ID = "point_of_interest_id";
    private static final String TAG_POI_NAME = "point_of_interest_name";
    private static final String TAG_POI_SUBCATEGORY_NAME = "point_of_interest_subcategory_id";
    private static final String TAG_POI_LANDTITUDE = "point_of_interest_landtitude";
    private static final String TAG_POI_LONGTITUDE = "point_of_interest_longtitude";
    private static final String TAG_POI_ADDRESS = "point_of_interest_address";
    private static final String TAG_POI_DESCRIPTION = "point_of_interest_description";

    public ArrayList<PointOfInterest> parsePointofinterest(String pointofinterest_string) throws JSONException {
        //Log.d("JSON PARSE: ", String.valueOf(categories_string));

        ArrayList<PointOfInterest> pointofinterest_result = new ArrayList<>();
        JSONArray pointofinterest_json = null;

        if (pointofinterest_string != null) {

            JSONObject jsonObj = new JSONObject(pointofinterest_string);
            pointofinterest_json = jsonObj.getJSONArray(TAG_POI);
            // looping through POI
            for (int i = 0; i < pointofinterest_json.length(); i++) {
                JSONObject tmp_json = pointofinterest_json.getJSONObject(i);

                PointOfInterest tmp_pointofinterest = new PointOfInterest(tmp_json.getInt(TAG_POI_ID), tmp_json.getString(TAG_POI_NAME), tmp_json.getString(TAG_POI_SUBCATEGORY_NAME), Double.valueOf(tmp_json.getString(TAG_POI_LANDTITUDE)), Double.valueOf(tmp_json.getString(TAG_POI_LONGTITUDE)), tmp_json.getString(TAG_POI_ADDRESS), tmp_json.getString(TAG_POI_DESCRIPTION));
                pointofinterest_result.add(tmp_pointofinterest);
            }
        }
        return pointofinterest_result;
    }

    public ArrayList<PointOfInterest> eucledianDistance(ArrayList<PointOfInterest> poi, Activity activity)
    {
        //GPSTracker gps = new GPSTracker(this.getActivity());
        GPSTracker gps = new GPSTracker(activity);
        if (gps.canGetLocation()) { //check if GPS enabled

            for (PointOfInterest i : poi)
            {
                double tmp = Math.sqrt(Math.pow(gps.getLatitude() - i.getPoint_of_interest_landtitude(), 2) + Math.pow(gps.getLongitude() - i.getPoint_of_interest_longtitude(), 2));
                i.setPoint_of_interest_euclidean_distance(tmp);
                //Log.i("EUKLEIDIA APOSTASI: ", String.valueOf(i.getPoint_of_interest_eucledian_disatnce()));
            }
            Collections.sort(poi, new PointOfInterest.OrderByEucledianDistance());
        } else { //can't get location
            gps.showSettingsAlert();
        }
        return poi;
    }

}
