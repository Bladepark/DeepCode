package com.example.deepcode

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.deepcode.member.MemberInfo

class DetailActivity : AnimationActivity(TransitionMode.DOWNTOUP) {

    private val itemProfile: ImageView by lazy { findViewById(R.id.iv_detail_profile) }
    private val itemUserName: TextView by lazy { findViewById(R.id.tv_detail_user_name) }
    private val itemFollowBtn: Button by lazy { findViewById(R.id.btn_detail_follow) }
    private val itemImg: ImageView by lazy { findViewById(R.id.iv_detail_img) }
    private val itemText: TextView by lazy { findViewById(R.id.tv_detail_text) }
    private val backBtn: ImageButton by lazy { findViewById(R.id.btn_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    private fun initView() {
        setDetailView()
        setFollowBtnStatus()
        setBackBtn()
    }

    private fun setDetailView() {
        when (intent.getStringExtra("FromActivity")) {
            "Home" -> {
                itemUserName.text = getString(intent.getIntExtra("itemUserName", 0))
                itemFollowBtn.text = intent.getStringExtra("followBtnStatus")
            }

            "Recruit" -> {
                itemUserName.text = getString(intent.getIntExtra("itemUserName", 0))
                itemFollowBtn.visibility = View.GONE
            }

            "News" -> {
                itemUserName.text = getString(intent.getIntExtra("itemUserName", 0))
                itemFollowBtn.visibility = View.GONE
                itemText.setOnClickListener {
                    setActionView(intent.getStringExtra("url")!!)
                }
            }

            "Profile" -> {
                itemUserName.text = MemberInfo.memberInfo[0].name
            }
        }
        itemProfile.setImageResource(intent.getIntExtra("itemProfile", 0))
        itemImg.setImageResource(intent.getIntExtra("itemImg", 0))
        itemText.text = getString(intent.getIntExtra("itemText", 0))
    }

    private fun setActionView(url: String) {
        val url = url
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    private fun setFollowBtnStatus() {
        itemFollowBtn.setOnClickListener {
            when (itemFollowBtn.text.toString()) {
                "Follow" -> {
                    itemFollowBtn.text = getString(R.string.btn_unfollow_text)
                }

                "Unfollow" -> {
                    itemFollowBtn.text = getString(R.string.btn_follow_text)
                }

                "팔로우" -> {
                    itemFollowBtn.text = getString(R.string.btn_unfollow_text)
                }

                "언팔로우" -> {
                    itemFollowBtn.text = getString(R.string.btn_follow_text)
                }
            }
        }
    }

    private fun setBackBtn() {
        var selectedItemInt = 0
        backBtn.setOnClickListener {
            // 무슨 아이템이 클릭되어서 온건지 확인 후 홈에 알려준다.
            when (intent.getIntExtra("itemUserName", 0)) {
                R.string.home_item1_user_name -> {
                    selectedItemInt = 1
                }

                R.string.home_item2_user_name -> {
                    selectedItemInt = 2
                }

                R.string.home_item3_user_name -> {
                    selectedItemInt = 3
                }

                R.string.home_item4_user_name -> {
                    selectedItemInt = 4
                }

                R.string.home_item5_user_name -> {
                    selectedItemInt = 5
                }
            }
            intent.putExtra("followBtnStatus", itemFollowBtn.text.toString())
            intent.putExtra("selectedItem", selectedItemInt)
            setResult(RESULT_OK, intent)
            if (isFinishing.not()) finish()
        }
    }
}
