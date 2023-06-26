package br.com.fiap.gff.adapter.dataprovider.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_produto")
public class ProdutoJPA implements Serializable {
    @Column(name = "id_produto")
    @Id
    private int idProduto;
    @Column()
    private int estoque;
    @Column()
    private String nome;
    @Column()
    private String descricao;



    public br.com.fiap.gff.domain.entity.Produto toEntity(){
        return new br.com.fiap.gff.domain.entity.Produto(
                this.idProduto,
                this.estoque,
                this.nome,
                this.descricao
        );
    }

    public ProdutoJPA(int id_produto, int estoque, String nome, String descricao) {
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


    public ProdutoJPA() {
    }
}
