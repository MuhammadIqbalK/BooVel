package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DetailPembayaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pembayaran)

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@DetailPembayaranActivity, PembayaranActivity::class.java)
            startActivity(intent)
        }

        val btnBayar: Button = findViewById(R.id.btnBayar)
        btnBayar.setOnClickListener {
            val intent = Intent(this@DetailPembayaranActivity, InformasiPembayaranActivity::class.java)
            startActivity(intent)
        }
    }
}