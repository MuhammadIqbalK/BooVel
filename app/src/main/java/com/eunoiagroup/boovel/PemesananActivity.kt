package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PemesananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan)

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@PemesananActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val btnAturPosisiDuduk: Button = findViewById(R.id.btnAturPosisiDuduk)
        btnAturPosisiDuduk.setOnClickListener {
            val intent = Intent(this@PemesananActivity, PilihKursiActivity::class.java)
            startActivity(intent)
        }

        val btnLanjutKePembayaran: Button = findViewById(R.id.btnLanjutKePembayaran)
        btnLanjutKePembayaran.setOnClickListener {
            val intent = Intent(this@PemesananActivity, PembayaranActivity::class.java)
            startActivity(intent)
        }
    }
}