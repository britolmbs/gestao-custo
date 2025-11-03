package br.com.britolmbs.gestao_custo.controller;

import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.useCases.CadastroDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

   @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @PostMapping("/create")
    public void create(@RequestBody Despesa despesa) {

        cadastroDespesaUseCase.execute(despesa);
    }
}
