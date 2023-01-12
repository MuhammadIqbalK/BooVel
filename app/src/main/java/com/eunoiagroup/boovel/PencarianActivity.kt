package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView

class PencarianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pencarian)

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@PencarianActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

}