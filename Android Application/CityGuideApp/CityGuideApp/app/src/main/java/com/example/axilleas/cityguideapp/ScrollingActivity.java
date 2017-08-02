package com.example.axilleas.cityguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class ScrollingActivity extends AppCompatActivity {

    PointOfInterest pointOfInterest;

    private static TextView description_txt;
    private static TextView address_txt;
    private static RoundedImageView img;
    private String img_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        img = (RoundedImageView)findViewById(R.id.scroll_img);

//        Picasso.with(this)
//                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
//                .into(img);

//        Picasso.with(this)
//                .load("http://83.212.110.211/cityguide/uploads/Chorus%20Bar%2010/app1.jpg")
//                .into(img);


        pointOfInterest = new PointOfInterest();


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                pointOfInterest.setPoint_of_interest_id(0);
                pointOfInterest.setPoint_of_interest_name(null);
                pointOfInterest.setPoint_of_interest_description(null);
                pointOfInterest.setPoint_of_interest_address(null);

            } else {
                pointOfInterest.setPoint_of_interest_id(extras.getInt("id"));
                pointOfInterest.setPoint_of_interest_name(extras.getString("title"));
                pointOfInterest.setPoint_of_interest_description(extras.getString("description"));
                pointOfInterest.setPoint_of_interest_address(extras.getString("address"));
                img_header= extras.getString("img");
            }
        } else {
            pointOfInterest.setPoint_of_interest_id((int) savedInstanceState.getSerializable("id"));
            pointOfInterest.setPoint_of_interest_name((String) savedInstanceState.getSerializable("title"));
            pointOfInterest.setPoint_of_interest_description((String) savedInstanceState.getSerializable("description"));
            pointOfInterest.setPoint_of_interest_address((String) savedInstanceState.getSerializable("address"));
        }

                Picasso.with(this)
                .load(img_header)
                .into(img);


        description_txt = (TextView)findViewById(R.id.description);
        description_txt.setText(pointOfInterest.getPoint_of_interest_description());

        address_txt = (TextView)findViewById(R.id.address);
        address_txt.setText(pointOfInterest.getPoint_of_interest_address());

        toolbar.setTitle(pointOfInterest.getPoint_of_interest_name());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + pointOfInterest.convertAddress() + "&z=18&avoid=tf");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                else {
                    Log.d("Android: ", "There is no map app!");
                }


            }
        });


    }

}
