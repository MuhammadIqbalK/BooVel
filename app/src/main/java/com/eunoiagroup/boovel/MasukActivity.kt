package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.eunoiagroup.boovel.databinding.ActivityMasukBinding
import com.google.firebase.auth.FirebaseAuth

class MasukActivity : AppCompatActivity() {
    lateinit var binding : ActivityMasukBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMasukBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tamubtnmasuk: Button = findViewById(R.id.tamubtnmasuk)
        tamubtnmasuk.setOnClickListener{
            val intent = Intent(this@MasukActivity, MainActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        binding.texttodaftar.setOnClickListener {
            val intent = Intent(this@MasukActivity, DaftarActivity::class.java)
            startActivity(intent)
        }

        binding.btnMasuk.setOnClickListener {
            val email = binding.editemailMasuk.text.toString()
            val password = binding.editpasswordMasuk.text.toString()

            //Validasi email
            if (email.isEmpty()){
                binding.editemailMasuk.error = "Email wajib Diisi"
                binding.editemailMasuk.requestFocus()
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editemailMasuk.error = "Email Tidak Valid"
                binding.editemailMasuk.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if (password.isEmpty()){
                binding.editpasswordMasuk.error = "Password Harus Diisi"
                binding.editpasswordMasuk.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }


    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this@MasukActivity) {
            if (it.isSuccessful) {
                Toast.makeText(this@MasukActivity, "Selamat datang", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MasukActivity, MainActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(this@MasukActivity, "Login Gagal email dan password anda tidak terdaftar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}