package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.DTOs.UFDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ibge")
public class IBGEController {

    @Value("${ibge.uri.estados}")
    private String estadosUrl;


    @GetMapping
    public String getIBGEPage(Model model) {

        RestClient restClient = RestClient.create();
        List<UFDto> ufs = restClient.get()
                .uri(estadosUrl)
                .retrieve()
                .body(new ParameterizedTypeReference<List<UFDto>>(){});

        model.addAttribute("ufs", ufs);

        return "ibge";
    }

    @GetMapping("/cidades")
    public String carregarCidades(@RequestParam String uf, Model model) {

        model.addAttribute("cidades", List.of());

        return "fragments/lista-de-cidades :: cidades";

    }



}
