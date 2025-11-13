package br.com.britolmbs.gestao_custo.performance;

import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/gestao/performance")
@RestController
public class GestaoDespesaPerfomance {

    @Autowired
    DespesaRepository repository;

    @GetMapping("/sem-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao(){
        long inicio = System.currentTimeMillis();
       var despesas =  repository.findAll();

       long fim = System.currentTimeMillis();

        System.out.println("Tempo (sem paginação): "+ (fim - inicio) + " ms");

       return ResponseEntity.ok(despesas);
    }

}
