package com.example.deepcode.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.deepcode.R

class UpdateProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        val etId = findViewById<EditText>(R.id.et_update_id)
        val etName = findViewById<EditText>(R.id.et_update_name)
        val btnUpdate = findViewById<Button>(R.id.btn_update)

        btnUpdate.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}