package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.adapters.OrderCreateAccountDriverAdapter
import com.example.taxi_app_admin.databinding.FragmentOrderBinding
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.*
import com.google.firebase.database.DatabaseReference


class OrderFragment : Fragment(R.layout.fragment_order) {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderCreateAccountDriverAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var refOrders: DatabaseReference
    private lateinit var orderRequestListener: AppValueEventListener
    private var orderRequestList = mutableListOf<CommonModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
    }

    //Initialize recycler view element
    private fun initRecyclerView(){
        recyclerView = binding.orderCreateDriverAccountRecyclerView
        adapter = OrderCreateAccountDriverAdapter(mutableListOf())
        refOrders = REF_DATABASE_ROOT.child(NODE_ORDER_DRIVERS)
        recyclerView.adapter = adapter
        orderRequestListener = AppValueEventListener { dataSnapshot ->
            orderRequestList = dataSnapshot.children.map { it.getCommonModel() } as MutableList<CommonModel>
            adapter.setList(orderRequestList)
            recyclerView.smoothScrollToPosition(adapter.itemCount)
        }
        refOrders.addValueEventListener(orderRequestListener)
    }
}