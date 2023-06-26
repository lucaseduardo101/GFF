package br.com.fiap.gff.adapter.dataprovider.service;

import br.com.fiap.gff.adapter.dataprovider.entity.ProdutoJPA;
import br.com.fiap.gff.adapter.dataprovider.repository.ProdutoRepository;
import br.com.fiap.gff.domain.entity.Produto;
import br.com.fiap.gff.domain.exception.RecursoJaExisteException;
import br.com.fiap.gff.domain.exception.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.useCases.produtos.port.ProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
            throw new RecursoNaoEncontradoException("Produto nao encontrado");
        }
        return produtoDb.get().toEntity();
    }

    @Override
    public Produto criar(Produto produto) {
        Optional<ProdutoJPA> produtoDb = produtoRepository.findById(produto.getIdProduto());
        if (produtoDb.isPresent()){
            throw new RecursoJaExisteException("Produto já cadastrado");
        }
        ProdutoJPA produtoJPA = new ProdutoJPA(
                produto.getIdProduto(),
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
        produtoRepository.delete(new ProdutoJPA( produto.getIdProduto(),
                                                produto.getEstoque(),
                                                produto.getNome(),
                                                produto.getDescricao()));

    }

    @Override
    public void atualizarProduto(Produto produto) {
        //Busca o produto que será alterado
        Produto produtoExistente = this.buscar(produto.getIdProduto());

        produtoExistente = produto;

        // Salva a alteração no banco de dados
        produtoRepository.save(new ProdutoJPA(produtoExistente.getIdProduto(),
                produtoExistente.getEstoque(),
                produtoExistente.getNome(),
                produtoExistente.getDescricao()));
    }

    @Override
    public List<Produto> listarProdutos() {
        List<ProdutoJPA> produtosJpa = produtoRepository.findAll();

        return convertListJpaToList(produtosJpa);
    }

    private List<Produto> convertListJpaToList(List<ProdutoJPA> produtosJpa ){
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        for(ProdutoJPA produtoJpa: produtosJpa){
            produtos.add(produtoJpa.toEntity());
        }
        return produtos;
    }



}
