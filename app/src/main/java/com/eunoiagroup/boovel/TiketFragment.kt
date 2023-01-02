package com.eunoiagroup.boovel

import FragmentAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TiketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val b: View = inflater.inflate(R.layout.fragment_tiket, container, false)

        var viewPager: ViewPager = b.findViewById(R.id.viewPager)
        var tabLayout: TabLayout = b.findViewById(R.id.tablayout)

        val fragmentAdapter = FragmentAdapter(childFragmentManager)
        fragmentAdapter.addFragment(TiketAktifFragment(), "Tiket Aktif")
        fragmentAdapter.addFragment(RiwayatTransaksiFragment(), "Riwayat Transaksi")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        return b
    }
}