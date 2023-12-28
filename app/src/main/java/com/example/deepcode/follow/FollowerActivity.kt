package com.example.deepcode.follow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.example.deepcode.R

class FollowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower)

        val followerList = mutableListOf("추정호", "김우진", "이가현", "박정현", "문해린", "정현우", "오성원", "최성진", "유영국", "김건두", "유정목", "정민수", "최성현", "최영정", "송동철")
        val layout = findViewById<LinearLayout>(R.id.ll_follower)

        for (follower in followerList) {
            val followerView = TextView(this)
            followerView.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            followerView.text = follower
            followerView.textSize = 16f

            val unfollowButton = Button(this)
            unfollowButton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            unfollowButton.text = "delete"
            unfollowButton.setOnClickListener {
                layout.removeView(it.parent as View)
            }

            val followerLayout = LinearLayout(this)
            followerLayout.orientation = LinearLayout.HORIZONTAL
            followerLayout.addView(followerView)
            followerLayout.addView(unfollowButton)

            layout.addView(followerLayout)
        }
    }
}