package com.yuzumin.yagoonoises;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Splash extends AppCompatActivity {

    boolean isLaunched;
    ConstraintLayout Layout;
    SharedPreferences sharedPref;
    SharedPreferences.Editor activation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Layout=findViewById(R.id.layout);
        isLaunched=false;

        sharedPref =getSharedPreferences("serverActivation", MODE_PRIVATE);
        if (!sharedPref.getBoolean("isActivated", false)) {
            String url = "https://yuzumin.github.io/Hololive-CEO-Yagoo-Noises/V1.json";
            JSONArray arr = new JSONArray(url);
            JSONObject jObj = arr.getJSONObject(0);
            String date = jObj.getString("NeededString");
        }


        Layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(!isLaunched){
                    isLaunched=true;
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                }
                return false;
            }
        });


        Thread timer= new Thread()
        {
            public void run()
            {
                try
                {
                    //Display for 3 seconds
                    sleep(1500);
                }
                catch (InterruptedException e)
                {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally
                {
                    if(!isLaunched){
                        isLaunched=true;
                        startActivity(new Intent(Splash.this, MainActivity.class));
                        finish();
                    }
                }
            }
        };
        timer.start();
    }
}

