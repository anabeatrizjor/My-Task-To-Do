package com.example.mytaskto_do

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {

    data class Users (val email : String , val senha : String)

    private lateinit var emailInput : EditText
    private lateinit var senhaInput : EditText
    private lateinit var cadastroBtn : Button
    private lateinit var loginBtn : Button
    private lateinit var backArrow : ImageView

    companion object {
        private val users = mutableListOf<Users>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        emailInput = findViewById(R.id.emailInputCadastro)
        senhaInput = findViewById(R.id.senhaInputCadastro)
        cadastroBtn = findViewById(R.id.cadastroBtnCadastro)
        loginBtn = findViewById(R.id.loginBtnCadastro)
        backArrow = findViewById(R.id.backArrowCadastro)

        backArrow.setOnClickListener {
            val intent = Intent (this@CadastroActivity, WelcomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        loginBtn.setOnClickListener {
            val intent = Intent (this@CadastroActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        cadastroBtn.setOnClickListener {
           cadastrarConta()
        }

    }
    private fun cadastrarConta () {

        val senha = senhaInput.text.toString()

        val senhaRegex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#\$%¨&*/?°[{]}().,_;:]).{6,}\$")

        if (!senhaRegex.matches(senha)) {
            exibirDialogo("A senha deve ter pelo menos 6 caracteres, com pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial")
            return
        }

        val email = emailInput.text.toString()

        val newUser = Users(email, senha)

        users.add(newUser)

        Toast.makeText(this@CadastroActivity, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()
        val intent = Intent (this@CadastroActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
    private fun exibirDialogo (mensagem: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(mensagem)
            .setCancelable(false)
            .setPositiveButton("OK") { dialog , _ ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }
}