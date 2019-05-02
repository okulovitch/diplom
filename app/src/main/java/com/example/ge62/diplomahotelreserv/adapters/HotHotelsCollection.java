package com.example.ge62.diplomahotelreserv.adapters;

import com.example.ge62.diplomahotelreserv.models.HotDealHotels;

import java.util.ArrayList;

public class HotHotelsCollection {

    public static   ArrayList<HotDealHotels> getHottels(){
        ArrayList<HotDealHotels> hotel=new ArrayList<>();

        HotDealHotels h=new HotDealHotels();
        h.setHotelName("Marioadsasdadsasdasdasdt");
        h.setHotelDescription("asdadsads");
        h.setHotCost("234");
        h.setLocation("bukeng 23a");
        h.setHotelImage("http://www.ssaurel.com/tmp/logo_ssaurel.png");
            hotel.add(0,h);

        HotDealHotels h2=new HotDealHotels();
        h2.setHotelName("Mariot");
        h2.setHotelDescription("asdadsads");
        h2.setHotCost("234");
        h2.setLocation("bukeng 23a");
        h2.setHotelImage("http://www.ssaurel.com/tmp/logo_ssaurel.png");
        hotel.add(h2);

        HotDealHotels h3=new HotDealHotels();
        h3.setHotelName("Msdasdariot");
        h3.setHotelDescription("asdadsads");
        h3.setHotCost("234");
        h3.setLocation("bukeng 23a");
        h3.setHotelImage("http://www.ssaurel.com/tmp/logo_ssaurel.png");
        hotel.add(h3);

        HotDealHotels h4=new HotDealHotels();
        h4.setHotelName("Msdasdariot");
        h4.setHotelDescription("asdadsads");
        h4.setHotCost("234");
        h4.setLocation("bukeng 23a");
        h4.setHotelImage("http://www.ssaurel.com/tmp/logo_ssaurel.png");
        hotel.add(h4);

        HotDealHotels h5=new HotDealHotels();
        h5.setHotelName("Msdasdariot");
        h5.setHotelDescription("asdadsads");
        h5.setHotCost("234");
        h5.setLocation("bukeng 23a");
        h5.setHotelImage("http://www.asdasd.com ");
        hotel.add(h5);

       return hotel;

    }
}
