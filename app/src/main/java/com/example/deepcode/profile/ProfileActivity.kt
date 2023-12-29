package com.example.deepcode.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.deepcode.HomeActivity
import com.example.deepcode.NewsActivity
import com.example.deepcode.R
import com.example.deepcode.RecruitActivity
import com.example.deepcode.follow.FollowerActivity
import com.example.deepcode.follow.FollowingActivity
import com.example.deepcode.member.MemberInfo
import com.example.deepcode.member.MemberInfo.memberInfo
import com.example.deepcode.sign.SignInActivity

class ProfileActivity : AppCompatActivity() {

    private val navHomeBtn: ImageView by lazy { findViewById(R.id.btn_home) }
    private val navRecruitBtn: ImageView by lazy { findViewById(R.id.btn_recruit) }
    private val navNewsBtn: ImageView by lazy { findViewById(R.id.btn_news) }
    private val navProfileBtn: ImageView by lazy { findViewById(R.id.btn_profile) }

    private val navBtns
        get() = listOf(
            navHomeBtn,
            navRecruitBtn,
            navNewsBtn,
            navProfileBtn
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val ivProfile = findViewById<ImageView>(R.id.iv_profile)
        val profileId = findViewById<TextView>(R.id.tv_profile_id)
        val profileName = findViewById<TextView>(R.id.tv_profile_name)
        val btnUpdate = findViewById<TextView>(R.id.btn_update)
        val btnLogout = findViewById<Button>(R.id.btn_logout)
        val follower = findViewById<TextView>(R.id.tv_follower)
        val following = findViewById<TextView>(R.id.tv_following)

        // 로그인한 Member의 ID, Name을 가져옴
        val member = MemberInfo.memberInfo[0]
        profileId.text = member.id
        profileName.text = member.name

        // ivProfile 5장중 하나 랜덤
        val profileList = listOf(
            R.drawable.profile1,
            R.drawable.profile2,
            R.drawable.profile3,
            R.drawable.profile4,
            R.drawable.profile5
        )
        ivProfile.setImageResource(profileList.random())


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

        btnUpdate.setOnClickListener {
            val intent = Intent(this, UpdateProfileActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        follower.setOnClickListener {
            val intent = Intent(this, FollowerActivity::class.java)
            startActivity(intent)
        }

        following.setOnClickListener {
            val intent = Intent(this, FollowingActivity::class.java)
            startActivity(intent)
        }
    }
}