package com.finalyear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {

    private TextView welcome;
    EditText login, password;
    Button loginBtn;

    //Creating a bundle to send to server for examine
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        welcome = (TextView) findViewById(R.id.welcomeText);
        login = (EditText) findViewById(R.id.loginText);
        password = (EditText) findViewById(R.id.passwordText);
        loginBtn = (Button) findViewById(R.id.loginButton);




        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//Need to open new Intent and operate from there
                    //Creating new intent
                    Intent welcomeIntent = new Intent(MainActivity.this,WelcomeActivity.class);
                    startActivity(welcomeIntent);
                    /**
                     * Sending request to the server
                     * first part of URL changing
                     */
                    OkHttpClient client = new OkHttpClient();
                    String url = "https://c9747b56.ngrok.io/car-park-locations/4";
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

                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        welcome.setText(myResponse);
                                    }
                                });
                            }
                        }
                        });
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}


//        loginBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                //Test if login successful
//                //Creating intent to talk to ViewAll activity
//                Intent myIntentA1A2 = new Intent(MainActivity.this, ViewAllActivity.class);
//                //Reading text from user interface
//                String userLogin = login.getText().toString();
//                //String userPassword = password.getText().toString();
//                //Preparing bundle to be sent
//                Bundle userInfoBundle = new Bundle();
//                userInfoBundle.putString("log", userLogin);
//                //userInfoBundle.putString("pwd",userPassword);
//
//                myIntentA1A2.putExtras(userInfoBundle);
//                setResult(Activity.RESULT_OK, myIntentA1A2);
//
//                startActivityForResult(myIntentA1A2,101);
//
//            }catch (Exception e) {
//                Toast.makeText(getBaseContext(), e.getMessage(),
//                        Toast.LENGTH_LONG).show();
//            }
//            }
//       });//OnClickListener
//    }// OnCreate
//}