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

        et_name.doAfterTextChanged {
            fieldsAndUpdateButtonState(et_name, et_id, et_pw, et_checkpw, btn_sign_up)
            checkValidName(et_name)
        }

        et_id.doAfterTextChanged {
            fieldsAndUpdateButtonState(et_name, et_id, et_pw, et_checkpw, btn_sign_up)
            checkValidId(et_id)
        }


        et_pw.doAfterTextChanged {
            fieldsAndUpdateButtonState(et_name, et_id, et_pw, et_checkpw, btn_sign_up)
            checkValidPw(et_pw)
        }

        et_checkpw.doAfterTextChanged {
            fieldsAndUpdateButtonState(et_name, et_id, et_pw, et_checkpw, btn_sign_up)
        }

        btn_sign_up.setOnClickListener {
            val inputId = et_id.text.toString()
            val inputpw = et_pw.text.toString()
            val inputName = et_name.text.toString()

            if (inputpw != et_checkpw.text.toString()) {
                Toast.makeText(this,getString(R.string.toast_msg_pwerr), Toast.LENGTH_SHORT).show()
            } else {
                val containsSpaces = inputId.contains(" ") || inputpw.contains(" ") || inputName.contains(" ")
                if (containsSpaces) {
                    Toast.makeText(this,getString(R.string.toast_msg_spaceerr), Toast.LENGTH_SHORT).show()
                } else {
                    val newMember = MemberData(
                        id = inputId,
                        pwd = inputpw,
                        name = inputName
                    )
                    MemberInfo.memberInfo.add(newMember)
                    Toast.makeText(this, getString(R.string.toast_msg_signup), Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignInActivity::class.java)
                    intent.putExtra("id", inputId)
                    intent.putExtra("password", inputpw)
                    setResult(RESULT_OK, intent)
                    if (!isFinishing) finish()
                }
            }
        }
    }

    private fun fieldsAndUpdateButtonState(
        et_name: EditText,
        et_id: EditText,
        et_pw: EditText,
        et_checkpw: EditText,
        btn_sign_up: Button
    ) {
        btn_sign_up.isEnabled =
            et_name.text.isNotEmpty() && et_id.text.isNotEmpty() && et_pw.text.isNotEmpty() && et_checkpw.text.isNotEmpty()
    }

    private fun checkValidName(editText: EditText) {
        val namePattern = "^[a-zA-Z가-힣]*$".toRegex()
        if (!namePattern.matches(editText.text.toString())) {
            editText.error = getString(R.string.toast_msg_nameerr)
        }
    }

    private fun checkValidId(editText: EditText) {
        val idPattern = "^[a-zA-Z0-9]*$".toRegex()
        if (!idPattern.matches(editText.text.toString())) {
            editText.error = getString(R.string.toast_msg_id2err)
        }
    }

    private fun checkValidPw(editText: EditText) {
        val passwordPattern = "^[a-zA-Z0-9!@#\$%^&*()-_+=?/]*$".toRegex()
        if (!passwordPattern.matches(editText.text.toString())) {
            editText.error = getString(R.string.toast_msg_pw2err)
        }
    }
}
