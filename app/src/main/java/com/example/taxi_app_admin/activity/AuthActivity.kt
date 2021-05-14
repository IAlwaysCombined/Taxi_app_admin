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
        binding.authTextViewRestorePassword.setOnClickListener { restorePassword() }
    }

    //Restore password
    private fun restorePassword() {
        val emailAdmin = binding.authEdtTextEmail.text.toString()
        if (emailAdmin.isEmpty()) {
            showToast(getString(R.string.email_edt_text_not_filled_toast))
            return
        }
        val emailAddress = binding.authEdtTextEmail.text.toString()
        AUTH.sendPasswordResetEmail(emailAddress)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) showToast(getString(R.string.message_restore_password_send_toast))
                else showToast(getString(R.string.something_went_wrong_toast))
            }
    }

    //Change login, password, role user
    private fun changeLoginAndPassword() {
        val emailAdmin = binding.authEdtTextEmail.text.toString()
        val passwordAdmin = binding.authEdtTextPassword.text.toString()
        if (emailAdmin.isEmpty()) {
            showToast(getString(R.string.email_edt_text_not_filled_toast))
            return
        } else if (passwordAdmin.isEmpty()) {
            showToast(getString(R.string.password_edt_text_not_filled_toast))
            return
        }
        AUTH.signInWithEmailAndPassword(emailAdmin, passwordAdmin)
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
                            showToast(getString(R.string.something_went_wrong_toast))
                            AUTH.signOut()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
            }
    }
}