package com.example.taxi_app_admin.utilites

import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taxi_app_admin.R
import com.squareup.picasso.Picasso

//Help fun toast
fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}
//Replace fragment on activity
fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(R.id.main_container, fragment)
        .commit()
}
//Replace activity on activity
fun AppCompatActivity.replaceActivity(activity: Activity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}
//Replace activity on fragment
fun Fragment.replaceActivity(activity: Activity) {
    val intent = Intent(this.context, activity::class.java)
    startActivity(intent)
}
//Image view function
fun ImageView.downloadAndSetImage(url: String) {
    Picasso.get()
        .load(url)
        .fit()
        .placeholder(R.mipmap.ic_launcher)
        .into(this)
}

