package com.udacity.sanchitsharma.tourguidenano;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
/**
 * Created by sanchitsharma on 9/24/17.
 */
public class Pubs extends AppCompatActivity {
    private ArrayList<Place> places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        places = new ArrayList<Place>();
        Location pub1 = new Location(getResources().getString(R.string.pub1_name));
        pub1.setLatitude(53.346237);
        pub1.setLongitude(-6.259543);
        places.add(new Place(getResources().getString(R.string.pub1_name), getResources().getString(R.string.pub1_phone),
                getResources().getString(R.string.pub1_address), getResources().getString(R.string.pub1_image), pub1));
        Location pub2 = new Location(getResources().getString(R.string.pub2_name));
        pub2.setLatitude(53.3449326);
        pub2.setLongitude(-6.2763323);
        places.add(new Place(getResources().getString(R.string.pub2_name), getResources().getString(R.string.pub2_phone),
                getResources().getString(R.string.pub2_address), getResources().getString(R.string.pub2_image), pub2));
        Location pub3 = new Location(getResources().getString(R.string.pub3_name));
        pub3.setLatitude(53.3438235);
        pub3.setLongitude(-6.2636588);
        places.add(new Place(getResources().getString(R.string.pub3_name), getResources().getString(R.string.pub3_phone),
                getResources().getString(R.string.pub3_address), getResources().getString(R.string.pub3_image), pub3));
        Location pub4 = new Location(getResources().getString(R.string.pub4_name));
        pub4.setLatitude(53.3334783);
        pub4.setLongitude(-6.2648143);
        places.add(new Place(getResources().getString(R.string.pub4_name), getResources().getString(R.string.pub4_phone),
                getResources().getString(R.string.pub4_address), getResources().getString(R.string.pub4_image), pub4));
        ViewAdapter adapter = new ViewAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = places.get(position).getLocation().getLatitude();
                double lon = places.get(position).getLocation().getLongitude();
                String name = places.get(position).getName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(name));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
