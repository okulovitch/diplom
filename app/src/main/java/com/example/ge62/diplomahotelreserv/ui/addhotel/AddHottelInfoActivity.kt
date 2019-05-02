package com.example.ge62.diplomahotelreserv.ui.addhotel

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.ui.addhotelmain.AddHottelActivity
import kotlinx.android.synthetic.main.activity_add_hottel_info.*
import kotlinx.android.synthetic.main.activity_hot_deals.*

class AddHottelInfoActivity:BaseActivity(),AddHotelInfoContract.View, View.OnClickListener {

    override fun getLayoutRes()= R.layout.activity_add_hottel_info
    private var presenter: AddHotelInfoContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AddHotelInfoPresenter()
        presenter?.onAttachView(this)
    }


    override fun openAddHotelListScreen() {
        val intent = Intent(this, AddHottelActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(view: View?) {
       when(view?.id){
           R.id.addNewHottel->{addNewHottelReqest()}
       }
    }

    private fun addNewHottelReqest() {
        presenter?.onAddHotelReqest(etHottelPhone.text.toString(),etHottelEmail.text.toString(), etHottelDescription.text.toString(),etHottelName.text.toString(),etLongitude.text.toString(),etlatitude.text.toString(),etLocation.text.toString(),etHotelImage.text.toString())
    }


    override fun initViews() {
        initToolbar(toolbar,"on edit hotel screen",true)
        addNewHottel.setOnClickListener(this)
    }

    override fun release() {

    }
}