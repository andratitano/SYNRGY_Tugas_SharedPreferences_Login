package com.andra.synrgy_tugas_sharedpreferences_login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val sharedPreferences = getSharedPreferences(UserData.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val editor = sharedPreferences.edit()
            val cb = cbRemember.isChecked

            if (cb){
                editor.putString(UserData.FIELD_USERNAME, etUsername.text.toString())
                editor.putString(UserData.FIELD_PASSWORD, etPasssword.text.toString())
                editor.putBoolean(UserData.FIELD_LOGIN, true)

                val isSaved = editor.commit()

                if (isSaved) {
                    Toast.makeText(this, "Data Tersimpan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Data Tidak Tersimpan", Toast.LENGTH_SHORT).show()
                }
            }

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}