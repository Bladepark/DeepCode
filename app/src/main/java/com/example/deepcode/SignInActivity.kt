package com.example.deepcode

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

        setResultSignup()

        val login = findViewById<Button>(R.id.btnSignIn)
        val join = findViewById<Button>(R.id.btnSignUp)
        val editId = findViewById<EditText>(R.id.etSignUpId)
        val editPw = findViewById<EditText>(R.id.etSignUpPw)

        login.setOnClickListener {
            val inputId = editId.text.toString()
            val inputPw = editPw.text.toString()
            if (inputId.isEmpty() || inputPw.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인성공", Toast.LENGTH_SHORT).show()
                val intent =Intent(this, HomeActivity::class.java)

            }
        }

        join.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resurtLaucher.launch(intent)
        }

    }
    private lateinit var resurtLaucher:ActivityResultLauncher<Intent>

    private fun  setResultSignup() {
        resurtLaucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
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

