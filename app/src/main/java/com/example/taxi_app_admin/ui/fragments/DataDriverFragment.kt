package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.databinding.FragmentDataDriverBinding


class DataDriverFragment : Fragment(R.layout.fragment_data_driver) {

    private lateinit var binding: FragmentDataDriverBinding

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

    }

}