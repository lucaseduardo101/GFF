package br.com.fiap.gff.domain.useCases.cadastroCliente;

import br.com.fiap.gff.domain.entity.Cliente;
import br.com.fiap.gff.domain.useCases.cadastroCliente.port.ClientePort;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastroClienteUseCase {
    @Autowired
    ClientePort clientePort;

    public Cliente cadastrarCliente(Cliente cliente){
        return clientePort.criar(cliente);
    }

    public Cliente buscarCliente(String cpf){
        return clientePort.buscar(cpf);
    }

    public void deletarCliente(int id) {
        clientePort.deletar(id);
    }

    public void atualizarCliente(Cliente cliente){
        clientePort.atualizar(cliente);
    }
}
