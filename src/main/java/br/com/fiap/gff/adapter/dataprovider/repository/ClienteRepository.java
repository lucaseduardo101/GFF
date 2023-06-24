package br.com.fiap.gff.adapter.dataprovider.repository;

import br.com.fiap.gff.adapter.dataprovider.entity.ClienteJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteJPA,Integer> {
    //Assinatura do método que retorna um cliente pelo cpf informado
    Optional<ClienteJPA> findOptionalByCpf(String cpf);
}
