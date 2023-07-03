package br.com.fiap.gff.adapter.dataprovider.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="tb_status_pedido")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StatusPedidoJPA {
    @Column(name="id_status")
    private Integer idStatus;
    @Column(name="descricao")
    private String descricao;
    @OneToOne(mappedBy = "status")
    private PedidoJPA pedido;
}
