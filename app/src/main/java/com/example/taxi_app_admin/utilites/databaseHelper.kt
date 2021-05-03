package com.example.taxi_app_admin.utilites

import com.example.taxi_app_admin.models.Admin
import com.example.taxi_app_admin.models.CommonModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var AUTH: FirebaseAuth
lateinit var UID: String
lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var ADMIN: Admin

//Nodes
const val NODE_ORDER_DRIVERS = "order_drivers"
const val NODE_DRIVERS = "driver"
const val NODE_ADMIN = "admin"
const val NODE_RIDES = "rides"

//Child object
const val NAME_DRIVER = "name_driver"
const val LAST_NAME_DRIVER = "last_name_driver"
const val CAR = "car"
const val CAR_NUMBER = "car_number"
const val SURNAME_DRIVER = "surname_driver"
const val PHOTO_DRIVER = "photo_driver"
const val PHONE_NUMBER = "phone_number"
const val UID_DRIVER = "uid"
const val CHILD_ROLE = "role"

//Const role
const val ADMIN_ROLE = "admin"

//init firebase method
fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    UID = AUTH.currentUser?.uid.toString()
    ADMIN = Admin()
}

//Get common model fun
fun DataSnapshot.getCommonModel(): CommonModel =
    this.getValue(CommonModel::class.java) ?: CommonModel()

//Initial users
fun initAdmin() {
    REF_DATABASE_ROOT.child(NODE_ADMIN).child(UID)
        .addListenerForSingleValueEvent(AppValueEventListener {
            ADMIN = it.getValue(Admin::class.java) ?: Admin()
        })
}