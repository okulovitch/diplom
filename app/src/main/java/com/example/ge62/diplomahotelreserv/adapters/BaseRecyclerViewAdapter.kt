package com.example.ge62.diplomahotelreserv.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseRecyclerViewAdapter<T , K>(val list : ArrayList<T> = arrayListOf()) : RecyclerView.Adapter<K>() where K : RecyclerView.ViewHolder {

    protected var inflater : LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): K {
        if (inflater == null){
            inflater = LayoutInflater.from(parent.context)
        }
        return prepareViewHolder(inflater!!.inflate(resourcesId(viewType) , parent , false), viewType)
    }

    abstract fun prepareViewHolder(view: View, viewType: Int): K

    abstract fun resourcesId(viewType: Int): Int

    override fun getItemCount() = list.size

    fun setData(list: List<T>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}