package com.example.ge62.diplomahotelreserv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.ge62.diplomahotelreserv.ui.EnteredActivity;

public class allDeals extends AppCompatActivity {

    private ImageView onMainIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_deals);

        onMainIv =(ImageView)findViewById(R.id.backIv);


        onMainIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(allDeals.this, EnteredActivity.class);
                startActivity(intent);
            }
        });

    }

}
