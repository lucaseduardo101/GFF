package br.com.fiap.gff.entrypoint.controller;


import br.com.fiap.gff.domain.entity.Cliente;
import br.com.fiap.gff.domain.entity.Produto;
import br.com.fiap.gff.domain.useCases.produtos.ProdutosUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
    @Autowired
    private ProdutosUseCase produtosUseCase;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> consultarProduto(@PathVariable int id){
        Produto produto = produtosUseCase.buscarProduto(id);
        return ResponseEntity.ok(produto);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produtoNovo){
        Produto produto = produtosUseCase.criarProduto(produtoNovo);
        return ResponseEntity.ok(produto);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listarTodosOsProdutos(){
        List<Produto> produtos = produtosUseCase.listarProdutos();
        return ResponseEntity.ok(produtos); //TODO Adicionar paginacao
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> deletarProduto(@PathVariable int id){
        produtosUseCase.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //Mapeando a rota que será responsável por Editar um Cliente.
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarProduto(@RequestBody Produto produto){
        produtosUseCase.atualizarProduto(produto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
