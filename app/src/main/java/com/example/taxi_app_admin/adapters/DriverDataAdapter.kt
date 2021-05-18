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

class DriverDataAdapter(private var mDriverList: MutableList<CommonModel>): RecyclerView.Adapter<DriverDataAdapter.DriverViewHolder>() {

    class DriverViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //Driver data
        val nameDriver: TextView? = itemView.findViewById(R.id.name_driver_item)
        val lastNameDriver: TextView? = itemView.findViewById(R.id.last_name_driver_item)
        val surnameDriver: TextView? = itemView.findViewById(R.id.surname_driver_item)
        val phoneNumberDriver: TextView? = itemView.findViewById(R.id.phone_number_driver_item)
        val carNumberDriver: TextView? = itemView.findViewById(R.id.car_number_driver_item)
        val carDriver: TextView? = itemView.findViewById(R.id.car_driver_item)
        val blocDriver: Button? = itemView.findViewById(R.id.bloc_driver)
        val statusDriver: TextView? = itemView.findViewById(R.id.block_driver_item)
        val deleteDriver: Button? = itemView.findViewById(R.id.delete_driver)
        //Photo driver
        val photoDriver: ImageView? = itemView.findViewById(R.id.driver_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_driver, parent, false)
        return DriverDataAdapter.DriverViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        holder.nameDriver?.text = mDriverList[position].name_driver
        holder.lastNameDriver?.text = mDriverList[position].last_name_driver
        holder.surnameDriver?.text = mDriverList[position].surname_driver
        holder.phoneNumberDriver?.text = mDriverList[position].phone_number_driver
        holder.carNumberDriver?.text = mDriverList[position].car_number
        holder.carDriver?.text = mDriverList[position].car
        holder.photoDriver?.downloadAndSetImage(mDriverList[position].photo_driver)
        holder.statusDriver?.text = mDriverList[position].bloc
        //Delete driver
        holder.deleteDriver?.setOnClickListener {
            REF_DATABASE_ROOT.child(NODE_DRIVERS).child(mDriverList[position].uid).removeValue()
            showToast(APP_ACTIVITY.getString(R.string.driver_deleted))
        }
        //Bloc driver
        if(mDriverList[position].bloc == BLOCK){
            holder.blocDriver?.text = APP_ACTIVITY.getString(R.string.unbloc)
            holder.blocDriver?.setOnClickListener {
                val dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_BLOC] = UNBLOCK
                REF_DATABASE_ROOT.child(NODE_DRIVERS).child(mDriverList[position].uid).updateChildren(dateMap)
                showToast(APP_ACTIVITY.getString(R.string.driver_unbloc))
            }
        }
        else{
            holder.blocDriver?.text = APP_ACTIVITY.getString(R.string.bloc)
            holder.blocDriver?.setOnClickListener {
                val dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_BLOC] = BLOCK
                REF_DATABASE_ROOT.child(NODE_DRIVERS).child(mDriverList[position].uid).updateChildren(dateMap)
                showToast(APP_ACTIVITY.getString(R.string.driver_bloc))
            }
        }
    }

    override fun getItemCount() = mDriverList.size

    fun setList(list: List<CommonModel>){
        mDriverList = list as MutableList<CommonModel>
        notifyDataSetChanged()
    }
}