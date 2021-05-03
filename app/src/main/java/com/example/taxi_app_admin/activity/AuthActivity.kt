package com.example.taxi_app_admin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.taxi_app_admin.MainActivity
import com.example.taxi_app_admin.R
import com.example.taxi_app_admin.databinding.ActivityAuthBinding
import com.example.taxi_app_admin.utilites.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initAdmin()
        binding.authBtnEnter.setOnClickListener { changeLoginAndPassword() }
    }

    private fun changeLoginAndPassword() {
        if (TextUtils.isEmpty(binding.authEdtTextEmail.text.toString())) {
            showToast(getString(R.string.email_edt_text_not_filled))
            return
        } else if (TextUtils.isEmpty(binding.authEdtTextEmail.text.toString())) {
            showToast(getString(R.string.password_edt_text_not_filled))
            return
        }
        AUTH.signInWithEmailAndPassword(binding.authEdtTextEmail.text.toString(), binding.authEdtTextPassword.text.toString())
            .addOnCompleteListener { task ->
                val uid = AUTH.currentUser?.uid.toString()
                REF_DATABASE_ROOT.child(NODE_ADMIN).child(uid)
                    .addValueEventListener(object: ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val roleUser = snapshot.child(CHILD_ROLE).value.toString()
                        if(task.isSuccessful && roleUser == ADMIN_ROLE){
                            replaceActivity(MainActivity())
                        }
                        else{
                            showToast(getString(R.string.something_went_wrong))
                            AUTH.signOut()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
            }
    }
}