package com.recuperacao.demo.controller;

import com.recuperacao.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/cadastro")
    public String cadastroProduto() {
        return "produto/cadastro";
    }
    

    @GetMapping("/")
    public String listarProdutos(
            Model model,
            @RequestParam(name = "filtro", required = false, defaultValue = "") String filtro) {

        var produtos = produtoRepository.findByNomeContaining(filtro);
        int totalProdutos = produtos.size();

        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("filtro", filtro);
        model.addAttribute("produtos", produtos);

        return "index";
    }

    @GetMapping("/novo")
    public String novoProduto() {
        return "produto/novo";
    }

    @GetMapping("/nome")
    public String buscarPorNome(
            Model model,
            @RequestParam(name = "nome", required = false, defaultValue = "") String nome) {

        var produtos = produtoRepository.findByNomeContaining(nome);
        int totalProdutos = produtos.size();

        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("nome", nome);
        model.addAttribute("produtos", produtos);

        return "index";
    }

    @GetMapping("/preco")
    public String buscarPorPreco(
            Model model,
            @RequestParam(name = "preco", required = false, defaultValue = "0") double preco) {

        var produtos = produtoRepository.findByPrecoLessThanEqual(preco);

        int totalProdutos = produtos.size();

        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("preco", preco);
        model.addAttribute("produtos", produtos);

        return "index";
    }

    @GetMapping("/descricao")
    public String buscarPorDescricao(
            Model model,
            @RequestParam(name = "descricao", required = false, defaultValue = "") String descricao) {

        var produtos = produtoRepository.findByDescricaoContaining(descricao);
                

        int totalProdutos = produtos.size();

        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("descricao", descricao);
        model.addAttribute("produtos", produtos);

        return "index";
    }

    @GetMapping("/categoria")
    public String buscarPorCategoria(
            Model model,
            @RequestParam(name = "categoria", required = false, defaultValue = "") String categoria) {

        var produtos = produtoRepository.findByCategoriaContaining(categoria);

        int totalProdutos = produtos.size();

        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("categoria", categoria);
        model.addAttribute("produtos", produtos);

        return "index";
    }

}
