package com.example.nbchibi.dapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.nbchibi.R
import com.example.nbchibi.model.Produto

class ProdutoAdapter(var contexto: Context, var listaProdutos: ArrayList<Produto>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.item_produto,
            parent, false);

        var textViewNome: TextView = view.findViewById(R.id.textoNome)
        var textViewDesc: TextView = view.findViewById(R.id.textoDesc)
        var textViewPreco: TextView = view.findViewById(R.id.textoPreco)

        var produto = listaProdutos.get(position)

        textViewNome.text = produto.nome
        textViewDesc.text = produto.desc
        textViewPreco.text = produto.preco.toString()

        return view;
    }

    override fun getItem(position: Int): Any {
        return listaProdutos.get(position)
    }

    override fun getItemId(position: Int): Long {
        return (position.toLong())
    }

    override fun getCount(): Int {
        return listaProdutos.size
    }

}