package com.finalyear;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.finalyear.models.CarParkModel;
import com.finalyear.service.CacheService;
import com.finalyear.service.ObjectMapperService;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {


    //private TextView welcome;
    EditText login, password;
    Button loginBtn;
    ImageView imageView1, imageView2,imageView3;

    //Creating a bundle to send to server for examine
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.loginText);
        password = (EditText) findViewById(R.id.passwordText);
        loginBtn = (Button) findViewById(R.id.loginButton);
        imageView1= (ImageView)findViewById(R.id.imageViewPerson);
        imageView2= (ImageView)findViewById(R.id.imageViewLogin);
        imageView3= (ImageView)findViewById(R.id.imageViewPassword);

        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    /**
                     * Connecting to server and sending request to acquire data of all car parks
                     */
                    OkHttpClient client = new OkHttpClient();
                    String url = "https://3e933257.ngrok.io/car-park-locations";
                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()) {
                               final String myResponse = response.body().string();

                                final List<CarParkModel> carParksInfo = ObjectMapperService.readValueAsList(myResponse,CarParkModel.class);
                                CacheService.put(CacheService.CARPARK_LIST, carParksInfo);

                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Creating new intent
                                        Intent welcomeIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                                            startActivity(welcomeIntent);
                                    }
                                });
                            }
                        }
                        });

            }
        });

    }
}
