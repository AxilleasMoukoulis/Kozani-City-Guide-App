package com.example.axilleas.cityguideapp.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.axilleas.cityguideapp.CustomAdapter;
import com.example.axilleas.cityguideapp.GetData;
import com.example.axilleas.cityguideapp.JSONParse;
import com.example.axilleas.cityguideapp.PointOfInterest;
import com.example.axilleas.cityguideapp.R;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class ChurchFragment extends android.app.Fragment{

    protected LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ArrayList<PointOfInterest> poi_church;//pointofinterest;
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.historic_layout, container, false);
        initComponents(savedInstanceState);

        return rootView;
    }

    private void initComponents(Bundle savedInstanceState) {
        this.mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        this.mLayoutManager = new LinearLayoutManager(getActivity());
        this.mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            this.mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(this.mCurrentLayoutManagerType);

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
    }

    private void initDataset() throws MalformedURLException, JSONException, ExecutionException, InterruptedException {

        if (this.poi_church==null) {
            //DOWNLOAD DATA FROM WEB
            URL url = new URL("http://83.212.110.211:8080/city_guide_webservice/getPointOfInterest?subcategory=2");
            String pointofinterest_string = new GetData().execute(url).get();
            //Log.d("MAIN-POI: ", String.valueOf(pointofinterest_string));

            //PARSE DATA FROM JSON TO OBJECTS
            if (pointofinterest_string != null) {
                JSONParse jsonparse = new JSONParse();
                this.poi_church = jsonparse.parsePointofinterest(pointofinterest_string);
                //for (PointOfInterest i : this.poi_historic) i.printPoint_of_interest();

                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                StringBuilder builder = new StringBuilder();
                builder.append("\n Send report:" + sharedPrefs.getBoolean("prefSendReport", false));
                //Log.d("CHECKBOX: ", "CHECKBOX " + sharedPrefs.getBoolean("prefSendReport", false));

                if (sharedPrefs.getBoolean("prefSendReport", false)) {
                    this.poi_church = jsonparse.eucledianDistance(this.poi_church, this.getActivity());
                }/* else {
                    Toast.makeText(getActivity(), "CHECKBOX " + sharedPrefs.getBoolean("prefSendReport", false), Toast.LENGTH_SHORT).show();
                }*/

                fillAdapter();
            }
        }
    }

    private void fillAdapter()
    {
        //edw gemizei o adapter
        this.mAdapter = new CustomAdapter(this.poi_church);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (this.mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        this.mLayoutManager = new LinearLayoutManager(getActivity());
        this.mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        this.mRecyclerView.setLayoutManager(mLayoutManager);
        this.mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

}