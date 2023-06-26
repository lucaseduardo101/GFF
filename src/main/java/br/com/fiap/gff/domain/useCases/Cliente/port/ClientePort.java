package br.com.fiap.gff.domain.useCases.Cliente.port;

import br.com.fiap.gff.domain.entity.Cliente;

import java.util.List;

public interface ClientePort {
    Cliente buscar(String cpf);
    Cliente criar(Cliente cliente);
    void deletar(int id);
    void atualizar(Cliente cliente);

    List<Cliente> listarClientes();
}
