package com.example.deepcode.sign

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doAfterTextChanged
import com.example.deepcode.HomeActivity
import com.example.deepcode.R
import com.example.deepcode.member.MemberInfo

class SignInActivity : AppCompatActivity() {

    private lateinit var resurtLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setResultSignUp()

        val btn_login = findViewById<Button>(R.id.btnLogin)
        val btn_signUp = findViewById<Button>(R.id.btnSignUp)
        val et_id = findViewById<EditText>(R.id.etSignUpId)
        val et_pw = findViewById<EditText>(R.id.etSignUpPw)

        btn_login.isEnabled =false
        et_id.doAfterTextChanged {
            btn_login.isEnabled = et_id.text.isNotEmpty() && et_pw.text.isNotEmpty()
        }

        et_pw.doAfterTextChanged {
            btn_login.isEnabled = et_id.text.isNotEmpty() && et_pw.text.isNotEmpty()
        }

        btn_login.setOnClickListener {
            val inputId = et_id.text.toString()
            val inputPw = et_pw.text.toString()
            if (et_id.text.isEmpty() || et_pw.text.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val memberExist = MemberInfo.memberInfo.any { it.id == inputId && it.pwd == inputPw }
                if(memberExist) {
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("memberId", inputId)
                    intent.putExtra("memberPw", inputPw)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"아이디/비밀번호가 일치하지 않습니다. 회원이 아니시라면 회원가입을 먼저 해주세요",Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resurtLauncher.launch(intent)
        }
    }

    private fun setResultSignUp() {
        resurtLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val inputId = data?.getStringExtra("id")
                val inputPw = data?.getStringExtra("password")
                val getId = findViewById<EditText>(R.id.etSignUpId)
                getId.setText(inputId)
                val getPw = findViewById<EditText>(R.id.etSignUpPw)
                getPw.setText(inputPw)
            }
        }
    }
}



