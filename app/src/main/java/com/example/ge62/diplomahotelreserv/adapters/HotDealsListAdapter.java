package com.example.ge62.diplomahotelreserv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ge62.diplomahotelreserv.R;
import com.example.ge62.diplomahotelreserv.models.Hotel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class HotDealsListAdapter extends RecyclerView.Adapter<HotDealsListAdapter.MyHolder>{

    public final static int OPEN_FULL_INFO=1;
    // private Context mContext;
    private ArrayList<Hotel> hottels;
    private Context c;
    private RVClickListner<Hotel> rvClickListner;

    public HotDealsListAdapter(Context c, ArrayList<Hotel> hottels,RVClickListner<Hotel> rvClickListner){
        this.hottels=hottels;
        this.c=c;
        this.rvClickListner=rvClickListner;
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.hot_deals_item,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        final Hotel hotel=hottels.get(position);
        holder.hotelName.setText(hotel.getHottelName());
        holder.description.setText(hotel.getDescription());
        holder.location.setText(hotel.getRegionName());
        holder.cost.setText(hotel.getPhone());
        ImageLoader.getInstance().displayImage(hotel.getImage(), holder.hotelImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    rvClickListner.onItemClick(hotel,OPEN_FULL_INFO);

                }
                catch (NullPointerException e){
                    Toast.makeText(c, "Null p", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return hottels.size();
    }




    class MyHolder extends RecyclerView.ViewHolder {

        TextView hotelName,description,location,cost;
        ImageView hotelImage;
        RelativeLayout relativeLayout;


        public MyHolder(View itemView) {
            super(itemView);

            hotelName = (TextView) itemView.findViewById(R.id.hotelNameTv);
            description = (TextView) itemView.findViewById(R.id.descriptionTv);
            location = (TextView) itemView.findViewById(R.id.locationTv);
            cost = (TextView) itemView.findViewById(R.id.costTv);
            hotelImage = (ImageView) itemView.findViewById(R.id.hotelImage);
           // ratingBar = (SimpleRatingBar) itemView.findViewById(R.id.ratingBarID);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.hot_details_item);
        }

    }

}
