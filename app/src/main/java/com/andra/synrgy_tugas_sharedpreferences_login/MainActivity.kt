package com.andra.synrgy_tugas_sharedpreferences_login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

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
    }
}