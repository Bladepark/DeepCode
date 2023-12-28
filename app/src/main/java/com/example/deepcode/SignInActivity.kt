package com.example.deepcode

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setResultSignUp()

        val btn_login = findViewById<Button>(R.id.btnLogin)
        val btn_signUp = findViewById<Button>(R.id.btnSignUp)
        val et_id = findViewById<EditText>(R.id.etSignUpId)
        val et_pw = findViewById<EditText>(R.id.etSignUpPw)

        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("name", "value")
        intent.putExtra("id", "value")


        btn_login.setOnClickListener {
            if (et_id.text.toString().trim().isEmpty() || et_pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resurtLauncher.launch(intent)
        }
    }

    private lateinit var resurtLauncher: ActivityResultLauncher<Intent>

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



