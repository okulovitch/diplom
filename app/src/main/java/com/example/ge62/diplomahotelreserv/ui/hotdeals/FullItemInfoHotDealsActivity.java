package com.example.ge62.diplomahotelreserv.ui.hotdeals;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ge62.diplomahotelreserv.R;
import com.example.ge62.diplomahotelreserv.models.Hotel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideParameters;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.android.rides.RideRequestButtonCallback;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.error.ApiError;

import java.util.Calendar;

public class FullItemInfoHotDealsActivity extends AppCompatActivity implements OnMapReadyCallback {


    private MapView mapView;
    private GoogleMap gmap;
    private RideRequestButton requestButton;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";


    private DatePickerDialog.OnDateSetListener mDateCheckInSetListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            month = month + 1;
            String calendarDate = year + "/" + month + "/" + date;
            checkIn.setText(calendarDate);


        }
    };
    private DatePickerDialog.OnDateSetListener mDateCheckOutSetListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {

            month = month + 1;
            String calendarDate = year + "/" + month + "/" + date;
            checkOut.setText(calendarDate);


        }
    };
    private TextView checkIn, checkOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_item_info);
        checkIn = (TextView) findViewById(R.id.dateOfCheckIn);
        checkOut = (TextView) findViewById(R.id.dateOfCheckOut);
     //   requestButton = (RideRequestButton) findViewById(R.id.uberBtn);
        SessionConfiguration config = new SessionConfiguration.Builder()
                // mandatory
                .setClientId("zaphNZ4rgeUzjX9tJpfoHrx_Bt872_5p")
                // required for enhanced button features
                .setServerToken("wiaLWZue2JXOUjpSIHlkOex3AZ5APT9PVmJpHiW5")
                // required for implicit grant authentication
                //   .setRedirectUri("")
                //.setScopes(Arrays.asList(Scope.RIDE_WIDGETS))
                // optional: set sandbox as operating environment
                .setEnvironment(SessionConfiguration.Environment.PRODUCTION)
                .build();
        UberSdk.initialize(config);
RideRequestButton requestButton = new RideRequestButton(FullItemInfoHotDealsActivity.this);
      //  LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mapContainer);
        linearLayout.addView(requestButton);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//			.build();
//        ImageLoader.getInstance().init(config);
        Hotel hotel = getIntent().getExtras().getParcelable("image");

        String name = getIntent().getStringExtra("hotelName");
        String location = getIntent().getStringExtra("regionName");
        String description = getIntent().getStringExtra("description");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        //   double latitude=  getIntent().getDoubleExtra("latitude");
//      double longitude=  getIntent().getDoubleExtra("longitude");
        String image = getIntent().getStringExtra("image");
        //String url = "http://www.ssaurel.com/tmp/logo_ssaurel.png";

        //initialize image view
        ImageView imageView = (ImageView) findViewById(R.id.hotelImage);
        TextView nameTv = (TextView) findViewById(R.id.hotelNameTv);
        TextView descriptionTv = (TextView) findViewById(R.id.descriptionTv);
        TextView locationTv = (TextView) findViewById(R.id.locationTv);
        TextView phoneTv = (TextView) findViewById(R.id.phoneEnterTextTv);
        TextView emailTv = (TextView) findViewById(R.id.emailEnterTextTv);

        //download and display image from url
        ImageLoader.getInstance().displayImage(image, imageView);
        nameTv.setText(name);
        descriptionTv.setText(description);
        locationTv.setText(location);
        phoneTv.setText(phone);
        emailTv.setText(email);


        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }


        mapView = findViewById(R.id.map_view);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();
        double lon = bundle.getDouble("long");
        double lat = bundle.getDouble("lat");

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        assert lm != null;
        Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double myLongitude = myLocation.getLongitude();
        double myLatitude = myLocation.getLatitude();

        RideParameters rideParams = new RideParameters.Builder()
                // Optional product_id from /v1/products endpoint (e.g. UberX). If not provided, most cost-efficient product will be used
                .setProductId("a1111c8c-c720-46c3-8534-2fcdd730040d")
                // Required for price estimates; lat (Double), lng (Double), nickname (String), formatted address (String) of dropoff location
                .setDropoffLocation(
                        myLatitude, myLongitude, "my Location", location)
                // Required for pickup estimates; lat (Double), lng (Double), nickname (String), formatted address (String) of pickup location
                .setPickupLocation(lat, lon, "Uber HQ", "myPosition")
                .build();
// set parameters for the RideRequestButton instance
        requestButton.setRideParameters(rideParams);

        ServerTokenSession session = new ServerTokenSession(config);
        requestButton.setSession(session);
        requestButton.loadRideInformation();
     //   costTv.setText(cost);

        RideRequestButtonCallback callback = new RideRequestButtonCallback() {

            @Override
            public void onRideInformationLoaded() {
            }

            @Override
            public void onError(ApiError apiError) {
                // API error details: /docs/riders/references/api#section-errors
            }

            @Override
            public void onError(Throwable throwable) {
                // Unexpected error, very likely an IOException
            }
        };
        requestButton.setCallback(callback);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    public void datePickCheckIn(View view) {

        Calendar cal= Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date=cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog=new DatePickerDialog(
                FullItemInfoHotDealsActivity.this,
                R.style.SpinnerDateTheme,
                mDateCheckInSetListner,year,month,date);
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }

    public void datePickCheckOut(View view) {

        Calendar cal= Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date=cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog=new DatePickerDialog(
                FullItemInfoHotDealsActivity.this,
                R.style.SpinnerDateTheme,
                mDateCheckOutSetListner,year,month,date);
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Bundle bundle = getIntent().getExtras();
        double lon= bundle.getDouble("long");
        double lat = bundle.getDouble("lat");
        String location= getIntent().getStringExtra("regionName");
     //   Double latitude= (Double) getIntent().getDoubleExtra("latitude");
     //   Double longitude= (Double) getIntent().getDoubleExtra("longitude");
        gmap = googleMap;


        gmap.setMinZoomPreference(8);
        LatLng ny = new LatLng(lon, lat);
        if (gmap != null) {
                     gmap.addMarker(new MarkerOptions()
                    .position(ny).title(location)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .draggable(false).visible(true));
        }
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}