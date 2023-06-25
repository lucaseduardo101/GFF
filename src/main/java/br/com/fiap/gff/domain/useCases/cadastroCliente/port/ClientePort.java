package br.com.fiap.gff.domain.useCases.cadastroCliente.port;

import br.com.fiap.gff.domain.entity.Cliente;

public interface ClientePort {
    Cliente buscar(String cpf);
    Cliente criar(Cliente cliente);
    void deletar(int id);
    void atualizar(Cliente cliente);
}
