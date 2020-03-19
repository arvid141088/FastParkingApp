package com.finalyear;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;


public class ViewAllLocationsActivity extends Activity implements OnClickListener{

    TextView receivedInfo;
    TextView info;
    Button homeButton;
    Button findButton;
    Bundle myBundle;
    MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        map = (MapView) findViewById(R.id.mapViewAll);
        info = (TextView) findViewById(R.id.textViewInfo);
        receivedInfo = (TextView) findViewById(R.id.textViewTop1);
        homeButton = (Button) findViewById(R.id.buttonHome);
        findButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        //String message = replyMessage.getText().toString();
        Intent myLocalIntent = getIntent();

        myBundle = myLocalIntent.getExtras();
       // myBundle.putString("msg2", message);
        myLocalIntent.putExtras(myBundle);
        setResult(Activity.RESULT_OK, myLocalIntent);
        finish();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if((requestCode == 101) && (resultCode == Activity.RESULT_OK)){
                Bundle myResultBundle = data.getExtras();
                String m = myResultBundle.getString("msg1");
                receivedInfo.setText(m);
            }
        }
        catch(Exception e){

            System.out.println("Something went wrong");
        }
    }


}
