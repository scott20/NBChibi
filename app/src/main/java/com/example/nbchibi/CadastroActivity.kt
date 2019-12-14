package com.example.nbchibi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.nbchibi.model.Produto



class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun cadastrarProduto(view: View?) {
        val textoDescCadastro = findViewById(R.id.textoDescCadastro) as EditText
        val textoNomeCadastro = findViewById(R.id.textoNomeCadastro) as EditText
        val textoPrecoCadastro = findViewById(R.id.textoPrecoCadastro) as EditText
        val desc = textoDescCadastro.text.toString()
        val nome = textoNomeCadastro.text.toString()
        val preco = textoPrecoCadastro.text.toString().toDouble()
        val produto = Produto(nome,desc,preco)
        val it = Intent().apply {
            putExtra("produto", produto)
        }
        setResult(Activity.RESULT_OK, it)

        finish()
    }

    fun cancelarCadastro(view: View?) {
        finish()
    }
}
