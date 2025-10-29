package br.com.britolmbs.gestao_custo.controller;

import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.useCases.CadastroDespesaUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

    @PostMapping("/create")
    public void create(Despesa despesa) {
        CadastroDespesaUseCase cadastroDespesaUseCase = new CadastroDespesaUseCase();
        cadastroDespesaUseCase.execute(despesa);
    }
}
