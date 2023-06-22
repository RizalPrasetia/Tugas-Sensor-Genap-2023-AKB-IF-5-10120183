package com.rizalprasetiasupriadi.tugassensor2023akbif_510120183;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.rizalprasetiasupriadi.tugassensor2023akbif_510120183.databinding.ActivityRestoranBinding;

//NIM     :   10120183
//NAMA    :   RIZAL PRASETIA SUPRIADI
//KELAS   :   IF-5


public class RestoranActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityRestoranBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final int Request_code = 101;
    private double lat, lng;
    Button resto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRestoranBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resto = findViewById(R.id.cariResto);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.getApplicationContext());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=1000");
                stringBuilder.append("&type=Restaurant");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&key="+getResources().getString(R.string.api_key));

                String url = stringBuilder.toString();
                Object dataFetch[] = new Object[2];
                dataFetch[0]=mMap;
                dataFetch[1]=url;

                FetchData fetchData = new FetchData();
                fetchData.execute(dataFetch);
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_code);
            return;
        }
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(60000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setFastestInterval(5000);
        LocationCallback locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                Toast.makeText(getApplicationContext(), "Lokasi = "+locationResult,Toast.LENGTH_LONG).show();
                if(locationResult == null){
                    Toast.makeText(getApplicationContext(), "Lokasi tidak ditemukan ",Toast.LENGTH_LONG).show();
                    return;
                }
                for (Location location : locationResult.getLocations()){
                    if (location!=null){
                        Toast.makeText(getApplicationContext(), "Lokasi saat ini "+location.getLatitude(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        };

        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback,null);
        Task<Location> task=fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null){
                    lat = location.getLatitude();
                    lng = location.getLongitude();

                    LatLng latLng = new LatLng(lat,lng);
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Lokasi saat ini"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                }

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (Request_code) {
            case Request_code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getCurrentLocation();
                }
        }

    }
}