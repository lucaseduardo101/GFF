package br.com.fiap.gff.adapter.dataprovider.service;

import br.com.fiap.gff.adapter.dataprovider.entity.ClienteJPA;
import br.com.fiap.gff.adapter.dataprovider.entity.ProdutoJPA;
import br.com.fiap.gff.adapter.dataprovider.repository.ClienteRepository;
import br.com.fiap.gff.domain.entity.Cliente;
import br.com.fiap.gff.domain.useCases.cadastroCliente.port.ClientePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientePortImpl implements ClientePort {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente buscar(String cpf) {
        return null;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        Optional<ClienteJPA> clienteExistente = clienteRepository.findById(cliente.getIdCliente());
        if (clienteExistente.isPresent()){
            System.out.println("Cliente já existente.");
            return null; //TODO criar exception
        }
        ClienteJPA clienteJPA = new ClienteJPA(
                cliente.getIdCliente(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getSenha()
        );
        ClienteJPA novoCliente = clienteRepository.save(clienteJPA);
        return novoCliente.toEntity();
    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public void atualizar(Cliente cliente) {
        //Busca o cliente que será alterado
        Cliente clienteExistente = this.buscar(cliente.getIdCliente());

        clienteExistente.setIdCliente(cliente.getIdCliente());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setSenha(cliente.getSenha());
        clienteExistente.setTelefone(cliente.getTelefone());


        // Salva a alteração no banco de dados
        clienteRepository.save(new ClienteJPA(clienteExistente.getIdCliente(),
                clienteExistente.getNome(),
                clienteExistente.getCpf(),
                clienteExistente.getEmail(),
                clienteExistente.getTelefone(),
                clienteExistente.getSenha())  );
    }

    private Cliente buscar(int id){
        Optional<ClienteJPA> clienteExistente = clienteRepository.findById(id);
        if (!clienteExistente.isPresent()){
            System.out.println("Cliente não encontrado."); //TODO criar uma exception específica
            return null;
        }
        return clienteExistente.get().toEntity();
    }
}