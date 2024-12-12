package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.models.Categoria;
import br.edu.ifpi.supermarket.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
public class PaginacaoController {

    private List<Produto> produtos;

    public PaginacaoController() {
        Categoria categoria = new Categoria();
        /*Produto p1 = new Produto(UUID.randomUUID(), "Arroz", "Arroz Branco", new BigDecimal(2.50), 10, categoria, LocalDate.now());
        Produto p2 = new Produto(UUID.randomUUID(), "Feijão", "Feijão Carioca", new BigDecimal(3.50), 5, categoria, LocalDate.now());
        Produto p3 = new Produto(UUID.randomUUID(), "Batata", "Batata Doce", new BigDecimal(1.50), 15, categoria, LocalDate.now());
        Produto p4 = new Produto(UUID.randomUUID(), "Leite", "Leite Integral", new BigDecimal(4.50), 20, categoria, LocalDate.now());
        Produto p5 = new Produto(UUID.randomUUID(), "Ovo", "Ovo Branco", new BigDecimal(5.50), 25, categoria, LocalDate.now());
        Produto p6 = new Produto(UUID.randomUUID(), "Cenoura", "Cenoura", new BigDecimal(1.00), 30, categoria, LocalDate.now());
        Produto p7 = new Produto(UUID.randomUUID(), "Cebola", "Cebola", new BigDecimal(1.00), 35, categoria, LocalDate.now());
        Produto p8 = new Produto(UUID.randomUUID(), "Tomate", "Tomate", new BigDecimal(1.00), 40, categoria, LocalDate.now());
        Produto p9 = new Produto(UUID.randomUUID(), "Cebola Roxa", "Cebola Roxa", new BigDecimal(1.00), 45, categoria, LocalDate.now());
        Produto p10 = new Produto(UUID.randomUUID(), "Alface", "Alface", new BigDecimal(1.00), 50, categoria, LocalDate.now());
        Produto p11 = new Produto(UUID.randomUUID(), "Pimenta", "Pimenta", new BigDecimal(1.00), 55, categoria, LocalDate.now());
        Produto p12 = new Produto(UUID.randomUUID(), "Milho", "Milho", new BigDecimal(1.00), 60, categoria, LocalDate.now());*/
        //produtos = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    @GetMapping("/paginacao")
    public String getPaginacaoPage(Model model) {

        Pageable pagina = PageRequest.of(0, 3);
        Page<Produto> paginaProdutos = paginar(pagina);

        model.addAttribute("produtosPage", paginaProdutos);
        return "exemploPaginacaoHTMX";
    }

    private Page<Produto> paginar(Pageable pageable) {

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Produto> paginaProdutos;

        int index = Math.min(startItem + pageSize, produtos.size());
        paginaProdutos = produtos.subList(startItem, index);
        return new PageImpl<>(paginaProdutos, pageable, produtos.size());
    }

    @GetMapping("/paginacao/load")
    public String loadPage(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size) {

        Pageable pagina = PageRequest.of(page, size);
        Page<Produto> paginaProdutos = paginar(pagina);

        model.addAttribute("produtosPage", paginaProdutos);

        return "fragments/table :: productsDataTable";

    }


}
