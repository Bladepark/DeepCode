package com.example.deepcode.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.deepcode.R
import com.example.deepcode.member.MemberData
import com.example.deepcode.member.MemberInfo

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val et_name = findViewById<EditText>(R.id.etSignUpName)
        val et_id = findViewById<EditText>(R.id.etSignUpId)
        val et_pw = findViewById<EditText>(R.id.etSignUpPw)
        val et_checkpw = findViewById<EditText>(R.id.etSignUpPwConfirm)
        val btn_sign_up = findViewById<Button>(R.id.btnSignUp)

        btn_sign_up.isEnabled = false
        et_id.doAfterTextChanged {
            btn_sign_up.isEnabled =
                et_name.text.isNotEmpty() && et_id.text.isNotEmpty() && et_pw.text.isNotEmpty() && et_checkpw.text.isNotEmpty()
            val inputid = et_id.text.toString()
            if (!inputid.matches("^[a-z0-9_.-]*\$".toRegex())) {
                Toast.makeText(this, "아이디 형식이 올바르지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }

        et_pw.doAfterTextChanged {
            btn_sign_up.isEnabled =
                et_name.text.isNotEmpty() && et_id.text.isNotEmpty() && et_pw.text.isNotEmpty() && et_checkpw.text.isNotEmpty()
            val inputpw = et_pw.text.toString()
            if (!inputpw.matches("^[a-zA-Z0-9_.-]*\$".toRegex())) {
                Toast.makeText(this, "비밀번호 형식이 올바르지 않거나 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            } else {
                btn_sign_up.isEnabled = true
            }
        }


        et_checkpw.doAfterTextChanged {
            val inputpw = et_pw.text.toString()
            val checkpw = et_checkpw.text.toString()
            if (inputpw != checkpw) {
                Toast.makeText(this,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show()
                btn_sign_up.isEnabled = false
            }else {
                btn_sign_up.isEnabled = true
            }
        }

        btn_sign_up.setOnClickListener {
            val inputId =et_id.text.toString()
            val inputpw =et_pw.text.toString()


            val newMember = MemberData(
                id = inputId,
                pwd = inputpw,
                name = et_name.text.toString()
            )
            MemberInfo.memberInfo.add(newMember)
            Toast.makeText(this,"가입완료! 로그인 후 이용가능", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("id", inputId)
            intent.putExtra("password", inputpw)
            setResult(RESULT_OK, intent)
            if (!isFinishing) finish()
        }
    }
}
