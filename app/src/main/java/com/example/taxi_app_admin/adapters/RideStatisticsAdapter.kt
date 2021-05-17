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

class RideStatisticsAdapter(private var mRideList: MutableList<CommonModel>): RecyclerView.Adapter<RideStatisticsAdapter.RideStatisticsViewHolder>(){

    class RideStatisticsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //Driver data
        val nameDriver: TextView? = itemView.findViewById(R.id.name_driver_ride_item)
        val lastNameDriver: TextView? = itemView.findViewById(R.id.last_name_driver_ride_item)
        val surnameDriver: TextView? = itemView.findViewById(R.id.surname_driver_ride_item)
        val phoneNumberDriver: TextView? = itemView.findViewById(R.id.phone_number_driver_ride_item)
        val photoDriver: ImageView? = itemView.findViewById(R.id.driver_image_order_create_account)
        //User data
        val nameUser: TextView? = itemView.findViewById(R.id.name_user_ride_item)
        val lastNameUser: TextView? = itemView.findViewById(R.id.last_name_user_ride_item)
        val surnameUser: TextView? = itemView.findViewById(R.id.surname_user_ride_item)
        val phoneNumberUser: TextView? = itemView.findViewById(R.id.phone_number_user_ride_item)
        //Ride data
        val coastRide: TextView? = itemView.findViewById(R.id.coast_ride_ride_item)
        val payMethod: TextView? = itemView.findViewById(R.id.pay_method_ride_ride_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideStatisticsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_statistics, parent, false)
        return RideStatisticsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RideStatisticsViewHolder, position: Int) {
        holder.nameDriver?.text = mRideList[position].name_driver
        holder.lastNameDriver?.text = mRideList[position].last_name_driver
        holder.surnameDriver?.text = mRideList[position].surname_driver
        holder.phoneNumberDriver?.text = mRideList[position].phone_number
        holder.photoDriver?.downloadAndSetImage(mRideList[position].photo_driver)
        holder.nameUser?.text = mRideList[position].name_user
        holder.lastNameUser?.text = mRideList[position].last_name_user
        holder.surnameUser?.text = mRideList[position].surname_user
        holder.phoneNumberUser?.text = mRideList[position].phone_number_user
        holder.coastRide?.text = mRideList[position].coast_ride
        holder.payMethod?.text = mRideList[position].pay_method
    }

    override fun getItemCount() = mRideList.size

    fun setList(list: List<CommonModel>){
        mRideList = list as MutableList<CommonModel>
        notifyDataSetChanged()
    }
}