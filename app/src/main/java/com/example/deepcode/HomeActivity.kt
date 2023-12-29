package com.example.deepcode

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.deepcode.member.MemberInfo
import com.example.deepcode.profile.ProfileActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

// 5조 파이팅!!

class HomeActivity : AppCompatActivity() {

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
    private val item1FollowBtn: Button by lazy { item1.findViewById(R.id.btn_item_follow) }
    private val item1Img: ImageView by lazy { item1.findViewById(R.id.iv_item_img) }
    private val item1Text: TextView by lazy { item1.findViewById(R.id.tv_item_text) }

    private val item2Profile: ImageView by lazy { item2.findViewById(R.id.iv_item_profile) }
    private val item2UserName: TextView by lazy { item2.findViewById(R.id.tv_item_user_name) }
    private val item2FollowBtn: Button by lazy { item2.findViewById(R.id.btn_item_follow) }
    private val item2Img: ImageView by lazy { item2.findViewById(R.id.iv_item_img) }
    private val item2Text: TextView by lazy { item2.findViewById(R.id.tv_item_text) }

    private val item3Profile: ImageView by lazy { item3.findViewById(R.id.iv_item_profile) }
    private val item3UserName: TextView by lazy { item3.findViewById(R.id.tv_item_user_name) }
    private val item3FollowBtn: Button by lazy { item3.findViewById(R.id.btn_item_follow) }
    private val item3Img: ImageView by lazy { item3.findViewById(R.id.iv_item_img) }
    private val item3Text: TextView by lazy { item3.findViewById(R.id.tv_item_text) }

    private val item4Profile: ImageView by lazy { item4.findViewById(R.id.iv_item_profile) }
    private val item4UserName: TextView by lazy { item4.findViewById(R.id.tv_item_user_name) }
    private val item4FollowBtn: Button by lazy { item4.findViewById(R.id.btn_item_follow) }
    private val item4Img: ImageView by lazy { item4.findViewById(R.id.iv_item_img) }
    private val item4Text: TextView by lazy { item4.findViewById(R.id.tv_item_text) }

    private val item5Profile: ImageView by lazy { item5.findViewById(R.id.iv_item_profile) }
    private val item5UserName: TextView by lazy { item5.findViewById(R.id.tv_item_user_name) }
    private val item5FollowBtn: Button by lazy { item5.findViewById(R.id.btn_item_follow) }
    private val item5Img: ImageView by lazy { item5.findViewById(R.id.iv_item_img) }
    private val item5Text: TextView by lazy { item5.findViewById(R.id.tv_item_text) }

    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private val fabHomeAdd: FloatingActionButton by lazy { findViewById(R.id.fab_home_add) }
    private val fabHomeAddFeed: FloatingActionButton by lazy { findViewById(R.id.fab_home_add_feed) }

    private var isFabOpen = false

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

    private val followBtns
        get() = listOf(
            item1FollowBtn,
            item2FollowBtn,
            item3FollowBtn,
            item4FollowBtn,
            item5FollowBtn
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
    }

