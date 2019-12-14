package com.example.projetologinx.model

import java.util.*

class Usuario (var nome: String, var senha: String){
    override fun equals(other: Any?): Boolean {
        var usuario = other as Usuario

        return Objects.equals(this.nome, usuario.nome) &&
                Objects.equals(this.senha, usuario.senha)
    }

}