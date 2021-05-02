package com.example.taxi_app_admin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.taxi_app_admin.MainActivity
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.databinding.ActivityAuthBinding
import com.example.taxi_app_admin.utilites.AUTH
import com.example.taxi_app_admin.utilites.replaceActivity
import com.example.taxi_app_admin.utilites.replaceFragment
import com.example.taxi_app_admin.utilites.showToast

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.authBtnEnter.setOnClickListener { changeLoginAndPassword() }
    }

    private fun changeLoginAndPassword() {
        if (TextUtils.isEmpty(binding.authEdtTextEmail.text.toString())) {
            showToast("Заполните поле email")
            return
        } else if (TextUtils.isEmpty(binding.authEdtTextEmail.text.toString())) {
            showToast("Заполните поле пароль")
            return
        }
        AUTH.signInWithEmailAndPassword(binding.authEdtTextEmail.text.toString(), binding.authEdtTextPassword.text.toString())
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    replaceActivity(MainActivity())
                }
                else{
                    showToast("Что-то пошло не так!")
                }
            }
    }
}