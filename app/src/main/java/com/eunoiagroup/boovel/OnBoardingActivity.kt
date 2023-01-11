package com.eunoiagroup.boovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var onBoardingItemAdapter: OnBoardingItemAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        supportActionBar?.hide()
        setOnBoardingItem()
        setupIndicators()
        setCurrentIndicators(0)
    }

    private fun setOnBoardingItem() {
        onBoardingItemAdapter = OnBoardingItemAdapter(
            listOf(
                OnBoardingItem(
                    imageOnBoarding = R.drawable.onboarding_ilustration_1,
                    tvTitleOnBoarding = "Banyak Kemudahan Dalam Satu Aplikasi",
                    tvDescOnBoarding = "Dengan BooVel anda dapat membeli tiket travel yang sesuai dengan keinginan anda."
                ),
                OnBoardingItem(
                    imageOnBoarding = R.drawable.onboarding_ilustration_2,
                    tvTitleOnBoarding = "Temukan Beragam Pilihan Mitra Travel",
                    tvDescOnBoarding = "Puluhan mitra travel telah bergabung dengan kami untuk memberikan layanan yang terbaik kepada anda."
                ),
                OnBoardingItem(
                    imageOnBoarding = R.drawable.onboarding_ilustration_1,
                    tvTitleOnBoarding = "Komunitas",
                    tvDescOnBoarding = "Tersedia fitur komunitas untuk mengumpulkan orang-orang yang menyukai pada bidang kerajinan tangan untuk berinteraksi."
                )
            )
        )
        val onBoardingViewPager: ViewPager2 = findViewById(R.id.onBoardingViewPager)
        onBoardingViewPager.adapter = onBoardingItemAdapter
        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicators(position)
                }
            }
        )
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        findViewById<Button>(R.id.btnOnBoarding).setOnClickListener {
            if (onBoardingViewPager.currentItem + 1 < onBoardingItemAdapter.itemCount) {
                onBoardingViewPager.currentItem += 1
            }else {
                navigateToRegisterActivity()
           }
        }
    }

    private fun navigateToRegisterActivity() {
        startActivity(Intent(applicationContext, MasukActivity::class.java))
        finish()
    }

    private fun setupIndicators() {
        indicatorsContainer = findViewById(R.id.onBoardingIndicators)
        val indicators = arrayOfNulls<ImageView>(onBoardingItemAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(15,0,15,0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator_inactive
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicators(position: Int) {
        val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount) {
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator_active
                    )
                )
            }else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator_inactive
                    )
                )
            }
        }
    }
}