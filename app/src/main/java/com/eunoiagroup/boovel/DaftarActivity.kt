package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.eunoiagroup.boovel.databinding.ActivityDaftarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class DaftarActivity : AppCompatActivity() {
    lateinit var binding: ActivityDaftarBinding
    lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        binding.texttomasuk.setOnClickListener {
            val intent = Intent(this@DaftarActivity, MasukActivity::class.java)
            startActivity(intent)
        }

        binding.btnDaftar.setOnClickListener {
            val email = binding.editemailDaftar.text.toString()
            val password = binding.editpasswordDaftar.text.toString()
            val nama = binding.editNamaDaftar.text.toString()
            val nomor = binding.editnotelpDaftar.text.toString()


            if(nama.isEmpty()) {
                binding.editNamaDaftar.error = "Nama wajib diisi"
                binding.editNamaDaftar.requestFocus()
                return@setOnClickListener
            }

            if(nomor.isEmpty()) {
                binding.editnotelpDaftar.error = "Nomor telepon wajib diisi"
                binding.editnotelpDaftar.requestFocus()
                return@setOnClickListener
            }

            if(email.isEmpty()) {
                binding.editemailDaftar.error = "Email harus diisi"
                binding.editemailDaftar.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editemailDaftar.error = "Email tidak valid"
                binding.editemailDaftar.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()) {
                binding.editpasswordDaftar.error = "Password harus diisi"
                binding.editpasswordDaftar.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 8) {
                binding.editpasswordDaftar.error = "Password minimal 8 karakter"
                binding.editpasswordDaftar.requestFocus()
                return@setOnClickListener
            }




            DaftarFirebase(email, password, nama, nomor)

        }

    }

    private fun DaftarFirebase(email: String, password: String, nama: String, nomor: String) {



        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this@DaftarActivity) {
            if (it.isSuccessful) {
               val user = auth.currentUser
                    val userData = User (user?.uid!!, email, nama, nomor )
                    db.collection("users").document(user?.uid!!).set(userData)
                Toast.makeText(this@DaftarActivity, "Registrasi akun berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@DaftarActivity, MasukActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(this@DaftarActivity, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }

    }
}
}

