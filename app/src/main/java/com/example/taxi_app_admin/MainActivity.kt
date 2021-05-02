package com.example.taxi_app_admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxi_app_admin.databinding.ActivityMainBinding
import com.example.taxi_app_admin.ui.`object`.AppDrawer
import com.example.taxi_app_admin.utilites.APP_ACTIVITY
import com.example.taxi_app_admin.utilites.initFirebase

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
        mAppDrawer = AppDrawer(this, binding)
        mAppDrawer.create()
        initFirebase()
    }
}