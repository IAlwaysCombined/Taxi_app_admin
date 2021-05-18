package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.database.NODE_DRIVERS
import com.example.taxi_app_admin.database.REF_DATABASE_ROOT
import com.example.taxi_app_admin.database.getCommonModel
import com.example.taxi_app_admin.databinding.FragmentPhotoDriverLicenseBinding
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.AppValueEventListener
import com.example.taxi_app_admin.utilites.backStack
import com.example.taxi_app_admin.utilites.downloadAndSetImage
import com.google.firebase.database.DatabaseReference


class PhotoDriverLicenseFragment(private val photoLicence: String) : Fragment(R.layout.fragment_photo_driver_license) {

    private lateinit var binding: FragmentPhotoDriverLicenseBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoDriverLicenseBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()
        binding.photoLicenseAllScreen.downloadAndSetImage(photoLicence)
        binding.photoLicenseAllScreenBackBtn.setOnClickListener { backStack() }
    }
}