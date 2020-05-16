package com.finalyear;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.finalyear.models.CarParkModel;
import com.finalyear.service.CacheService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ViewAllLocationsActivity extends AppCompatActivity {
    private ScrollView info;
    private MapView mapView;
    private TextView text1,text2,text3,text4,text5;
    private Button button1,button2,button3,button4,button5;
    GoogleMap map;
    double coordsLat = 0.0,coordsLon = 0.0;
    String locName;

    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        mapView = (MapView) findViewById(R.id.mapView);
        info = (ScrollView) findViewById(R.id.scrollView2);
        text1 = (TextView)findViewById(R.id.dataText1);
        text2= (TextView)findViewById(R.id.dataText2);

        final MapView mapView = (MapView) findViewById(R.id.mapView);
        final List<CarParkModel> carparkList = CacheService.getList(CacheService.CARPARK_LIST, CarParkModel.class);
        final StringBuilder info = new StringBuilder();

        for(CarParkModel carpark : carparkList) {
            info.append("ID: ").append(carpark.getId()).append("\n");
            info.append("Location: ").append(carpark.getName()).append("\n");
            info.append("City: ").append(carpark.getCity()).append("\n");
            info.append("GEO Location: ").append(carpark.getGpsLatitude()).append(",").append(carpark.getGpsLongitude()).append("\n");
            info.append("********\n");

        }

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap map) {

                /**
                 * Separating Latitude , Longitude and Location names into arrayLists
                 */
                List<Double> geoLat = new ArrayList<>();
                List<Double> geoLon = new ArrayList<>();
                List<String> locationNames = new ArrayList<>();
                for(CarParkModel model : carparkList){
                    coordsLat = Double.parseDouble(model.getGpsLatitude());
                    coordsLon= Double.parseDouble(model.getGpsLongitude());
                    locName=model.getName();
                    geoLat.add(coordsLat);
                    geoLon.add(coordsLon);
                    locationNames.add(locName);
                }
                for(int i=0;i<geoLat.size();i++) {
                    LatLng coordinates = new LatLng(geoLat.get(i), geoLon.get(i));
                    map.addMarker(new MarkerOptions().position(coordinates).title(locationNames.get(i)));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 12));
                }
                mapView.onResume();

            }
        });

        text1.setText(info);
    }//End onCreate

    //MapView lifecycle required
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

       mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }


    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
       mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
       mapView.onLowMemory();
    }

}
