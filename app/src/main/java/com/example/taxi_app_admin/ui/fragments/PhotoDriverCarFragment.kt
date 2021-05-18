package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.databinding.FragmentPhotoDriverCarBinding
import com.example.taxi_app_admin.utilites.backStack
import com.example.taxi_app_admin.utilites.downloadAndSetImage


class PhotoDriverCarFragment(private val photoCar: String) : Fragment(R.layout.fragment_photo_driver_car) {

    private lateinit var binding: FragmentPhotoDriverCarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoDriverCarBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()
        binding.photoCarAllScreen.downloadAndSetImage(photoCar)
        binding.photoCarAllScreenBackBtn.setOnClickListener { backStack() }
    }
}