package br.com.fiap.gff.entrypoint.controller;


import br.com.fiap.gff.domain.entity.Cliente;
import br.com.fiap.gff.domain.useCases.cadastroCliente.CadastroClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
    @Autowired
    private CadastroClienteUseCase clienteUseCase;

    @RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> consultarClientePorCpf(@PathVariable String cpf){
        Cliente cliente = clienteUseCase.buscarCliente(cpf);
        return ResponseEntity.ok(cliente);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente novoCliente){
        Cliente cliente = clienteUseCase.cadastrarCliente(novoCliente);
        return ResponseEntity.ok(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> delete(@PathVariable int id){
        clienteUseCase.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //Mapeando a rota que será responsável por Editar um Cliente.
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarCliente(@RequestBody Cliente cliente){
        clienteUseCase.atualizarCliente(cliente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
