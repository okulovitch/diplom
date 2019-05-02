package com.example.ge62.diplomahotelreserv.ui;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.ge62.diplomahotelreserv.R;
import com.example.ge62.diplomahotelreserv.ui.hotdeals.HotDealsActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class EnteredActivity extends AppCompatActivity implements View.OnClickListener{
    ProgressDialog pd;
    Handler h;
    private CardView mapCv,hotDealsCv,advancedSearchCv,favoriteCv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entered);



     //   favoriteCv=(CardView)findViewById(R.id.favorite);
        mapCv=(CardView)findViewById(R.id.map);
        hotDealsCv=(CardView)findViewById(R.id.hot);
        advancedSearchCv=(CardView)findViewById(R.id.advancedSearch);



        hotDealsCv.setOnClickListener((View.OnClickListener) this);
        advancedSearchCv.setOnClickListener((View.OnClickListener) this);
//        favoriteCv.setOnClickListener(this);
        mapCv.setOnClickListener((View.OnClickListener)this);

    }
    public void Progress(){
        pd=new ProgressDialog(this);
        pd.setMessage("operation processing");
        pd.show();

    }



    @Override
    public void onClick(View v) {
        Progress();
        Intent i;
        switch (v.getId()){
             case R.id.map:
                 Dexter.withActivity(this)
                         .withPermissions(
                                 Manifest.permission.ACCESS_FINE_LOCATION,
                                 Manifest.permission.ACCESS_COARSE_LOCATION,
                                 Manifest.permission.INTERNET
                         ).withListener(new MultiplePermissionsListener() {
                     @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */
                            if(report.getDeniedPermissionResponses().isEmpty()) {
                                Intent i;
                                i = new Intent(EnteredActivity.this, MapsActivity.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(EnteredActivity.this, "map is unavailable for using", Toast.LENGTH_SHORT).show();
                            }
                            }
                     @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
                 }).check();
             //    i=new Intent(EnteredActivity.this,MapsActivity.class);startActivity(i);
                 break;
             case R.id.hot:
                 i=new Intent(this, HotDealsActivity.class);startActivity(i);break;
            case R.id.advancedSearch:
                i=new Intent(this,AdvancedSearch.class);startActivity(i);break;
//            case R.id.favorite:
//                i=new Intent(this,allDeals.class);startActivity(i);break;
//            default:break;
        }

    }



}
