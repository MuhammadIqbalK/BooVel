package com.eunoiagroup.boovel

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.nio.channels.CancelledKeyException
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var  etDatePicker: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        etDatePicker = view.findViewById(R.id.edittvTanggalKeberangkatan)

        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        etDatePicker.setOnClickListener {
            context?.let {  DatePickerDialog(it, { view, mYear, monthOfYear, dayOfMonth ->

                val simpleDateFormat = SimpleDateFormat("EEEE")
                val date = Date(mYear, month, dayOfMonth - 1)
                val dayString = simpleDateFormat.format(date) //returns true day name for current month only

                etDatePicker.setText("$dayString, $dayOfMonth/${monthOfYear + 1}/$mYear")

            }, year, month, day).show() }
        }

        val editAsal: EditText = view.findViewById(R.id.editAsal)
        editAsal.setOnClickListener() {
            val intent = Intent(activity, InputAsalActivity::class.java)
            startActivity(intent)
        }

        val editTujuan: EditText = view.findViewById(R.id.editTujuan)
        editTujuan.setOnClickListener() {
            val intent = Intent(activity, InputAsalActivity::class.java)
            startActivity(intent)
        }

        val search = view.findViewById<Button>(R.id.btnCari)
        search.setOnClickListener{
            val intent = Intent(activity, PencarianActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BerandaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BerandaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}