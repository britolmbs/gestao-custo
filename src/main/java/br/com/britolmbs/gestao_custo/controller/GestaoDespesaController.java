package br.com.britolmbs.gestao_custo.controller;

import br.com.britolmbs.gestao_custo.custom_messages.ErrorMessage;
import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.useCases.BuscarDespesaUseCase;
import br.com.britolmbs.gestao_custo.useCases.CadastroDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

   @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

   @Autowired
    BuscarDespesaUseCase buscarDespesaUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa) {

        try {
            var result =  cadastroDespesaUseCase.execute(despesa);
            return ResponseEntity.ok(result);
        }catch (IllegalArgumentException e){
            var errorMessage = new ErrorMessage(e.getMessage(), "INVALID_PARAMS");
            return ResponseEntity.status(400).body(errorMessage);
        }

    }

    @GetMapping("/{email}")
    public List<Despesa> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false)LocalDate data) {
    return buscarDespesaUseCase.execute(email, data);
    }
}
