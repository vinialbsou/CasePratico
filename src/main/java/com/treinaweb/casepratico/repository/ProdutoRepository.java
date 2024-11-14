package com.seuempresa.nomedoprojeto.repository;

import com.seuempresa.nomedoprojeto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);

    List<Produto> findByPrecoGreaterThan(Double preco);

    List<Produto> findByDescricaoContaining(String keyword);

    List<Produto> findAllByOrderByNomeAsc();
}
