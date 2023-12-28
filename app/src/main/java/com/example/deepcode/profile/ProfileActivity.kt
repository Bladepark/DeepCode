package com.example.deepcode.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.deepcode.R
import com.example.deepcode.follow.FollowerActivity
import com.example.deepcode.follow.FollowingActivity
import com.example.deepcode.sign.SignInActivity

class ProfileActivity : AppCompatActivity() {
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

        profileId.text = "myPark"
        profileName.text = "박민영"

        // ivProfile 5장중 하나 랜덤
        val profileList = listOf(
            R.drawable.profile1,
            R.drawable.profile2,
            R.drawable.profile3,
            R.drawable.profile4,
            R.drawable.profile5
        )
        ivProfile.setImageResource(profileList.random())

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