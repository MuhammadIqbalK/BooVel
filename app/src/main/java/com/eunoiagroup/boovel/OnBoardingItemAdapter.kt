package com.eunoiagroup.boovel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnBoardingItemAdapter(private val onBoardingItem: List<OnBoardingItem>) : RecyclerView.Adapter<OnBoardingItemAdapter.OnBoardingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingItemViewHolder {
        return OnBoardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.onboarding_item_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItem[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItem.size
    }

    inner class OnBoardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageOnBoarding: ImageView = view.findViewById(R.id.imageOnBoarding)
        private val tvTitleOnBoarding: TextView = view.findViewById(R.id.tvTitleOnBoarding)
        private val tvDescOnBoarding: TextView = view.findViewById(R.id.tvDescOnBoarding)

        fun bind(onBoardingItem: OnBoardingItem) {
            imageOnBoarding.setImageResource(onBoardingItem.imageOnBoarding)
            tvTitleOnBoarding.text = onBoardingItem.tvTitleOnBoarding
            tvDescOnBoarding.text = onBoardingItem.tvDescOnBoarding
        }
    }

}