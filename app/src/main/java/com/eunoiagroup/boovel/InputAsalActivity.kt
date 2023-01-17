package com.eunoiagroup.boovel

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView


class InputAsalActivity : AppCompatActivity() {

    private lateinit var kotaArrayList: ArrayList<Kota>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_asal)

        val searchBar: SearchView = findViewById(R.id.searchBar)
        val searchList: ListView = findViewById(R.id.citiesList)

        val namaKota = arrayOf("Jakarta","Bandung","Surabaya","Yogyakarta","Semarang","Palangkaraya","Palembang",
            "Pekanbaru","Padang","Jambi","Medan","Pontianak","Balikpapan","Banjarmasin","Makassar")

        val searchListAdapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaKota)

        searchList.adapter = searchListAdapter;

        searchBar.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchBar.clearFocus()
                if (namaKota.contains(query)){
                    searchListAdapter.filter.filter(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchListAdapter.filter.filter(newText)
                return false
            }
        })


        val tvBatal: TextView = findViewById(R.id.tvBatal)
        tvBatal.setOnClickListener {
            val intent = Intent(this@InputAsalActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

}