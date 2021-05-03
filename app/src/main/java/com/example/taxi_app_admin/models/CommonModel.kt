package com.example.taxi_app_admin.models

//Common model
data class CommonModel (
    val id: String = "",
    val uid: String = "",
    val name_driver: String = "",
    val last_name_driver: String = "",
    val surname_driver: String = "",
    val phone_number_driver: String = "",
    val car_number: String = "",
    val car: String = "",
    val photo_driver: String = "empty",
    val photo_car_driver: String = "",
    val photo_license_driver: String = "",

    val name_user: String = "",
    val last_name_user: String = "",
    val surname_user: String = "",
    val phone_number_user: String = "",

    val coast_ride: String = "",
    val pay_method: String = "",
)