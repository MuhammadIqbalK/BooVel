package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MasukActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)
        val btnToDaftar =  findViewById<TextView>(R.id.texttodaftar)
        val btnMasukmain =  findViewById<TextView>(R.id.btnMasuk)

        btnToDaftar.setOnClickListener{
            val intent = Intent(this@MasukActivity, DaftarActivity::class.java)
            startActivity(intent)
        }
        btnMasukmain.setOnClickListener{
            val intent = Intent(this@MasukActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}