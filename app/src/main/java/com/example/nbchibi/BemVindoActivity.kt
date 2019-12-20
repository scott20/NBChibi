package com.example.nbchibi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.LogWriter
import com.example.nbchibi.dapter.ProdutoAdapter
import com.example.nbchibi.model.Produto

class BemVindoActivity : AppCompatActivity() {

    var listaProdutos = ArrayList<Produto>()
    private val REQ_CADASTRO = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bem_vindo)


        iniciaListaProdutos()

        var usuario = intent.getStringExtra("usuario")

        var textoBemVindo: TextView = findViewById(R.id.textoBemVindo)
        textoBemVindo.text = "Bem vindo, "+usuario

        var listView: ListView = findViewById(R.id.listViewProdutos)
        listView.setAdapter(ProdutoAdapter(this,listaProdutos))
    }

    fun voltar(view: View){
        setResult(Activity.RESULT_CANCELED)
        finish()
    }


    private fun iniciaListaProdutos(){
        listaProdutos.add(Produto("img1", "Promocão chibi",50.0))
        listaProdutos.add(Produto("img2", "Combos 1 e 2",100.00))
        listaProdutos.add(Produto("img3", "Completo ou kit",0.0))
    }

    fun abrirFormulario(view: View) {
        val it = Intent(this, CadastroActivity::class.java)
        startActivityForResult(it, REQ_CADASTRO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CADASTRO) {
            if (resultCode == Activity.RESULT_OK) {
                val produto = data?.getSerializableExtra("produto") as Produto
                listaProdutos.add(produto)
                 LogWriter("sucesso")
            }
        }

    }
}
