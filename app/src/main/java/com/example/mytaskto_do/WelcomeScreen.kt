package com.example.mytaskto_do

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val login = findViewById<Button>(R.id.loginWelcome)
        val cadastro = findViewById<Button>(R.id.cadastroWelcome)

        login.setOnClickListener {
            val intent = Intent (this@WelcomeScreen, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        cadastro.setOnClickListener {
            val intent = Intent (this@WelcomeScreen,CadastroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}