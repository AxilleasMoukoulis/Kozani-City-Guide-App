package com.example.axilleas.cityguideapp;

/**
 * Created by axilleas on 19/01/16.
 */
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    //private static final String TAG = "CustomAdapter";

    //private String[] mDataSet;
    public static ArrayList<PointOfInterest> pointofinterest;



    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView poi_title;
        private final TextView poi_description;//textView;
        private final RoundedImageView img;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            poi_title = (TextView) v.findViewById(R.id.poi_title);
            poi_description = (TextView) v.findViewById(R.id.poi_description);

            img = (RoundedImageView)v.findViewById(R.id.row_img);

        }

        public TextView getPoi_title() {
            return poi_title;
        }
        public TextView getPoi_description() {
            return poi_description;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    public CustomAdapter(ArrayList<PointOfInterest> pointofinterest) {
        //mDataSet = dataSet;
        this.pointofinterest = pointofinterest;
    }

    private Button button, button2;
    Context context;


    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        context = v.getContext();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getPoi_title().setText(pointofinterest.get(position).getPoint_of_interest_name());//mDataSet[position]);
        viewHolder.getPoi_description().setText(pointofinterest.get(position).getPoint_of_interest_description());

        Picasso.with(context).load("http://83.212.110.211/cityguide/uploads/" + pointofinterest.get(position).convertName() + "/1.jpg").into(viewHolder.img);

        button = (Button) viewHolder.itemView.findViewById(R.id.load_more_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, ScrollingActivity.class);

                Log.d("Position Arraylist", " " + position);

                int id = pointofinterest.get(position).getPoint_of_interest_id();
                String desciprption = pointofinterest.get(position).getPoint_of_interest_description();
                String title = pointofinterest.get(position).getPoint_of_interest_name();
                String address = pointofinterest.get(position).getPoint_of_interest_address();
                String img = "http://83.212.110.211/cityguide/uploads/" + pointofinterest.get(position).convertName() + "/1.jpg";
                Double longtitude = pointofinterest.get(position).getPoint_of_interest_longtitude();
                Double latitude = pointofinterest.get(position).getPoint_of_interest_landtitude();

                intent.putExtra("id", id);
                intent.putExtra("description", desciprption);
                intent.putExtra("title", title);
                intent.putExtra("address", address);
                intent.putExtra("img", img);
                intent.putExtra("long", longtitude);
                intent.putExtra("lat", latitude);
                context.startActivity(intent);

            }

        });

        button2 = (Button) viewHolder.itemView.findViewById(R.id.map_view_btn);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + pointofinterest.get(position).convertAddress() + "&z=18&avoid=tf");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                    context.startActivity(mapIntent);

            }

        });


    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.pointofinterest.size();
    }
}

