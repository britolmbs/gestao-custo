package br.com.britolmbs.gestao_custo.performance;

import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/com-paginacao")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(Pageable pageable){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = repository.findAll(pageable);
        stopWatch.stop();


        System.out.println("Tempo (com Paginação): " + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/com-paginacao/{email}")
    public ResponseEntity<Page<Despesa>> listarPaginacaoEmail(@PathVariable String email, Pageable pageable){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = repository.findByEmail(email, pageable);
        stopWatch.stop();

        System.out.println("Tempo (Com Paginação e Email): " + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(despesas);
    }

}
