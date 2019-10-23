package com.github.easymvvm.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.github.easymvvm.R
import com.github.easymvvm.databinding.ItemHolidayKotlinBinding

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayAdapterKotlin() : RecyclerView.Adapter<HolidayAdapterKotlin.ViewHolder>() {

    var holidayList: List<HolidayModelKotlin>

    init {
        holidayList = ArrayList()
    }

    fun addData(arrList: List<HolidayModelKotlin>){
        this.holidayList = arrList
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int):  ViewHolder {
        val binding: ItemHolidayKotlinBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_holiday_kotlin, parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(val binding: ItemHolidayKotlinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.model, data)
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return holidayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(holidayList.get(pos))
    }//onBind


}