package com.example.taxi_app_admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taxi_app_admin.databinding.ActivityMainBinding
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.ui.`object`.AppDrawer
import com.example.taxi_app_admin.ui.fragments.RideStatisticsFragment
import com.example.taxi_app_admin.utilites.APP_ACTIVITY
import com.example.taxi_app_admin.utilites.initFirebase
import com.example.taxi_app_admin.utilites.initUser
import com.example.taxi_app_admin.utilites.replaceFragment


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
        initUser()
        //initFields()
        replaceFragment(RideStatisticsFragment(CommonModel()))
    }

//    //Initial fields
//    private fun initFields(){
//        if (AUTH.currentUser != null) {
//            if (USER.role == ADMIN_ROLE){
//                showToast(USER.role)
//            }
//            replaceActivity(MainActivity())
//        }
//        else{
//            replaceActivity(AuthActivity())
//        }
//    }
}