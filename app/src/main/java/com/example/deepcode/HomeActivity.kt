package com.example.deepcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout

// 5조 파이팅!!

class HomeActivity : AppCompatActivity() {

    private val item1 : ConstraintLayout by lazy { findViewById(R.id.item1) }
    private val item2 : ConstraintLayout by lazy { findViewById(R.id.item2) }
    private val item3 : ConstraintLayout by lazy { findViewById(R.id.item3) }
    private val item4 : ConstraintLayout by lazy { findViewById(R.id.item4) }
    private val item5 : ConstraintLayout by lazy { findViewById(R.id.item5) }

    private val navHomeBtn : ImageView by lazy { findViewById(R.id.btn_home) }
    private val navRecruitBtn : ImageView by lazy { findViewById(R.id.btn_recruit) }
    private val navNewsBtn : ImageView by lazy { findViewById(R.id.btn_news) }
    private val navProfileBtn : ImageView by lazy { findViewById(R.id.btn_profile) }

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
        setContentView(R.layout.activity_home)

        initView()
    }
    private fun initView() {
        setNavBtnClickListener()
        setDetailActivity()
    }


    private fun setNavBtnClickListener() {
        navBtns.forEach { navBtn ->
            navBtn.setOnClickListener {
                when(navBtn) {
                    navHomeBtn -> startActivity(Intent(this, HomeActivity::class.java))
                    navRecruitBtn -> startActivity(Intent(this, RecruitActivity::class.java))
                    navNewsBtn -> startActivity(Intent(this, NewsActivity::class.java))
                    navProfileBtn -> startActivity(Intent(this, ProfileActivity::class.java))
                }
            }
        }
    }

    private fun setDetailActivity() {
        items.forEach { item ->
            item.setOnClickListener {
                when(item) {
                    item1 -> {

                    }
                    item2 -> {

                    }
                    item3 -> {

                    }
                    item4 -> {

                    }
                    item5 -> {

                    }
                }
            }
        }
    }
}