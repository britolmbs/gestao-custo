package br.com.britolmbs.gestao_custo.performance;


import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {

    @Autowired
    DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Despesa> despesas = new ArrayList<>();
        for (int i =0; i < 1000; i++){
            Despesa despesa = new Despesa();
            despesa.setDescricao("Gasto nº: " + i);
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setData(LocalDate.now().minusDays((i % 30)));
            despesa.setCategoria("Teste");
            despesa.setEmail("performance@teste.com");
            despesas.add(despesa);

        }
        despesaRepository.saveAll(despesas);
    }
}
