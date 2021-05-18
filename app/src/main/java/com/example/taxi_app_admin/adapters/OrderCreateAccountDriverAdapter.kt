package com.example.taxi_app_admin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.database.*
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.*


class OrderCreateAccountDriverAdapter(private var mOrderList: MutableList<CommonModel>): RecyclerView.Adapter<OrderCreateAccountDriverAdapter.OrderViewHolder>(){

    class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //Driver data
        val nameDriver: TextView? = itemView.findViewById(R.id.name_driver_order_item)
        val lastNameDriver: TextView? = itemView.findViewById(R.id.last_name_driver_order_item)
        val surnameDriver: TextView? = itemView.findViewById(R.id.surname_driver_order_item)
        val phoneNumberDriver: TextView? = itemView.findViewById(R.id.phone_number_driver_order_item)
        val carNumberDriver: TextView? = itemView.findViewById(R.id.car_number_driver_order_item)
        val carDriver: TextView? = itemView.findViewById(R.id.car_driver_order_item)
        //Driver images
        val photoDriver: ImageView? = itemView.findViewById(R.id.driver_image_order_create_account)
        val photoDriverLicense: ImageView? = itemView.findViewById(R.id.car_driver_order_license)
        val photoDriverCar: ImageView? = itemView.findViewById(R.id.car_driver_order_car)
        //Buttons
        val addDriver: Button? = itemView.findViewById(R.id.add_driver)
        val deleteDriver: Button? = itemView.findViewById(R.id.delete_driver_order)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.nameDriver?.text = mOrderList[position].name_driver
        holder.lastNameDriver?.text = mOrderList[position].last_name_driver
        holder.surnameDriver?.text = mOrderList[position].surname_driver
        holder.phoneNumberDriver?.text = mOrderList[position].phone_number_driver
        holder.carNumberDriver?.text = mOrderList[position].car_number
        holder.carDriver?.text = mOrderList[position].car
        holder.photoDriverLicense?.downloadAndSetImage(mOrderList[position].photo_licence)
        holder.photoDriver?.downloadAndSetImage(mOrderList[position].photo_driver)
        holder.photoDriverCar?.downloadAndSetImage(mOrderList[position].photo_car)
        //Create driver
        holder.addDriver?.setOnClickListener {
            val dateMap = mutableMapOf<String, Any>()
            dateMap[NAME_DRIVER] = mOrderList[position].name_driver
            dateMap[UID_DRIVER] = mOrderList[position].uid
            dateMap[LAST_NAME_DRIVER] = mOrderList[position].last_name_driver
            dateMap[SURNAME_DRIVER] = mOrderList[position].surname_driver
            dateMap[PHOTO_DRIVER] = mOrderList[position].photo_driver
            dateMap[PHOTO_LICENSE] = mOrderList[position].photo_licence
            dateMap[CAR] = mOrderList[position].car
            dateMap[CHILD_BLOC] = UNBLOCK
            dateMap[CAR_NUMBER] = mOrderList[position].car_number
            dateMap[PHONE_NUMBER_DRIVER] = mOrderList[position].phone_number_driver
            REF_DATABASE_ROOT.child(NODE_DRIVERS).child(mOrderList[position].uid).updateChildren(dateMap)
            showToast(APP_ACTIVITY.getString(R.string.driver_created_toast))
            REF_DATABASE_ROOT.child(NODE_ORDER_DRIVERS).child(mOrderList[position].uid).removeValue()
        }

        //Delete order
        holder.deleteDriver?.setOnClickListener {
            REF_DATABASE_ROOT.child(NODE_ORDER_DRIVERS).child(mOrderList[position].uid).removeValue()
            showToast(APP_ACTIVITY.getString(R.string.driver_order_deleted))
        }
    }

    override fun getItemCount() = mOrderList.size

    fun setList(list: List<CommonModel>){
        mOrderList = list as MutableList<CommonModel>
        notifyDataSetChanged()
    }
}