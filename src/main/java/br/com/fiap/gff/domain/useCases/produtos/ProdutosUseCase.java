package br.com.fiap.gff.domain.useCases.produtos;

import br.com.fiap.gff.domain.entity.Produto;
import br.com.fiap.gff.domain.useCases.produtos.port.ProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosUseCase {
    @Autowired
    ProdutosPort produtosPort;

    public Produto criarProduto(Produto produto){
        return produtosPort.criar(produto);
    }

    public Produto buscarProduto(int id){
        return produtosPort.buscar(id);
    }

    public void deletarProduto(int id) {
        produtosPort.deletar(id);
    }

    public void atualizarProduto(Produto produto){
        produtosPort.atualizarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtosPort.listarProdutos();
    }
}
