package com.example.axilleas.cityguideapp.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.axilleas.cityguideapp.CustomAdapter;
import com.example.axilleas.cityguideapp.GetData;
import com.example.axilleas.cityguideapp.JSONParse;
import com.example.axilleas.cityguideapp.PointOfInterest;
import com.example.axilleas.cityguideapp.R;
import com.example.axilleas.cityguideapp.ScrollingActivity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class TrendingFragment extends android.app.Fragment{

    protected CardView card1, card2, card3, card4;
    protected TextView title1, title2, title3, title4;
    protected TextView description1, description2, description3, description4;
    protected RoundedImageView img1, img2, img3, img4;
    protected Button load_more_btn1, load_more_btn2, load_more_btn3, load_more_btn4;
    protected Button map_view_btn1, map_view_btn2, map_view_btn3, map_view_btn4;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private View rootView;
    private ArrayList<PointOfInterest> poi_trending;//pointofinterest;

    protected Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        haveNetworkConnection();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.trending_layout, container, false);
        initComponents();

        try {
            initDataset();
        } catch (MalformedURLException e) {
            //e.printStackTrace();
        } catch (JSONException e) {
            //e.printStackTrace();
        } catch (ExecutionException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        return rootView;
    }

    private void initComponents() {

        card1 = (CardView)rootView.findViewById(R.id.card_view);
        card2 = (CardView)rootView.findViewById(R.id.card_view2);
        card3 = (CardView)rootView.findViewById(R.id.card_view3);
        card4 = (CardView)rootView.findViewById(R.id.card_view4);

        title1 = (TextView)rootView.findViewById(R.id.poi_title);
        title2 = (TextView)rootView.findViewById(R.id.poi_title2);
        title3 = (TextView)rootView.findViewById(R.id.poi_title3);
        title4 = (TextView)rootView.findViewById(R.id.poi_title4);

        description1 = (TextView)rootView.findViewById(R.id.poi_description);
        description2 = (TextView)rootView.findViewById(R.id.poi_description2);
        description3 = (TextView)rootView.findViewById(R.id.poi_description3);
        description4 = (TextView)rootView.findViewById(R.id.poi_description4);

        img1 = (RoundedImageView)rootView.findViewById(R.id.trend_row_img);
        img2 = (RoundedImageView)rootView.findViewById(R.id.trend_row_img2);
        img3 = (RoundedImageView)rootView.findViewById(R.id.trend_row_img3);
        img4 = (RoundedImageView)rootView.findViewById(R.id.trend_row_img4);

        load_more_btn1 = (Button)rootView.findViewById(R.id.load_more_btn);
        load_more_btn2 = (Button)rootView.findViewById(R.id.load_more_btn2);
        load_more_btn3 = (Button)rootView.findViewById(R.id.load_more_btn3);
        load_more_btn4 = (Button)rootView.findViewById(R.id.load_more_btn4);

        map_view_btn1 = (Button)rootView.findViewById(R.id.map_view_btn);
        map_view_btn2 = (Button)rootView.findViewById(R.id.map_view_btn2);
        map_view_btn3 = (Button)rootView.findViewById(R.id.map_view_btn3);
        map_view_btn4 = (Button)rootView.findViewById(R.id.map_view_btn4);

    }

    private void fillComponents() {

        this.title1.setText(this.poi_trending.get(0).getPoint_of_interest_name());
        this.description1.setText(this.poi_trending.get(0).getPoint_of_interest_description());
        Picasso.with(getActivity()).load("http://83.212.110.211/cityguide/uploads/" + poi_trending.get(0).convertName() + "/1.jpg").into(img1);

        this.title2.setText(this.poi_trending.get(1).getPoint_of_interest_name());
        this.description2.setText(this.poi_trending.get(1).getPoint_of_interest_description());
        Picasso.with(getActivity()).load("http://83.212.110.211/cityguide/uploads/" + poi_trending.get(1).convertName() + "/1.jpg").into(img2);

        this.title3.setText(this.poi_trending.get(2).getPoint_of_interest_name());
        this.description3.setText(this.poi_trending.get(2).getPoint_of_interest_description());
        Picasso.with(getActivity()).load("http://83.212.110.211/cityguide/uploads/" + poi_trending.get(2).convertName() + "/1.jpg").into(img3);

        this.title4.setText(this.poi_trending.get(3).getPoint_of_interest_name());
        this.description4.setText(this.poi_trending.get(3).getPoint_of_interest_description());
        Picasso.with(getActivity()).load("http://83.212.110.211/cityguide/uploads/" + poi_trending.get(3).convertName() + "/1.jpg").into(img4);

        //CARD 1 LISTENERS
        load_more_btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
                //Log.d("Position Arraylist", " " + poi_trending.get(0));

                int id = poi_trending.get(0).getPoint_of_interest_id();
                String desciprption = poi_trending.get(0).getPoint_of_interest_description();
                String title = poi_trending.get(0).getPoint_of_interest_name();
                String address = poi_trending.get(0).getPoint_of_interest_address();
                String img = "http://83.212.110.211/cityguide/uploads/" + poi_trending.get(0).convertName() + "/1.jpg";
                Double longtitude = poi_trending.get(0).getPoint_of_interest_longtitude();
                Double latitude = poi_trending.get(0).getPoint_of_interest_landtitude();

                intent.putExtra("id", id);
                intent.putExtra("description", desciprption);
                intent.putExtra("title", title);
                intent.putExtra("address", address);
                intent.putExtra("img", img);
                intent.putExtra("long", longtitude);
                intent.putExtra("lat", latitude);
                startActivity(intent);
            }
        });

        map_view_btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + poi_trending.get(0).convertAddress() + "&z=18&avoid=tf");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

        });

        //CARD 2 LISTENERS
        load_more_btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
                //Log.d("Position Arraylist", " " + poi_trending.get(1));

                int id = poi_trending.get(1).getPoint_of_interest_id();
                String desciprption = poi_trending.get(1).getPoint_of_interest_description();
                String title = poi_trending.get(1).getPoint_of_interest_name();
                String address = poi_trending.get(1).getPoint_of_interest_address();
                String img = "http://83.212.110.211/cityguide/uploads/" + poi_trending.get(1).convertName() + "/1.jpg";
                Double longtitude = poi_trending.get(1).getPoint_of_interest_longtitude();
                Double latitude = poi_trending.get(1).getPoint_of_interest_landtitude();

                intent.putExtra("id", id);
                intent.putExtra("description", desciprption);
                intent.putExtra("title", title);
                intent.putExtra("address", address);
                intent.putExtra("img", img);
                intent.putExtra("long", longtitude);
                intent.putExtra("lat", latitude);
                startActivity(intent);
            }

        });

        map_view_btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + poi_trending.get(1).convertAddress() + "&z=18&avoid=tf");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

        });


        //CARD 3 LISTENERS
        load_more_btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
                //Log.d("Position Arraylist", " " + poi_trending.get(2));

                int id = poi_trending.get(2).getPoint_of_interest_id();
                String desciprption = poi_trending.get(2).getPoint_of_interest_description();
                String title = poi_trending.get(2).getPoint_of_interest_name();
                String address = poi_trending.get(2).getPoint_of_interest_address();
                String img = "http://83.212.110.211/cityguide/uploads/" + poi_trending.get(2).convertName() + "/1.jpg";
                Double longtitude = poi_trending.get(2).getPoint_of_interest_longtitude();
                Double latitude = poi_trending.get(2).getPoint_of_interest_landtitude();

                intent.putExtra("id", id);
                intent.putExtra("description", desciprption);
                intent.putExtra("title", title);
                intent.putExtra("address", address);
                intent.putExtra("img", img);
                intent.putExtra("long", longtitude);
                intent.putExtra("lat", latitude);
                startActivity(intent);
            }
        });

        map_view_btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + poi_trending.get(2).convertAddress() + "&z=18&avoid=tf");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        //CARD 4 LISTENERS
        load_more_btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
                //Log.d("Position Arraylist", " " + poi_trending.get(3));

                int id = poi_trending.get(3).getPoint_of_interest_id();
                String desciprption = poi_trending.get(3).getPoint_of_interest_description();
                String title = poi_trending.get(3).getPoint_of_interest_name();
                String address = poi_trending.get(3).getPoint_of_interest_address();
                String img = "http://83.212.110.211/cityguide/uploads/" + poi_trending.get(3).convertName() + "/1.jpg";
                Double longtitude = poi_trending.get(3).getPoint_of_interest_longtitude();
                Double latitude = poi_trending.get(3).getPoint_of_interest_landtitude();

                intent.putExtra("id", id);
                intent.putExtra("description", desciprption);
                intent.putExtra("title", title);
                intent.putExtra("address", address);
                intent.putExtra("img", img);
                intent.putExtra("long", longtitude);
                intent.putExtra("lat", latitude);
                startActivity(intent);
            }

        });

        map_view_btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + poi_trending.get(3).convertAddress() + "&z=18&avoid=tf");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

        });
    }


    private void initDataset() throws MalformedURLException, JSONException, ExecutionException, InterruptedException {

        if (this.poi_trending == null) {
            //DOWNLOAD DATA FROM WEB
            URL url = new URL("http://83.212.110.211:8080/city_guide_webservice/getPointOfInterest?subcategory=0");
            String pointofinterest_string = new GetData().execute(url).get();
            Log.d("MAIN-POI: ", String.valueOf(pointofinterest_string));

            if (pointofinterest_string != null) {
                //PARSE DATA FROM JSON TO OBJECTS
                JSONParse jsonparse = new JSONParse();
                this.poi_trending = jsonparse.parsePointofinterest(pointofinterest_string);
                fillComponents();
            }
        }
    }

    private void haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        if (!haveConnectedWifi && !haveConnectedMobile)
        {
            //Log.d("ANDROID", "No internet connenction!");
            openNetworkConnection();
        }
    }

    private void openNetworkConnection() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle(" Network management");
        alertDialogBuilder.setMessage("Your network connection is currently off! Turn on the internet?");
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @SuppressWarnings("ResourceType")
            public void onClick(DialogInterface dialog, int id) {
                // go to a new activity of the app
                //startActivity(new Intent(Settings.ACTION_SETTINGS));
                WifiManager wifiManager = (WifiManager)getActivity().getBaseContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        });
        // set negative button: No message
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // cancel the alert box and put a Toast to the user
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        // show alert
        alertDialog.show();
    }

}