package com.example.ge62.diplomahotelreserv.adapters;

import com.example.ge62.diplomahotelreserv.models.Hotel;

public interface RVClickListner<T> {
    void onItemClick(Hotel item, int target);

}
