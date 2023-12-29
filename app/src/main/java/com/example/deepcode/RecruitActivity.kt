package com.example.deepcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.deepcode.profile.ProfileActivity

class RecruitActivity : AppCompatActivity() {

    private val item1: View by lazy { findViewById(R.id.item1) }
    private val item2: View by lazy { findViewById(R.id.item2) }
    private val item3: View by lazy { findViewById(R.id.item3) }
    private val item4: View by lazy { findViewById(R.id.item4) }
    private val item5: View by lazy { findViewById(R.id.item5) }
    private val item6: View by lazy { findViewById(R.id.item6) }
    private val item7: View by lazy { findViewById(R.id.item7) }
    private val item8: View by lazy { findViewById(R.id.item8) }
    private val item9: View by lazy { findViewById(R.id.item9) }
    private val item10: View by lazy { findViewById(R.id.item10) }

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

    private val item6Profile: ImageView by lazy { item6.findViewById(R.id.iv_item_profile) }
    private val item6UserName: TextView by lazy { item6.findViewById(R.id.tv_item_user_name) }
    private val item6Text: TextView by lazy { item6.findViewById(R.id.tv_item_text) }

    private val item7Profile: ImageView by lazy { item7.findViewById(R.id.iv_item_profile) }
    private val item7UserName: TextView by lazy { item7.findViewById(R.id.tv_item_user_name) }
    private val item7Text: TextView by lazy { item7.findViewById(R.id.tv_item_text) }

    private val item8Profile: ImageView by lazy { item8.findViewById(R.id.iv_item_profile) }
    private val item8UserName: TextView by lazy { item8.findViewById(R.id.tv_item_user_name) }
    private val item8Text: TextView by lazy { item8.findViewById(R.id.tv_item_text) }

    private val item9Profile: ImageView by lazy { item9.findViewById(R.id.iv_item_profile) }
    private val item9UserName: TextView by lazy { item9.findViewById(R.id.tv_item_user_name) }
    private val item9Text: TextView by lazy { item9.findViewById(R.id.tv_item_text) }

    private val item10Profile: ImageView by lazy { item10.findViewById(R.id.iv_item_profile) }
    private val item10UserName: TextView by lazy { item10.findViewById(R.id.tv_item_user_name) }
    private val item10Text: TextView by lazy { item10.findViewById(R.id.tv_item_text) }

    private val items
        get() = listOf(
            item1,
            item2,
            item3,
            item4,
            item5,
            item6,
            item7,
            item8,
            item9,
            item10
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
        setContentView(R.layout.activity_recruit)


        initView()
    }


