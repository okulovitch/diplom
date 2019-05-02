package com.example.ge62.diplomahotelreserv.ui;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.ge62.diplomahotelreserv.R;

import java.util.Calendar;

public class AdvancedSearch extends AppCompatActivity {


    private DatePickerDialog.OnDateSetListener mDateCheckInSetListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                    month=month+1;
                   String calendarDate = year + "/" + month + "/" + date;
                   checkIn.setText(calendarDate);


        }
    };
    private DatePickerDialog.OnDateSetListener mDateCheckOutSetListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {

            month=month+1;
            String calendarDate = year + "/" + month + "/" + date;
            checkOut.setText(calendarDate);


        }
    };
   private TextView checkIn,checkOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search_coord);
        checkIn=(TextView)findViewById(R.id.dateOfCheckIn);
        checkOut=(TextView)findViewById(R.id.dateOfCheckOut);

        // Intent intent;
       // intent.getStringExtra("checkInDate");
    }

    public void datePickCheckIn(View view) {

        Calendar cal= Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date=cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog=new DatePickerDialog(
                AdvancedSearch.this,
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
                AdvancedSearch.this,
                R.style.SpinnerDateTheme,
                mDateCheckOutSetListner,year,month,date);
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

}
