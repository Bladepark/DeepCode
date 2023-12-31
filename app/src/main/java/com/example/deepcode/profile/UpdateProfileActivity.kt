package com.example.deepcode.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.deepcode.R
import com.example.deepcode.member.MemberInfo

class UpdateProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        val etId = findViewById<EditText>(R.id.et_update_id)
        val etName = findViewById<EditText>(R.id.et_update_name)
        val btnUpdate = findViewById<Button>(R.id.btn_update)

        // back 버튼 누르면 돌아가기
        val btnBack = findViewById<ImageButton>(R.id.btn_back)

        // etId, etName에 로그인한 Member의 정보를 가져옴
        val member = MemberInfo.memberInfo
        etId.setText(member[0].id)
        etName.setText(member[0].name)


        // Update 버튼 클릭 시 MemberInfo.memberInfo에 업데이트
        btnUpdate.setOnClickListener {
            val id = etId.text.toString()
            val name = etName.text.toString()
            MemberInfo.memberInfo[0].id = id
            MemberInfo.memberInfo[0].name = name
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        // back 버튼 클릭 시 ProfileActivity로 돌아감
        btnBack.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}