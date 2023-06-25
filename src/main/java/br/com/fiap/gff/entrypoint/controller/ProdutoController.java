package br.com.fiap.gff.entrypoint.controller;


import br.com.fiap.gff.domain.entity.Produto;
import br.com.fiap.gff.domain.useCases.produtos.ProdutosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
    @Autowired
    private ProdutosUseCase produtosUseCase;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> get(@PathVariable int id){
        Produto produto = produtosUseCase.buscarProduto(id);
        return ResponseEntity.ok(produto);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Produto> post(@RequestBody Produto produtoNovo){
        Produto produto = produtosUseCase.criarProduto(produtoNovo);
        return ResponseEntity.ok(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> delete(@PathVariable int id){
        produtosUseCase.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
