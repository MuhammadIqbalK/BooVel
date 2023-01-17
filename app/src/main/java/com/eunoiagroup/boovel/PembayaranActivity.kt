package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet.Layout

class PembayaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@PembayaranActivity, DetailPerjalananActivity::class.java)
            startActivity(intent)
        }

        val id: View? = findViewById(R.id.layoutBankBCA)
        id?.setOnClickListener {
            val intent = Intent(this@PembayaranActivity, DetailPembayaranActivity::class.java)
            startActivity(intent)
        }

    }
}