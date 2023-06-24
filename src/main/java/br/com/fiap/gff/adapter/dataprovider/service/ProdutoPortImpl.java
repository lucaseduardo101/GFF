package br.com.fiap.gff.adapter.dataprovider.service;

import br.com.fiap.gff.adapter.dataprovider.entity.ProdutoJPA;
import br.com.fiap.gff.adapter.dataprovider.repository.ProdutoRepository;
import br.com.fiap.gff.domain.entity.Produto;
import br.com.fiap.gff.domain.useCases.produtos.port.ProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoPortImpl implements ProdutosPort {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoPortImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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
    public Produto criar(Produto produto) {
        Optional<ProdutoJPA> produtoDb = produtoRepository.findById(produto.getId_produto());
        if (produtoDb.isPresent()){
            System.out.println("Produto já existente.");
            return null; //TODO criar exception
        }
        ProdutoJPA produtoJPA = new ProdutoJPA(
                produto.getId_produto(),
                produto.getEstoque(),
                produto.getNome(),
                produto.getDescricao()
        );
        ProdutoJPA novoProduto = produtoRepository.save(produtoJPA);
        return novoProduto.toEntity();
    }

    @Override
    public void deletar(int id) {
        Produto produto = this.buscar(id);
        produtoRepository.delete(new ProdutoJPA( produto.getId_produto(),
                                                produto.getEstoque(),
                                                produto.getNome(),
                                                produto.getDescricao()));

    }
}
