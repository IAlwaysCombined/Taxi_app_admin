package com.example.taxi_app_admin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.activity.AuthActivity
import com.example.taxi_app_admin.database.AUTH
import com.example.taxi_app_admin.databinding.FragmentOtherBinding
import com.example.taxi_app_admin.utilites.*


class OtherFragment : Fragment(R.layout.fragment_other) {

    private lateinit var binding: FragmentOtherBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOtherBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        binding.otherExitBtn.setOnClickListener {
            replaceActivity(AuthActivity())
            AUTH.signOut()
        }
    }
}