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
}