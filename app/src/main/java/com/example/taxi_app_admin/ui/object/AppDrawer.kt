package com.example.taxi_app_admin.ui.`object`

import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.activity.AuthActivity
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.ui.fragments.DataDriverFragment
import com.example.taxi_app_admin.ui.fragments.OrderFragment
import com.example.taxi_app_admin.ui.fragments.OtherFragment
import com.example.taxi_app_admin.ui.fragments.RideStatisticsFragment
import com.example.taxi_app_admin.utilites.APP_ACTIVITY
import com.example.taxi_app_admin.utilites.replaceActivity
import com.example.taxi_app_admin.utilites.replaceFragment

class AppDrawer() {

    fun create() {
        createBottomNav()
    }

    //Create bottom navigation view
    private fun createBottomNav(){
        APP_ACTIVITY.binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.trip_statistics -> APP_ACTIVITY.replaceFragment(RideStatisticsFragment(CommonModel()))
                R.id.data_driver -> APP_ACTIVITY.replaceFragment(DataDriverFragment())
                R.id.order_create_driver_account -> APP_ACTIVITY.replaceFragment(OrderFragment())
                R.id.other -> APP_ACTIVITY.replaceFragment(OtherFragment())
            }
            true
        }
    }
}