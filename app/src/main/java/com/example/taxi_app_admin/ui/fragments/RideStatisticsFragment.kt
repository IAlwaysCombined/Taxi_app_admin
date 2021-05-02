package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.adapters.DriverDataAdapter
import com.example.taxi_app_admin.adapters.RideStatisticsAdapter
import com.example.taxi_app_admin.databinding.FragmentRideStatisticsBinding
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.*
import com.google.firebase.database.DatabaseReference

class RideStatisticsFragment(private val drives: CommonModel) : Fragment(R.layout.fragment_ride_statistics) {

    private lateinit var binding: FragmentRideStatisticsBinding
    private lateinit var adapter: RideStatisticsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var refOrders: DatabaseReference
    private lateinit var orderRequestListener: AppValueEventListener
    private var rideRequestList = mutableListOf<CommonModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRideStatisticsBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
    }

    //Initialize recycler view element
    private fun initRecyclerView(){
        recyclerView = binding.statisticsRidesRecyclerView
        adapter = RideStatisticsAdapter(mutableListOf())
        refOrders = REF_DATABASE_ROOT.child(NODE_RIDES).child(drives.id)
        recyclerView.adapter = adapter
        orderRequestListener = AppValueEventListener { dataSnapshot ->
            rideRequestList = dataSnapshot.children.map { it.getCommonModel() } as MutableList<CommonModel>
            adapter.setList(rideRequestList)
            recyclerView.smoothScrollToPosition(adapter.itemCount)
        }
        refOrders.addValueEventListener(orderRequestListener)
    }
}