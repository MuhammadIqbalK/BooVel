package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        val btnToMasuk =  findViewById<TextView>(R.id.texttomasuk)

        btnToMasuk.setOnClickListener{
            val intent = Intent(this@DaftarActivity, MasukActivity::class.java)
            startActivity(intent)
        }
    }
}