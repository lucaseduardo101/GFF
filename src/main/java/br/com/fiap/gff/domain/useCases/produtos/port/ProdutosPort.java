package br.com.fiap.gff.domain.useCases.produtos.port;

import br.com.fiap.gff.domain.entity.Produto;

public interface ProdutosPort {
    Produto buscar(int id);
    Boolean criar(Produto produto);
    Boolean deletar(int id);
}
