package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.adapters.DriverDataAdapter
import com.example.taxi_app_admin.database.NODE_DRIVERS
import com.example.taxi_app_admin.database.REF_DATABASE_ROOT
import com.example.taxi_app_admin.database.getCommonModel
import com.example.taxi_app_admin.databinding.FragmentDataDriverBinding
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.AppValueEventListener
import com.google.firebase.database.DatabaseReference


class DataDriverFragment : Fragment(R.layout.fragment_data_driver) {

    private lateinit var binding: FragmentDataDriverBinding
    private lateinit var adapter: DriverDataAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var refOrders: DatabaseReference
    private lateinit var orderRequestListener: AppValueEventListener
    private var dataRequestList = mutableListOf<CommonModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDataDriverBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
    }

    //Initialize recycler view element
    private fun initRecyclerView(){
        recyclerView = binding.driverDataRecyclerView
        adapter = DriverDataAdapter(mutableListOf())
        refOrders = REF_DATABASE_ROOT.child(NODE_DRIVERS)
        recyclerView.adapter = adapter
        orderRequestListener = AppValueEventListener { dataSnapshot ->
            dataRequestList = dataSnapshot.children.map { it.getCommonModel() } as MutableList<CommonModel>
            adapter.setList(dataRequestList)
            recyclerView.smoothScrollToPosition(adapter.itemCount)
        }
        refOrders.addValueEventListener(orderRequestListener)
    }
}