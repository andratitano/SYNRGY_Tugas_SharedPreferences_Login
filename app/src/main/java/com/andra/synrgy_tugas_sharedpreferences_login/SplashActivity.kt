package com.andra.synrgy_tugas_sharedpreferences_login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences(UserData.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val handler = Handler()

        handler.postDelayed({

            val saved = sharedPreferences.contains(UserData.FIELD_LOGIN)

            Log.d("hasil", saved.toString())

            if (saved) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        },2000)

    }
}