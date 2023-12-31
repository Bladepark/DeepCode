package com.example.deepcode.sign

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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
                Toast.makeText(this,getString(R.string.toast_msg_idpqErr), Toast.LENGTH_SHORT).show()
            } else {
                val memberExist = MemberInfo.memberInfo.any { it.id == inputId && it.pwd == inputPw }
                if(memberExist) {
                    Toast.makeText(this, getString(R.string.toast_login), Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,getString(R.string.toast_msg_signuperr),Toast.LENGTH_SHORT).show()
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



