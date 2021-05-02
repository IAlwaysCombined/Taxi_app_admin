package com.example.taxi_app_admin.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.databinding.ActivityMainBinding
import com.example.taxi_app_admin.ui.fragments.DataDriverFragment
import com.example.taxi_app_admin.ui.fragments.OrderFragment
import com.example.taxi_app_admin.ui.fragments.StaticFragment
import com.example.taxi_app_admin.utilites.replaceFragment

class AppDrawer(var mainActivity: AppCompatActivity, private val mBinding: ActivityMainBinding) {

    fun create() {
        createBottomNav()
    }

    private fun createBottomNav(){
        mBinding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.stat -> mainActivity.replaceFragment(StaticFragment())
                R.id.data_driver -> mainActivity.replaceFragment(DataDriverFragment())
                R.id.order -> mainActivity.replaceFragment(OrderFragment())
            }
            true
        }
    }
}