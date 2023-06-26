package br.com.fiap.gff.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {
    @JsonProperty("id_produto")
    private int idProduto;
    private int estoque;
    private String nome;
    private String descricao;

    public Produto() {
    }

    public Produto(int id_produto, int estoque, String nome, String descricao) {
        this.idProduto = id_produto;
        this.estoque = estoque;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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
