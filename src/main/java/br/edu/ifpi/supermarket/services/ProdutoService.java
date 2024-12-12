package br.edu.ifpi.supermarket.services;

import br.edu.ifpi.supermarket.models.Produto;
import br.edu.ifpi.supermarket.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public void inserirProduto(Produto produto) {
        produtoRepository.save(produto);

        Produto p = produtoRepository.getReferenceById(1L);

        p.setNome("Feijao");
        produtoRepository.save(p);

    }

    public void listar() {
        //List<Produto> produtos = produtoRepository.findByPrecoDeCustoGreaterThan(BigDecimal.valueOf(10));
        //List<Produto> produtos =produtoRepository.findByDescricaoAndEstoqueGreaterThan("test", 5);

        Produto p1 = produtoRepository.retornarProdutoPorIdComCategoria(1L);

        List<Produto> produtos = produtoRepository.findAll();

        for(Produto p : produtos) {
            System.out.println(p.getPrecoDeCusto());
            System.out.println(p.getCategoria().getNome());
        }
    }
}
