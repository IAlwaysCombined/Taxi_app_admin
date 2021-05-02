package com.example.taxi_app_admin


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taxi_app_admin.activity.AuthActivity
import com.example.taxi_app_admin.databinding.ActivityMainBinding
import com.example.taxi_app_admin.ui.`object`.AppDrawer
import com.example.taxi_app_admin.ui.fragments.TripStatisticsFragment
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
        initFields()
    }

    //Initial fields
    private fun initFields(){
        if (AUTH.currentUser != null) {
            changeUserRole()
        }
        else{
            replaceActivity(AuthActivity())
        }
    }

    //Change user role
    private fun changeUserRole() {
        REF_DATABASE_ROOT.child(NODE_ADMIN).child(UID)
            .addValueEventListener(AppValueEventListener {
                when (USER.uid) {
                    ADMIN_ROLE -> {
                        showToast("Добро пожаловать!")
                        replaceFragment(TripStatisticsFragment())
                    }
                }
            })
    }
}