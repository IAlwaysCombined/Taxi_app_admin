package com.example.taxi_app_admin.utilites

import com.example.taxi_app_admin.models.CommonModel
import com.example.taxi_app_admin.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var AUTH: FirebaseAuth
lateinit var UID: String
lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var USER: User

//Nodes
const val NODE_ORDER_DRIVERS = "order_drivers"
const val NODE_DRIVERS = "driver"
const val NODE_ADMIN = "admin"
const val NODE_RIDES = "rides"

//Const role
const val ADMIN_ROLE = "admin"

fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    UID = AUTH.currentUser?.uid.toString()
    USER = User()
}

fun DataSnapshot.getCommonModel(): CommonModel =
    this.getValue(CommonModel::class.java) ?: CommonModel()

//Initial users
fun initUser() {
    REF_DATABASE_ROOT.child(NODE_ADMIN).child(UID)
        .addListenerForSingleValueEvent(AppValueEventListener {
            USER = it.getValue(User::class.java) ?: User()
        })
}