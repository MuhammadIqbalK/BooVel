package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PilihKursiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_kursi)

        val btnSimpan: Button = findViewById(R.id.btnSimpan)
        btnSimpan.setOnClickListener {
            val intent = Intent(this@PilihKursiActivity, PemesananActivity::class.java)
            startActivity(intent)
        }
    }
}