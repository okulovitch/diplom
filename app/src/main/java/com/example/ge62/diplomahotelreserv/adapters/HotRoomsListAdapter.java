package com.example.ge62.diplomahotelreserv.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ge62.diplomahotelreserv.R;
import com.example.ge62.diplomahotelreserv.models.Room;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class HotRoomsListAdapter extends RecyclerView.Adapter<HotRoomsListAdapter.MyHolder> implements Filterable {

    public final static int OPEN_FULL_INFO=1;
    // private Context mContext;
    private ArrayList<Room> rooms;
    private ArrayList<Room> roomsFiltered;
    private Context c;
    private RVRoomClickListner<Room> rvRoomClickListner;

    public HotRoomsListAdapter(Context c, ArrayList<Room> rooms, RVRoomClickListner<Room> rvRoomClickListner){
        this.rooms=rooms;
        this.c=c;
        this.rvRoomClickListner=rvRoomClickListner;
        this.roomsFiltered = rooms;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.hot_room_item,parent,false);
        return new HotRoomsListAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Room room=roomsFiltered.get(position);
        holder.roomLocation.setText(room.getRoomLocation());
        holder.costForNight.setText(room.getCostForNight().toString());
        holder.costWithSale.setText(room.getCostWithSale().toString());
        holder.personsCount.setText(room.getPersonsCount().toString());
        ImageLoader.getInstance().displayImage(room.getRoomImage(), holder.roomImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    rvRoomClickListner.onRoomClick(room,OPEN_FULL_INFO);

                }
                catch (NullPointerException e){
                    Toast.makeText(c, "Null p", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() { return roomsFiltered.size(); }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    roomsFiltered = rooms;
                } else {
                    ArrayList<Room> filteredList = new ArrayList<>();
                    for (Room row : rooms) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getRoomLocation().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    roomsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = roomsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                roomsFiltered = (ArrayList<Room>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView roomNumber,personsCount,costForNight,costWithSale,roomLocation,roomLongitude,roomLatitude;
        ImageView roomImage;
        RelativeLayout relativeLayout;


        public MyHolder(View itemView) {
            super(itemView);

            roomLocation = (TextView) itemView.findViewById(R.id.roomLocationTv);
            personsCount = (TextView) itemView.findViewById(R.id.personsCountTv);
            costForNight = (TextView) itemView.findViewById(R.id.defaultCostTv);
            costWithSale = (TextView) itemView.findViewById(R.id.costWithSaleTv);
            roomImage = (ImageView) itemView.findViewById(R.id.hotRoomImage);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.hot_room_item);
        }

    }



}