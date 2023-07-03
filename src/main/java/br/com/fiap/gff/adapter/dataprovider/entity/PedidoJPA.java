package br.com.fiap.gff.adapter.dataprovider.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="tb_pedido")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PedidoJPA {
    @Id
    @Column(name="id_pedido")
    private Integer pedidoId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    private ClienteJPA cliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_status", referencedColumnName = "id_status")
    private StatusPedidoJPA status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_tipo_pagamento", referencedColumnName = "id_tipo_pagamento")
    private TipoPagamentoJPA tipoPagamento;
    private Date dataPedido;
}
