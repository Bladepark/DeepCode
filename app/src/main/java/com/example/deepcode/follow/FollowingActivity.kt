package com.example.deepcode.follow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.deepcode.R

class FollowingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following)

        // FollowData 클래스에서 followingList를 가져옴
        val layout = findViewById<LinearLayout>(R.id.ll_following)
        val density = resources.displayMetrics.density
        val marginDp = 32
        val marginPx = (marginDp * density).toInt()

        // back 버튼 누르면 돌아가기
        val btnBack = findViewById<ImageButton>(R.id.btn_back)

        // followingList가 비어있다면 예비 리스트 출력
        val followingList: MutableSet<String> = if (FollowInfo.followInfo.isNotEmpty()) {
            FollowInfo.followInfo[1].followerList
        } else {
            // handle the case when followInfo list is empty
            mutableSetOf("추정호", "김우진", "이가현", "박정현", "문해린", "정현우", "오성원", "최성진", "유영국", "김건두", "유정목", "정민수", "최성현", "최영정", "송동철")
        }


        for (follower in followingList) {
            val followerView = TextView(this)
            val followerViewParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            followerViewParams.setMargins(marginPx, marginPx, marginPx, marginPx)
            followerView.layoutParams = followerViewParams
            followerView.text = follower
            followerView.textSize = 16f

            val unfollowButton = Button(this)
            val unfollowButtonParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            unfollowButtonParams.setMargins(marginPx, marginPx, marginPx, marginPx)
            unfollowButton.layoutParams = unfollowButtonParams
            unfollowButton.text = getString(R.string.following_unfollow)
            unfollowButton.setOnClickListener {
                layout.removeView(it.parent as View)
            }

            val followerLayout = LinearLayout(this)
            followerLayout.orientation = LinearLayout.HORIZONTAL
            followerLayout.addView(followerView)
            followerLayout.addView(unfollowButton)

            layout.addView(followerLayout)
        }

        // back 버튼 누르면 돌아가기
        btnBack.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}