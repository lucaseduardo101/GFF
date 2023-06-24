package br.com.fiap.gff.adapter.dataprovider.repository;

import br.com.fiap.gff.adapter.dataprovider.entity.ProdutoJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoJPA, Integer> {}