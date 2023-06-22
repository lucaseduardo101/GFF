package br.com.fiap.gff.adapter.service;

import br.com.fiap.gff.adapter.repository.ProdutoRepository;
import br.com.fiap.gff.adapter.entity.ProdutoJPA;
import br.com.fiap.gff.domain.entity.Produto;
import br.com.fiap.gff.domain.useCases.produtos.port.ProdutosPort;

import java.util.Optional;

public class ProdutoPortImplement implements ProdutosPort {

    private ProdutoRepository produtoRepository;
    @Override
    public Produto buscar(int id) {
        Optional<ProdutoJPA> produtoDb = produtoRepository.findById(id);
        if (!produtoDb.isPresent()){
            System.out.println("Produto não encontrado."); //TODO criar uma exception específica
            return null;
        }
        return produtoDb.get().toEntity();
    }

    @Override
    public Boolean criar(Produto produto) {
        Optional<ProdutoJPA> produtoDb = produtoRepository.findById(produto.getId_produto());
        if (produtoDb.isPresent()){
            System.out.println("Produto já existente.");
            return true;
        }
        ProdutoJPA produtoJPA = new ProdutoJPA(
                produto.getId_produto(),
                produto.getEstoque(),
                produto.getNome(),
                produto.getDescricao()
        );
        Optional<ProdutoJPA> novoProduto = produtoRepository.save(produtoJPA);
    }

    @Override
    public Boolean deletar(int id) {
        return null;
    }
}
