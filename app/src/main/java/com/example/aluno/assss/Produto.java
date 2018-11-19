package com.example.aluno.assss;

import com.orm.SugarRecord;

/**
 * Created by aluno on 05/11/18.
 */

public class Produto extends SugarRecord {
    private String nome;
    private double preco;
    private int estoque;


    public Produto() {

    }

  /*  @Override
    public String toString(){
    return ("nome: " + getNome() +"Valor: " + getPreco());
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

