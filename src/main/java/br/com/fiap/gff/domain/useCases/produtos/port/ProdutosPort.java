package br.com.fiap.gff.domain.useCases.produtos.port;

import br.com.fiap.gff.domain.entity.Produto;

public interface ProdutosPort {
    Produto buscar(int id);
    Produto criar(Produto produto);
    void deletar(int id);
}
