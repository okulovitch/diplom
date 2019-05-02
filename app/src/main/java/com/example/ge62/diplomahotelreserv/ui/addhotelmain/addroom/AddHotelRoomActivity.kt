package com.example.ge62.diplomahotelreserv.ui.addhotelmain.addroom

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.ui.addhotelmain.AddHottelActivity
import kotlinx.android.synthetic.main.activity_add_room.*
import kotlinx.android.synthetic.main.toolbar.*




class AddHotelRoomActivity:BaseActivity(),AddHotelRoomContract.View, View.OnClickListener {
    private var presenter: AddHotelRoomPresenter? = null
    override fun getLayoutRes()= com.example.ge62.diplomahotelreserv.R.layout.activity_add_room
    var isHot:Boolean?= null
    override fun initViews() {
        initToolbar(toolbar," ",true)
        btnAddNewHotelRoom.setOnClickListener(this)
        rbIsHot.setOnClickListener(this)
        rbNotHot.setOnClickListener(this)
        rgIsHot.setOnClickListener(this)
        btnAddNewHotelRoom.background.setColorFilter(Color.DKGRAY,PorterDuff.Mode.MULTIPLY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AddHotelRoomPresenter()
        presenter?.onAttachView(this)

        val radioGroup = findViewById<RadioGroup>(R.id.rgIsHot)
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->

            isHot = if (R.id.rbIsHot == checkedId) true else false

        if(isHot == null)
            btnAddNewHotelRoom.background.setColorFilter(Color.GRAY,PorterDuff.Mode.MULTIPLY)
            else
            btnAddNewHotelRoom.background.setColorFilter(null)
        }
    }
    override fun openAddHotelListScreen() {
        val intent = Intent(this, AddHottelActivity::class.java)
        startActivity(intent)
    }

    override fun onClick( view: View?) {
        when(view?.id){
            com.example.ge62.diplomahotelreserv.R.id.btnAddNewHotelRoom->{addNewHotelRoomReqest()}
        }
    }



    private fun addNewHotelRoomReqest() {
            presenter?.onAddRoomReqest(intent.getIntExtra("hotel",13),etPersonsCount.text.toString().toInt(), isHot!!,etRoomNumber.text.toString().toInt(),etCostForNight.text.toString().toDouble()
                    ,etCostWithSale.text.toString().toDouble()," "," ",etRoomImage.text.toString(),
                    intent.getStringExtra("location"),intent.getDoubleExtra("longitude", 53.0),intent.getDoubleExtra("latitude", 27.0))



    }

    override fun release() {

    }
}