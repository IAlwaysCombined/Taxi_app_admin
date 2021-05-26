package com.example.taxi_app_admin.models

//Common model
data class CommonModel (
    val id: String = "",
    val uid: String = "",
    val name_driver: String = "",
    val last_name_driver: String = "",
    val surname_driver: String = "",
    val phone_user: String = "",
    val car_number: String = "",
    val car: String = "",
    val photo_driver: String = "empty",
    val photo_car: String = "empty",
    val photo_licence: String = "empty",
    val bloc: String = "",
    val email_driver: String = "",

    val name_user: String = "",
    val last_name_user: String = "",
    val surname_user: String = "",
    val start_ride: String = "",
    val end_ride: String = "",
    val center_ride: String = "",
    val phone_number_user: String = "",
    val phone_number_driver: String = "",

    val coast_ride: String = "",
    val pay_method: String = "",
)