    private fun initView() {
        setNavBtnClickListener()
        setRecruitItemsEvent()
        drawRecruitItems()
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

    private fun setRecruitItemsEvent() {
        items.forEach { item ->
            item.setOnClickListener {
                when (item) {
                    item1 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_bill)
                        intent.putExtra("itemUserName", R.string.home_item1_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_bill_img)
                        intent.putExtra("itemText", R.string.home_item1_text)
                        intent.putExtra("itemProfile", R.drawable.ic_naver)
                        intent.putExtra("itemUserName", R.string.recuit_item1_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_naver_img)
                        intent.putExtra("itemText", R.string.recuit_item1_text)
                        startActivity(intent)
                    }

                    item2 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_bill)
                        intent.putExtra("itemUserName", R.string.home_item2_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_bill_img)
                        intent.putExtra("itemText", R.string.home_item2_text)
                        intent.putExtra("itemProfile", R.drawable.ic_kakao)
                        intent.putExtra("itemUserName", R.string.recuit_item2_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_kakao_img)
                        intent.putExtra("itemText", R.string.recuit_item2_text)
                        startActivity(intent)
                    }

                    item3 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_bill)
                        intent.putExtra("itemUserName", R.string.home_item3_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_bill_img)
                        intent.putExtra("itemText", R.string.home_item3_text)
                        intent.putExtra("itemProfile", R.drawable.ic_toss)
                        intent.putExtra("itemUserName", R.string.recuit_item3_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_toss_img)
                        intent.putExtra("itemText", R.string.recuit_item3_text)
                        startActivity(intent)
                    }

                    item4 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_bill)
                        intent.putExtra("itemUserName", R.string.home_item4_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_bill_img)
                        intent.putExtra("itemText", R.string.home_item4_text)
                        intent.putExtra("itemProfile", R.drawable.ic_brother)
                        intent.putExtra("itemUserName", R.string.recuit_item4_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_brother_img)
                        intent.putExtra("itemText", R.string.recuit_item4_text)
                        startActivity(intent)
                    }

                    item5 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_bill)
                        intent.putExtra("itemUserName", R.string.home_item4_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_bill_img)
                        intent.putExtra("itemText", R.string.home_item4_text)
                        intent.putExtra("itemProfile", R.drawable.ic_threethree)
                        intent.putExtra("itemUserName", R.string.recuit_item5_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_threethree_img)
                        intent.putExtra("itemText", R.string.recuit_item5_text)
                        startActivity(intent)
                    }
                    item6 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_retple)
                        intent.putExtra("itemUserName", R.string.recuit_item6_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_peole)
                        intent.putExtra("itemText", R.string.recuit_item6_text)
                        startActivity(intent)
                    }
                    item7 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_10comu)
                        intent.putExtra("itemUserName", R.string.recuit_item7_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_10comuple)
                        intent.putExtra("itemText", R.string.recuit_item7_text)
                        startActivity(intent)
                    }
                    item8 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_china)
                        intent.putExtra("itemUserName", R.string.recuit_item8_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_people2)
                        intent.putExtra("itemText", R.string.recuit_item8_text)
                        startActivity(intent)
                    }
                    item9 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_cloth)
                        intent.putExtra("itemUserName", R.string.recuit_item9_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_people3)
                        intent.putExtra("itemText", R.string.recuit_item9_text)
                        startActivity(intent)
                    }
                    item10 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Recruit")
                        intent.putExtra("itemProfile", R.drawable.ic_horse)
                        intent.putExtra("itemUserName", R.string.recuit_item10_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_people4)
                        intent.putExtra("itemText", R.string.recuit_item10_text)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun drawRecruitItems() {
        item1Profile.setImageResource(R.drawable.ic_naver)
        item1UserName.text = getString(R.string.recuit_item1_user_name)
        item1Text.text = getString(R.string.recuit_item1_text)

        item2Profile.setImageResource(R.drawable.ic_kakao)
        item2UserName.text = getString(R.string.recuit_item2_user_name)
        item2Text.text = getString(R.string.recuit_item2_text)

        item3Profile.setImageResource(R.drawable.ic_toss)
        item3UserName.text = getString(R.string.recuit_item3_user_name)
        item3Text.text = getString(R.string.recuit_item3_text)

        item4Profile.setImageResource(R.drawable.ic_brother)
        item4UserName.text = getString(R.string.recuit_item4_user_name)
        item4Text.text = getString(R.string.recuit_item4_text)

        item5Profile.setImageResource(R.drawable.ic_threethree)
        item5UserName.text = getString(R.string.recuit_item5_user_name)
        item5Text.text = getString(R.string.recuit_item5_text)

        item6Profile.setImageResource(R.drawable.ic_retple)
        item6UserName.text = getString(R.string.recuit_item6_user_name)
        item6Text.text = getString(R.string.recuit_item6_text)

        item7Profile.setImageResource(R.drawable.ic_10comu)
        item7UserName.text = getString(R.string.recuit_item7_user_name)
        item7Text.text = getString(R.string.recuit_item7_text)

        item8Profile.setImageResource(R.drawable.ic_china)
        item8UserName.text = getString(R.string.recuit_item8_user_name)
        item8Text.text = getString(R.string.recuit_item8_text)

        item9Profile.setImageResource(R.drawable.ic_cloth)
        item9UserName.text = getString(R.string.recuit_item9_user_name)
        item9Text.text = getString(R.string.recuit_item9_text)

        item10Profile.setImageResource(R.drawable.ic_horse)
        item10UserName.text = getString(R.string.recuit_item10_user_name)
        item10Text.text = getString(R.string.recuit_item10_text)
    }
}



