package com.andra.synrgy_tugas_sharedpreferences_login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tvUsername

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val sharedPreferences = getSharedPreferences(UserData.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        val userNameInSP = sharedPreferences.getString(UserData.FIELD_USERNAME, "Guest")

        tvUsername.setText(userNameInSP)

        btnClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            tvUsername.setText("")
            Toast.makeText(this@MainActivity, "Data Clear", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}