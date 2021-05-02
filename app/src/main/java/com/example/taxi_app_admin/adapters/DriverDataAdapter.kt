package com.example.taxi_app_admin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.downloadAndSetImage

class DriverDataAdapter(private var mOrderList: MutableList<CommonModel>): RecyclerView.Adapter<DriverDataAdapter.DriverViewHolder>() {

    class DriverViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //Driver data
        val nameDriver: TextView? = itemView.findViewById(R.id.name_driver_item)
        val lastNameDriver: TextView? = itemView.findViewById(R.id.last_name_driver_item)
        val surnameDriver: TextView? = itemView.findViewById(R.id.surname_driver_item)
        val phoneNumberDriver: TextView? = itemView.findViewById(R.id.phone_number_driver_item)
        val carNumberDriver: TextView? = itemView.findViewById(R.id.car_number_driver_item)
        val carDriver: TextView? = itemView.findViewById(R.id.car_driver_item)
        //Photo driver
        val photoDriver: ImageView? = itemView.findViewById(R.id.driver_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_driver, parent, false)
        return DriverDataAdapter.DriverViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        holder.nameDriver?.text = mOrderList[position].name_driver
        holder.lastNameDriver?.text = mOrderList[position].last_name_driver
        holder.surnameDriver?.text = mOrderList[position].surname_driver
        holder.phoneNumberDriver?.text = mOrderList[position].phone_number_driver
        holder.carNumberDriver?.text = mOrderList[position].car_number
        holder.carDriver?.text = mOrderList[position].car
        holder.photoDriver?.downloadAndSetImage(mOrderList[position].photo_driver)
    }

    override fun getItemCount() = mOrderList.size

    fun setList(list: List<CommonModel>){
        mOrderList = list as MutableList<CommonModel>
        notifyDataSetChanged()
    }
}