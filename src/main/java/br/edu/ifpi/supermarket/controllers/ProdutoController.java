package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.models.Categoria;
import br.edu.ifpi.supermarket.models.Produto;
import br.edu.ifpi.supermarket.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Categoria> categorias;
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
        this.categorias = List.of(
                new Categoria(),
                new Categoria(),
                new Categoria()
        );
    }

    @GetMapping
    public String getPaginaProduto(Model model,
                                   @RequestParam(required = false) UUID id) {

        model.addAttribute("categorias", categorias);
        model.addAttribute("produto", new Produto());
        return "productManagement/produto-cadastro";
    }

    /*@GetMapping("/listar")
    public String getProductsPage(Model model) {
        model.addAttribute("produtos", produtos);
        return "productManagement/produto-listar";
    }*/

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Produto produto) {

        produtoService.inserirProduto(produto);

        return "redirect:/produtos";
    }

    @GetMapping("/test/listar")
    public String listar() {
        produtoService.listar();
        return "listou";
    }

    /*@PutMapping("/editar")
    public String atualizar(@ModelAttribute Produto produto, Model model) {

        produtos.forEach(p -> {
            if (p.getId().equals(produto.getId())) {

                p.setNome(produto.getNome());
                p.setPrecoDeCusto(produto.getPrecoDeCusto());
                p.setEstoque(produto.getEstoque());
                p.setDescricao(produto.getDescricao());
                p.setCategoria(produto.getCategoria());
                p.setDataValidade(produto.getDataValidade());

                Categoria categoria = categorias
                        .stream()
                        .filter(c -> c.getId().equals(produto.getCategoria().getId()))
                        .findFirst()
                        .get();
                p.setCategoria(categoria);
            }
        });

        return "redirect:/produtos/listar";
    }

    @DeleteMapping("/{id}/deletar")
    public String deletar(@PathVariable UUID id) {

        produtos.removeIf(p -> p.getId().equals(id));
        return "redirect:/produtos/listar";
    }*/



}
