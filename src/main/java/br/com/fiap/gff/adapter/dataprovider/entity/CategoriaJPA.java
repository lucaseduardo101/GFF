package br.com.fiap.gff.adapter.dataprovider.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name="tb_categoria")
public class CategoriaJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    int idCategoria;
    String descricao;

    @OneToMany(mappedBy = "tb_categoria", cascade = CascadeType.ALL)
    List<ProdutoJPA> produto;

}
