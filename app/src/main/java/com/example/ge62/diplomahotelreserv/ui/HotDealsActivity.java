//package com.example.ge62.diplomahotelreserv.ui;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//
//import com.example.ge62.diplomahotelreserv.R;
//import com.example.ge62.diplomahotelreserv.adapters.HotDealsEditListAdapter;
//import com.example.ge62.diplomahotelreserv.adapters.HotHotelsCollection;
//import com.example.ge62.diplomahotelreserv.adapters.RVClickListner;
//import com.example.ge62.diplomahotelreserv.models.HotDealHotels;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HotDealsActivity extends AppCompatActivity {
//
//    private List<HotDealHotels> hotelsList = new ArrayList<>();
//    private RecyclerView recyclerView;
//    private HotDealsEditListAdapter hotDealsListAdapter;
//    HotDealHotels hottel;
//    private RVClickListner <HotDealHotels>rvClickListner = new RVClickListner<HotDealHotels>() {
//        @Override
//        public void onItemClick(HotDealHotels item, int target) {
//            Intent i=new Intent(HotDealsActivity.this,FullItemInfoHotDealsActivity.class);
//            i.putExtra("hottel",item);
//            startActivity(i);
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hot_deals);
//        recyclerView = (RecyclerView) findViewById(R.id.hotHotellsList);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //hotDealsListAdapter = new HotDealsEditListAdapter(this, HotHotelsCollection.getHottels());
//        recyclerView.setAdapter(new HotDealsEditListAdapter(this,HotHotelsCollection.getHottels(),rvClickListner));
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
////        recyclerView = (RecyclerView) findViewById(R.id.hotHotellsList);
////
////        hotDealsListAdapter = new HotDealsEditListAdapter(hotelsList);
////        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
////        recyclerView.setLayoutManager(mLayoutManager);
////        recyclerView.setItemAnimator(new DefaultItemAnimator());
////        recyclerView.setAdapter(hotDealsListAdapter);
////
////        prepareHotHotellData();
////    }
////
////    private void prepareHotHotellData() {
////        HotDealHotels hotel= new HotDealHotels(R.drawable.hotel1, "test", "wadsadasd");
////        hotelsList.add(hotel);
////
////
////        hotDealsListAdapter.notifyDataSetChanged();
////    }
//    }
//
//
//}