package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DetailPerjalananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_perjalanan)

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@DetailPerjalananActivity, PencarianActivity::class.java)
            startActivity(intent)
        }

        val btnPesan: Button = findViewById(R.id.btnPesan)
        btnPesan.setOnClickListener {
            val intent = Intent(this@DetailPerjalananActivity, PemesananActivity::class.java)
            startActivity(intent)
        }

    }
}