package com.example.deepcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.deepcode.profile.ProfileActivity

class NewsActivity : AppCompatActivity() {

    private val item1: View by lazy { findViewById(R.id.item1) }
    private val item2: View by lazy { findViewById(R.id.item2) }
    private val item3: View by lazy { findViewById(R.id.item3) }
    private val item4: View by lazy { findViewById(R.id.item4) }
    private val item5: View by lazy { findViewById(R.id.item5) }

    private val navHomeBtn: ImageView by lazy { findViewById(R.id.btn_home) }
    private val navRecruitBtn: ImageView by lazy { findViewById(R.id.btn_recruit) }
    private val navNewsBtn: ImageView by lazy { findViewById(R.id.btn_news) }
    private val navProfileBtn: ImageView by lazy { findViewById(R.id.btn_profile) }

    private val item1Profile: ImageView by lazy { item1.findViewById(R.id.iv_item_profile) }
    private val item1UserName: TextView by lazy { item1.findViewById(R.id.tv_item_user_name) }
    private val item1Text: TextView by lazy { item1.findViewById(R.id.tv_item_text) }

    private val item2Profile: ImageView by lazy { item2.findViewById(R.id.iv_item_profile) }
    private val item2UserName: TextView by lazy { item2.findViewById(R.id.tv_item_user_name) }
    private val item2Text: TextView by lazy { item2.findViewById(R.id.tv_item_text) }

    private val item3Profile: ImageView by lazy { item3.findViewById(R.id.iv_item_profile) }
    private val item3UserName: TextView by lazy { item3.findViewById(R.id.tv_item_user_name) }
    private val item3Text: TextView by lazy { item3.findViewById(R.id.tv_item_text) }

    private val item4Profile: ImageView by lazy { item4.findViewById(R.id.iv_item_profile) }
    private val item4UserName: TextView by lazy { item4.findViewById(R.id.tv_item_user_name) }
    private val item4Text: TextView by lazy { item4.findViewById(R.id.tv_item_text) }

    private val item5Profile: ImageView by lazy { item5.findViewById(R.id.iv_item_profile) }
    private val item5UserName: TextView by lazy { item5.findViewById(R.id.tv_item_user_name) }
    private val item5Text: TextView by lazy { item5.findViewById(R.id.tv_item_text) }


    private val items
        get() = listOf(
            item1,
            item2,
            item3,
            item4,
            item5
        )

    private val navBtns
        get() = listOf(
            navHomeBtn,
            navRecruitBtn,
            navNewsBtn,
            navProfileBtn
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        initView()
    }



    private fun initView() {
        setNavBtnClickListener()
        setNewsItemsEvent()
        drawNewsItems()
    }

    private fun setNavBtnClickListener() {
        navBtns.forEach { navBtn ->
            navBtn.setOnClickListener {
                when (navBtn) {
                    navHomeBtn -> startActivity(Intent(this, HomeActivity::class.java))
                    navRecruitBtn -> startActivity(Intent(this, RecruitActivity::class.java))
                    navNewsBtn -> startActivity(Intent(this, NewsActivity::class.java))
                    navProfileBtn -> startActivity(Intent(this, ProfileActivity::class.java))
                }
            }
        }
    }

    private fun setNewsItemsEvent() {
        items.forEach { item ->
            item.setOnClickListener {
                when (item) {
                    item1 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("itemProfile", R.drawable.ic_ai_news)
                        intent.putExtra("itemUserName", R.string.news_item1_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_macdonald)
                        intent.putExtra("itemText", R.string.news_item1_text)
                        startActivity(intent)
                    }

                    item2 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("itemProfile", R.drawable.ic_it_world)
                        intent.putExtra("itemUserName", R.string.news_item2_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_happy_dev)
                        intent.putExtra("itemText", R.string.news_item2_text)
                        startActivity(intent)
                    }

                    item3 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("itemProfile", R.drawable.ic_yeonhap_news)
                        intent.putExtra("itemUserName", R.string.news_item3_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_kakaomobile_news)
                        intent.putExtra("itemText", R.string.news_item3_text)
                        startActivity(intent)
                    }

                    item4 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("itemProfile", R.drawable.ic_zdnet)
                        intent.putExtra("itemUserName", R.string.news_item4_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_hyosung_person)
                        intent.putExtra("itemText", R.string.news_item4_text)
                        startActivity(intent)
                    }

                    item5 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("itemProfile", R.drawable.ic_world_news)
                        intent.putExtra("itemUserName", R.string.news_item5_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_google_logo)
                        intent.putExtra("itemText", R.string.news_item5_text)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun drawNewsItems() {
        item1Profile.setImageResource(R.drawable.ic_ai_news)
        item1UserName.text = getString(R.string.news_item1_user_name)
        item1Text.text = getString(R.string.news_item1_text)

        item2Profile.setImageResource(R.drawable.ic_it_world)
        item2UserName.text = getString(R.string.news_item2_user_name)
        item2Text.text = getString(R.string.news_item2_text)

        item3Profile.setImageResource(R.drawable.ic_yeonhap_news)
        item3UserName.text = getString(R.string.news_item3_user_name)
        item3Text.text = getString(R.string.news_item3_text)

        item4Profile.setImageResource(R.drawable.ic_zdnet)
        item4UserName.text = getString(R.string.news_item4_user_name)
        item4Text.text = getString(R.string.news_item4_text)

        item5Profile.setImageResource(R.drawable.ic_world_news)
        item5UserName.text = getString(R.string.news_item5_user_name)
        item5Text.text = getString(R.string.news_item5_text)
    }

}