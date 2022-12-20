package com.eunoiagroup.boovel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TiketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val b: View = inflater.inflate(R.layout.fragment_tiket, container, false)

        val tabLayout = b.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = b.findViewById<ViewPager2>(R.id.view_pager)

        viewPager.adapter = FragmentAdapter(this)

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Tiket Aktif"
                }
                1 -> {
                    tab.text = "Riwayat Transaksi"
                }
            }
        }.attach()

        return b
    }

    class FragmentAdapter(activity: TiketFragment) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2
        }
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> TiketAktifFragment.newInstance()
                1 -> RiwayatTransaksiFragment.newInstance()
                else -> TiketAktifFragment.newInstance()
            }
        }
    }

}