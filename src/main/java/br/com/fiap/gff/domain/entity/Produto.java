package br.com.fiap.gff.domain.entity;

import jakarta.persistence.Column;

public class Produto {
    private int id_produto;
    private int estoque;
    private String nome;
    private String descricao;

    public Produto(int id_produto, int estoque, String nome, String descricao) {
        this.id_produto = id_produto;
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
