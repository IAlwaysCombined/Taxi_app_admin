package com.example.taxi_app_admin.database

import com.example.taxi_app_admin.models.Admin
import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.utilites.AppValueEventListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase

//init firebase method
fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    UID = AUTH.currentUser?.uid.toString()
    PHONE = AUTH.currentUser?.phoneNumber.toString()
    ADMIN = Admin()
    COMMON = CommonModel()
}

//Get common model fun
fun DataSnapshot.getCommonModel(): CommonModel =
    this.getValue(CommonModel::class.java) ?: CommonModel()

//Initial admins
fun initAdmin() {
    REF_DATABASE_ROOT.child(NODE_ADMIN).child(UID)
        .addListenerForSingleValueEvent(AppValueEventListener {
            ADMIN = it.getValue(Admin::class.java) ?: Admin()
        })
}

//Initial drivers
fun initDriver() {
    REF_DATABASE_ROOT.child(NODE_DRIVERS)
        .addListenerForSingleValueEvent(AppValueEventListener {
            COMMON = it.getValue(CommonModel::class.java) ?: CommonModel()
        })
}