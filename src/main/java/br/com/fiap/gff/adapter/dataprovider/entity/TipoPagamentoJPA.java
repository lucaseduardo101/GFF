package br.com.fiap.gff.adapter.dataprovider.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tb_tipo_pagamento")
public class TipoPagamentoJPA {
    @Id
    @Column(name="id_tipo_pagamento")
    private Integer tipoPagamentoId;
    @Column(name="descricao")
    private String descricao;
    @OneToOne(mappedBy = "tipoPagamento")
    private PedidoJPA pedido;
}
