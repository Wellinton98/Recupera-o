package com.recuperacao.demo.repository;

import com.recuperacao.demo.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

   
    List<Produto> findByNomeContaining(String nome);
}

