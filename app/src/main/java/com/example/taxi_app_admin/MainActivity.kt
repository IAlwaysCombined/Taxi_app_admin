package com.example.taxi_app_admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taxi_app_admin.activity.AuthActivity
import com.example.taxi_app_admin.databinding.ActivityMainBinding
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.ui.`object`.AppDrawer
import com.example.taxi_app_admin.ui.fragments.RideStatisticsFragment
import com.example.taxi_app_admin.utilites.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP_ACTIVITY = this
    }

    override fun onStart() {
        super.onStart()
        mAppDrawer = AppDrawer()
        mAppDrawer.create()
        initFirebase()
        initAdmin()
        initFields()
    }

    //Initial fields
    private fun initFields(){
        if (AUTH.currentUser != null) {
            replaceFragment(RideStatisticsFragment(CommonModel()))
        }
        else{
            replaceActivity(AuthActivity())
        }
    }
}