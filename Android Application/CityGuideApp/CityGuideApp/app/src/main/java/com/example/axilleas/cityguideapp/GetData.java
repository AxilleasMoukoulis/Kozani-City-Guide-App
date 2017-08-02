package com.example.axilleas.cityguideapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by paris on 18/01/16.
 */
public class GetData extends AsyncTask<URL, Void, String> {

    private HttpURLConnection urlConnection;
    private StringBuilder result_string;
    private BufferedReader buffered_reader;

    @Override
    protected String doInBackground(URL... urls) {
        Log.d("ASYNCTASK URL: ", String.valueOf(urls[0]));

        //Make Connection to the Web Service
        try {
            urlConnection = (HttpURLConnection) urls[0].openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            Log.d("ANDROID:", "Make Connection to the Web Service");
        } catch (MalformedURLException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }

        try {
            buffered_reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String tmp_line;
            result_string = new StringBuilder();

            while ((tmp_line = buffered_reader.readLine()) != null) {
                result_string.append(tmp_line + "n");
            }
            buffered_reader.close();
            //Log.d("ANDROID:", "Buffer Data");

            urlConnection.disconnect();
            return new String(result_string);
        } catch (IOException e) {
            //e.printStackTrace();
        }
//        finally {
//            urlConnection.disconnect();
//            return new String(result_string);
//        }
        return null;
    }

}