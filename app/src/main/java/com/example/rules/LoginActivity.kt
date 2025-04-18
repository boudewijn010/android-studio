package com.example.rules

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val link = findViewById<TextView>(R.id.tvLinktoregister). setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        findViewById<Button>(R.id.btLogin).setOnClickListener {
            val naamveld = findViewById<EditText>(R.id.etLoginUsername)
            val passwordveld = findViewById<EditText>(R.id.etloginPassword)

            if (naamveld.text.isNotEmpty() && passwordveld.text.isNotEmpty()) {
                Log.d("Route", naamveld.text.toString())
                Log.d("Route", passwordveld.text.toString().sha256Hash())
            }

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}