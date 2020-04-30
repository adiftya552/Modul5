package com.example.modul5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);

        mapFragment.getMapAsync(this);

        searchView = findViewById(R.id.sv_location);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if (location != null || !location.equals("")){
                    Geocoder geocoder = new Geocoder(MainActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    mapAPI.addMarker(new MarkerOptions().position(latLng).title(location));
                    mapAPI.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapAPI = googleMap;

        LatLng dinasJatim = new LatLng(-7.257274, 112.742827);
        mapAPI.addMarker(new MarkerOptions().position(dinasJatim).title("Dinas Pendidikan Provinsi Jawa Timur")
                .snippet("Jl. Gentengkali No.33, Genteng").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasJatim));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLngZoom(dinasJatim, 5));

        LatLng dinasJateng = new LatLng(-6.980119, 110.414583);
        mapAPI.addMarker(new MarkerOptions().position(dinasJateng).title("Dinas Pendidkan Provinsi Jawa Tengah")
                .snippet("Jl. Pemuda No.134, Sekayu").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasJateng));

        LatLng dinasJabar = new LatLng(-6.904431, 107.600000);
        mapAPI.addMarker(new MarkerOptions().position(dinasJabar).title("Dinas Pendidkan Provinsi Jawa Barat")
                .snippet("Jl. Dr. Rajiman No.6, Pasir Kaliki").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasJabar));

        LatLng dinasSumut = new LatLng(3.580335, 98.669561);
        mapAPI.addMarker(new MarkerOptions().position(dinasSumut).title("Dinas Pendidkan Provinsi Sumatera Utara")
                .snippet("Jl. Teuku Cik Ditiro No.1-D, Madras Hulu").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasSumut));

        LatLng dinasSusel = new LatLng(-2.979198, 104.748826);
        mapAPI.addMarker(new MarkerOptions().position(dinasSusel).title("Dinas Pendidkan Provinsi Sumatera Selatan")
                .snippet("Jl. Kapten A. Rivai No.47, Sungai Pangeran").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasSusel));

        LatLng dinasSumbar = new LatLng(-0.934861, 100.361809);
        mapAPI.addMarker(new MarkerOptions().position(dinasSumbar).title("Dinas Pendidkan Provinsi Sumatera Barat")
                .snippet("Jl. Jend. Sudirman No.52, Jati Baru").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasSumbar));

        LatLng dinasBali = new LatLng(-8.670910, 115.222590);
        mapAPI.addMarker(new MarkerOptions().position(dinasBali).title("Dinas Pendidkan Provinsi Bali")
                .snippet("Jl. Raya Puputan No.11, Dangin Puri Klod").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasBali));

        LatLng dinasKalbar = new LatLng(-0.044010, 109.322628);
        mapAPI.addMarker(new MarkerOptions().position(dinasKalbar).title("Dinas Pendidkan Provinsi Kalimantan Barat")
                .snippet("Jl. Sutan Syahrir No.7, Sungai Bangkong").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasKalbar));

        LatLng dinasKalteng = new LatLng(-2.207611, 113.918121);
        mapAPI.addMarker(new MarkerOptions().position(dinasKalteng).title("Dinas Pendidkan Provinsi Kalimantan Tengah")
                .snippet("Palangka, Kec. Jekan Raya, Kota Palangka Raya").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasKalteng));

        LatLng dinasKalsel = new LatLng(-3.488937, 114.825052);
        mapAPI.addMarker(new MarkerOptions().position(dinasKalsel).title("Dinas Pendidkan Provinsi Kalimantan Selatan")
                .snippet("Palam, Cempaka, Kota Banjar Baru, Kalimantan Selatan").icon(bitmapDescriptor(getApplicationContext(),
                        R.drawable.ic_dinas)));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dinasKalsel));

        MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this,R.raw.google_style);
        googleMap.setMapStyle(mapStyleOptions);
    }

    private BitmapDescriptor bitmapDescriptor(Context context, int vectorResid) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResid);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
