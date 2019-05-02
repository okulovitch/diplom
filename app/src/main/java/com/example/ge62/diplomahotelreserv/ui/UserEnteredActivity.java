package com.example.ge62.diplomahotelreserv.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ge62.diplomahotelreserv.R;
import com.example.ge62.diplomahotelreserv.ui.addhotelmain.AddHottelActivity;
import com.example.ge62.diplomahotelreserv.ui.hotdeals.HotDealsActivity;
import com.example.ge62.diplomahotelreserv.ui.hotrooms.HotRoomsActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class UserEnteredActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout hotBtn, globalBtn, showMapBtn, hotRoomsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entered_user);


        //   favoriteCv=(CardView)findViewById(R.id.favorite);
        hotBtn = (LinearLayout) findViewById(R.id.hotBtn);
        globalBtn = (LinearLayout) findViewById(R.id.globalBtn);
        showMapBtn = (LinearLayout) findViewById(R.id.showMapBtn);
        hotRoomsBtn = (LinearLayout)findViewById(R.id.hotRoomsBtn);

        hotBtn.setOnClickListener((View.OnClickListener) this);
        globalBtn.setOnClickListener((View.OnClickListener) this);
        hotRoomsBtn.setOnClickListener((View.OnClickListener)this);
//        favoriteCv.setOnClickListener(this);
        showMapBtn.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.hotBtn:
                i=new Intent(this, HotDealsActivity.class);startActivity(i);break;
            case R.id.hotRoomsBtn:
                i = new Intent(this, HotRoomsActivity.class);startActivity(i);break;
                case R.id.globalBtn:
                i=new Intent(this, AddHottelActivity.class);startActivity(i);break;
            case R.id.showMapBtn:
                Dexter.withActivity(this)
                        .withPermissions(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.INTERNET
                        ).withListener(new MultiplePermissionsListener() {
                    @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */
                        if(report.getDeniedPermissionResponses().isEmpty()) {
                            Intent i;
                            i = new Intent(UserEnteredActivity.this, MapsActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(UserEnteredActivity.this, "map is unavailable for using", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
                }).check();

        }
    }
}