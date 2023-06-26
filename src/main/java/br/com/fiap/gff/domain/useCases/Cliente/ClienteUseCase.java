package br.com.fiap.gff.domain.useCases.Cliente;

import br.com.fiap.gff.domain.entity.Cliente;
import br.com.fiap.gff.domain.useCases.Cliente.port.ClientePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUseCase {
    @Autowired
    ClientePort clientePort;

    public Cliente cadastrarCliente(Cliente cliente) {
        return clientePort.criar(cliente);
    }

    public Cliente buscarCliente(String cpf) {
        return clientePort.buscar(cpf);
    }


    public void deletarCliente(int id) {
            clientePort.deletar(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clientePort.atualizar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientePort.listarClientes();
    }
}
