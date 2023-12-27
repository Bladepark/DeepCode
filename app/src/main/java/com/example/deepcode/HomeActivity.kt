package com.example.deepcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

// 5조 파이팅!!

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recruit = findViewById<ImageView>(R.id.btn_recruit)

        recruit.setOnClickListener {
            val intent = Intent(this, RecruitActivity::class.java)
            startActivity(intent)
        }
    }
}