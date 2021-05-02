package com.example.taxi_app_admin.ui.`object`

import androidx.appcompat.app.AppCompatActivity
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.databinding.ActivityMainBinding
import com.example.taxi_app_admin.ui.fragments.DataDriverFragment
import com.example.taxi_app_admin.ui.fragments.OrderFragment
import com.example.taxi_app_admin.ui.fragments.TripStatisticsFragment
import com.example.taxi_app_admin.utilites.replaceFragment

class AppDrawer(var mainActivity: AppCompatActivity, private val binding: ActivityMainBinding) {

    fun create() {
        createBottomNav()
    }

    //Create bottom navigation view
    private fun createBottomNav(){
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.trip_statistics -> mainActivity.replaceFragment(TripStatisticsFragment())
                R.id.data_driver -> mainActivity.replaceFragment(DataDriverFragment())
                R.id.order_create_driver_account -> mainActivity.replaceFragment(OrderFragment())
            }
            true
        }
    }
}