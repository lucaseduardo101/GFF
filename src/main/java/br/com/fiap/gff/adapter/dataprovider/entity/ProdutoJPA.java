package br.com.fiap.gff.adapter.dataprovider.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.io.Serializable;

@Entity
@Table(name = "tb_produto")
public class ProdutoJPA implements Serializable {
    @Column()
    @Id
    private int id_produto;
    @Column()
    private int estoque;
    @Column()
    private String nome;
    @Column()
    private String descricao;

    public br.com.fiap.gff.domain.entity.Produto toEntity(){
        return new br.com.fiap.gff.domain.entity.Produto(
                this.id_produto,
                this.estoque,
                this.nome,
                this.descricao
        );
    }

    public ProdutoJPA(int id_produto, int estoque, String nome, String descricao) {
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


    public ProdutoJPA() {
    }
}