    private fun initView() {
        setNavBtnClickListener()
        setHomeItemsEvent()
        drawHomeItems()
        setFollowBtnStatus()
        setFABEvent()
        setResultLauncher()
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

    private fun setHomeItemsEvent() {
        items.forEach { item ->
            item.setOnClickListener {
                when (item) {
                    item1 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Home")
                        intent.putExtra("itemProfile", R.drawable.ic_bill)
                        intent.putExtra("itemUserName", R.string.home_item1_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_bill_img)
                        intent.putExtra("itemText", R.string.home_item1_text)
                        intent.putExtra("followBtnStatus", item1FollowBtn.text.toString())
                        resultLauncher.launch(intent)
                    }

                    item2 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Home")
                        intent.putExtra("itemProfile", R.drawable.ic_musk)
                        intent.putExtra("itemUserName", R.string.home_item2_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_musk_img)
                        intent.putExtra("itemText", R.string.home_item2_text)
                        intent.putExtra("followBtnStatus", item2FollowBtn.text.toString())
                        resultLauncher.launch(intent)
                    }

                    item3 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Home")
                        intent.putExtra("itemProfile", R.drawable.ic_mark)
                        intent.putExtra("itemUserName", R.string.home_item3_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_mark_img)
                        intent.putExtra("itemText", R.string.home_item3_text)
                        intent.putExtra("followBtnStatus", item3FollowBtn.text.toString())
                        resultLauncher.launch(intent)
                    }

                    item4 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Home")
                        intent.putExtra("itemProfile", R.drawable.ic_kimyounghan)
                        intent.putExtra("itemUserName", R.string.home_item4_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_kimyounghan_img)
                        intent.putExtra("itemText", R.string.home_item4_text)
                        intent.putExtra("followBtnStatus", item4FollowBtn.text.toString())
                        resultLauncher.launch(intent)
                    }

                    item5 -> {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("FromActivity", "Home")
                        intent.putExtra("itemProfile", R.drawable.ic_kimbeomsu)
                        intent.putExtra("itemUserName", R.string.home_item5_user_name)
                        intent.putExtra("itemImg", R.drawable.ic_kimbeomsu_img)
                        intent.putExtra("itemText", R.string.home_item5_text)
                        intent.putExtra("followBtnStatus", item5FollowBtn.text.toString())
                        resultLauncher.launch(intent)
                    }
                }
            }
        }
    }

    private fun drawHomeItems() {
        item1Profile.setImageResource(R.drawable.ic_bill)
        item1UserName.text = getString(R.string.home_item1_user_name)
        item1Img.setImageResource(R.drawable.ic_bill_img)
        item1Text.text = getString(R.string.home_item1_text)

        item2Profile.setImageResource(R.drawable.ic_musk)
        item2UserName.text = getString(R.string.home_item2_user_name)
        item2Img.setImageResource(R.drawable.ic_musk_img)
        item2Text.text = getString(R.string.home_item2_text)

        item3Profile.setImageResource(R.drawable.ic_mark)
        item3UserName.text = getString(R.string.home_item3_user_name)
        item3Img.setImageResource(R.drawable.ic_mark_img)
        item3Text.text = getString(R.string.home_item3_text)

        item4Profile.setImageResource(R.drawable.ic_kimyounghan)
        item4UserName.text = getString(R.string.home_item4_user_name)
        item4Img.setImageResource(R.drawable.ic_kimyounghan_img)
        item4Text.text = getString(R.string.home_item4_text)

        item5Profile.setImageResource(R.drawable.ic_kimbeomsu)
        item5UserName.text = getString(R.string.home_item5_user_name)
        item5Img.setImageResource(R.drawable.ic_kimbeomsu_img)
        item5Text.text = getString(R.string.home_item5_text)
    }

    private fun setFABEvent() {
        fabHomeAdd.setOnClickListener {
            if (isFabOpen) {
                ObjectAnimator.ofFloat(fabHomeAddFeed, "translationY", 0f).apply { start() }
                ObjectAnimator.ofFloat(fabHomeAdd, View.ROTATION, 45f, 0f).apply { start() }
            } else {
                ObjectAnimator.ofFloat(fabHomeAddFeed, "translationY", -180f).apply { start() }
                ObjectAnimator.ofFloat(fabHomeAdd, View.ROTATION, 0f, 45f).apply { start() }
            }
            isFabOpen = isFabOpen.not()
        }

        fabHomeAddFeed.setOnClickListener {
            Toast.makeText(this, "현재 게시물을 작성하실 수 없습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setResultLauncher() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val followBtnStatus = data?.getStringExtra("followBtnStatus")

                when (data?.getIntExtra("selectedItem", 0)) {
                    1 -> item1FollowBtn.text = followBtnStatus
                    2 -> item2FollowBtn.text = followBtnStatus
                    3 -> item3FollowBtn.text = followBtnStatus
                    4 -> item4FollowBtn.text = followBtnStatus
                    5 -> item5FollowBtn.text = followBtnStatus
                    else -> ""
                }
            }
        }
    }

    private fun setFollowBtnStatus() {
        followBtns.forEach { followBtn ->
            followBtn.setOnClickListener {
                when (followBtn.text.toString()) {
                    "follow" -> {
                        followBtn.text = getString(R.string.btn_unfollow_text)
                    }

                    "unfollow" -> {
                        followBtn.text = getString(R.string.btn_follow_text)
                    }

                    "팔로우" -> {
                        followBtn.text = getString(R.string.btn_unfollow_text)
                    }

                    "언팔로우" -> {
                        followBtn.text = getString(R.string.btn_follow_text)
                    }
                }
            }
        }
    }

}