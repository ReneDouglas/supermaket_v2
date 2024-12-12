package br.edu.ifpi.supermarket.repositories;

import br.edu.ifpi.supermarket.models.Produto;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query("""
        SELECT p FROM Produto p
        LEFT JOIN FETCH p.categoria c
        WHERE p.id = :id
    """)
    Produto retornarProdutoPorIdComCategoria(Long id);

}
