package com.github.easymvvm.kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.easymvvm.R
import kotlinx.android.synthetic.main.item_holiday.view.*

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayAdapterKotlin() : RecyclerView.Adapter<HolidayAdapterKotlin.ViewHolder>() {

    val TAG = javaClass.simpleName
    var arrList: List<HolidayModelKotlin>

    init {
        arrList = ArrayList()
    }

    fun addData(arrList: List<HolidayModelKotlin>){
        this.arrList = arrList
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int):  ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_holiday, parent, false))
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvDate = view.tv_date
        var tvName = view.tv_name
    }

    override fun getItemCount(): Int {
        return if (arrList != null) arrList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

        Log.e(TAG, "onBindViewHolder-"+arrList.get(pos).toString() )

        holder.tvDate.text = arrList.get(pos).date
        holder.tvName.text = arrList.get(pos).name

    }//onBind


}