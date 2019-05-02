package com.example.ge62.diplomahotelreserv.models;

import android.os.Parcel;
import android.os.Parcelable;

public class HotDealHotels implements Parcelable{
    private String  hotelImage;

    private String hotelName;

    private String hotelDescription;

    private String location;

    private String hotCost;


    public HotDealHotels() {
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.location = location;
        this.hotCost = hotCost;
    }

    protected HotDealHotels(Parcel in) {
        hotelImage = in.readString();
        hotelName = in.readString();
        hotelDescription = in.readString();
        location = in.readString();
        hotCost = in.readString();
    }

    public static final Creator<HotDealHotels> CREATOR = new Creator<HotDealHotels>() {
        @Override
        public HotDealHotels createFromParcel(Parcel in) {
            return new HotDealHotels(in);
        }

        @Override
        public HotDealHotels[] newArray(int size) {
            return new HotDealHotels[size];
        }
    };

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHotCost() {
        return hotCost;
    }

    public void setHotCost(String hotCost) {
        this.hotCost = hotCost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hotelName);
        parcel.writeString(this.hotelDescription);
        parcel.writeString(this.hotCost);
        parcel.writeString(this.location);
        parcel.writeString(this.hotelImage);

    }
}