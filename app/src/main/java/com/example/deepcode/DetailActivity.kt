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

class DetailActivity : AppCompatActivity() {

    private val itemProfile : ImageView by lazy { findViewById(R.id.iv_detail_profile) }
    private val itemUserName : TextView by lazy { findViewById(R.id.tv_detail_user_name) }
    private val itemFollowBtn : Button by lazy { findViewById(R.id.btn_detail_follow) }
    private val itemImg : ImageView by lazy { findViewById(R.id.iv_detail_img) }
    private val itemText : TextView by lazy { findViewById(R.id.tv_detail_text) }
    private val backBtn : ImageButton by lazy { findViewById(R.id.btn_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    private fun initView() {
        setDetailView()
    }

    private fun setDetailView() {
        when (intent.getStringExtra("FromActivity")) {
            "Recruit" -> {
                itemFollowBtn.visibility = View.GONE
            }
            "News" -> {
                itemFollowBtn.visibility = View.GONE
                itemText.setOnClickListener {
                    setActionView(intent.getStringExtra("url")!!)
                }
            }
        }
        itemProfile.setImageResource(intent.getIntExtra("itemProfile" ,0))
        itemUserName.text = getString(intent.getIntExtra("itemUserName", 0))
        itemImg.setImageResource(intent.getIntExtra("itemImg" ,0))
        itemText.text = getString(intent.getIntExtra("itemText", 0))
        backBtn.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun setActionView(url:String) {
        val url = url
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}