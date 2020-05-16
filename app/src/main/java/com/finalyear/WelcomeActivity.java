package com.finalyear;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.finalyear.models.CarParkModel;
import com.finalyear.service.CacheService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    TextView appName;
    ImageView image;
    TextView appInfo;
    Button findNearest;
    Button showAll;
    public int distanceId;
    LocationManager locationManager;
    LocationListener locationListener;
    int locatId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        appName = (TextView) findViewById(R.id.textAppnameView);
        image = (ImageView) findViewById(R.id.imageView);
        appInfo = (TextView) findViewById(R.id.textAppInformation);
        findNearest = (Button) findViewById(R.id.buttonNearest);
        showAll = (Button) findViewById(R.id.buttonAllLocation);


        showAll.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent allActivity = new Intent(WelcomeActivity.this, ViewAllLocationsActivity.class);
                    startActivity(allActivity);
                }
                catch(Exception e){
                    System.out.println("Could not get results from server");
                }
            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                List<CarParkModel> carparkList = CacheService.getList(CacheService.CARPARK_LIST, CarParkModel.class);

                /**
                 * Acquiring minDistance values
                 */
                List<Float> distances = new ArrayList<>();
                for(CarParkModel cpModel : carparkList){
                    double lat=Double.parseDouble(cpModel.getGpsLatitude());
                    double lon= Double.parseDouble(cpModel.getGpsLongitude());
                    Location loc = new Location("dest");
                    loc.setLatitude(lat);
                    loc.setLongitude(lon);
                    float distance = location.distanceTo(loc);

                    distances.add(distance);
                }

                /**
                 *  Getting index of location with minDistance
                 */
                float minDist = Collections.min(distances);
                for(int i=0;i<distances.size();i++){
                    if (distances.get(i)== minDist)
                        distanceId = i;
                }
                System.out.println("Shortest distance : "+ Collections.min(distances)+" meters"+"" +
                        "Distance ID: "+distanceId);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        //Checking for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,
                   Manifest.permission.INTERNET
            },10);
            return;
        }
        else{
            acquireLocation();
        }
    }// OnCreate

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    try{
                        acquireLocation();
                    }
                    catch (SecurityException se){
                        throw new SecurityException("Permission was not granted");
                    }
                }
                    break;
            default:
                break;
        }
   } //End onRequestPermissionsResult

    /**
     * GPS location detection (current location)
     */
    private void acquireLocation(){
        findNearest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    locatId=distanceId+1;
                        viewMap();
                        locationManager.requestLocationUpdates("gps", 3000, 0, locationListener);
                }
                catch (SecurityException se){
                    throw new SecurityException("Security exception, check permissions");
                }
            }
        });
    }

    /**
     * Acquire all GEO locations and compare with current. Set calculated geo location into uriGeoCode
     */
    private void viewMap() {
        //Dropping pin on google map for nearest slot available
        List<CarParkModel> carparkList = CacheService.getList(CacheService.CARPARK_LIST, CarParkModel.class);
        CarParkModel carParkModel = carparkList.get(distanceId);
        String uriGeoCode = "geo:0,0?q="+carParkModel.getGpsLatitude()+","+ carParkModel.getGpsLongitude()+"&z=16";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriGeoCode));
        startActivity(intent);

    }//End viewMap
}//End activity










