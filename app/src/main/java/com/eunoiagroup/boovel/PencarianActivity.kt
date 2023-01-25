package com.eunoiagroup.boovel

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.firestore.FirebaseFirestore


class PencarianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pencarian)

        getDataFromFirestore()

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@PencarianActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val cardPerjalanan1: CardView = findViewById(R.id.cardPerjalanan1)
        cardPerjalanan1.setOnClickListener {
            val intent = Intent(this@PencarianActivity, DetailPerjalananActivity::class.java)
            startActivity(intent)
        }

        val cardPerjalanan2: ConstraintLayout = findViewById(R.id.constraintcard)
        cardPerjalanan2.setOnClickListener {
            val intent = Intent(this@PencarianActivity, DetailPerjalananActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getDataFromFirestore() {
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("tiket")

        collectionRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                for (document in task.result!!) {
                    val item = document.toObject(tiket::class.java)
                    val hargaTextView = findViewById<TextView>(R.id.hargadb)
                    hargaTextView.text = item.harga_perorang
                    val descriptionTerminalA = findViewById<TextView>(R.id.terminalA)
                    descriptionTerminalA.text = item.terminal_berangkat
                    val descriptionTerminalB = findViewById<TextView>(R.id.terminalB)
                    descriptionTerminalB.text = item.terminal_tujuan
                    val jamA = findViewById<TextView>(R.id.jamdbberangkat)
                    jamA.text = item.jam_berangkat
                    val jamB = findViewById<TextView>(R.id.jamdbtiba)
                    jamB.text = item.jam_sampai
//                   var selisihj = findViewById<TextView>(R.id.jamselisih)
//                    try {
//                        val result = subtractTime(jamA.text as String, jamB.text as String)
//                        selisihj.text = result
//                    } catch (e: Exception) {
//                        // handle the error
//                        val builder = AlertDialog.Builder(this)
//                        builder.setTitle("Error")
//                        builder.setMessage(e.message)
//                        builder.setPositiveButton("OK") { _, _ -> }
//                        val dialog: AlertDialog = builder.create()
//                        dialog.show()
//                    }




                }
            }
        }
    }

    fun subtractTime(time: String, subtract: String): String {
        val timeParts = time.split(":")
        val subtractParts = subtract.split(":")
        var hour = timeParts[0].toInt()
        var minute = timeParts[1].toInt()
        minute -= subtractParts[1].toInt()
        while (minute < 0) {
            minute += 60
            hour--
        }
        hour -= subtractParts[0].toInt()
        while (hour < 0) {
            hour += 24
        }
        return "%02d:%02d".format(hour, minute)
    }






}

