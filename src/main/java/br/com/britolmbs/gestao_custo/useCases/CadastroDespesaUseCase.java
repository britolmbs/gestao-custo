package br.com.britolmbs.gestao_custo.useCases;

import br.com.britolmbs.gestao_custo.entity.Despesa;
import br.com.britolmbs.gestao_custo.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDespesaUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa execute(Despesa despesa){
        if (despesa.getCategoria() == null || despesa.getData() == null || despesa.getDescricao() == null || despesa.getEmail() == null) {
            throw new IllegalArgumentException("Preencher todos os campos");
        }
        despesaRepository.save(despesa);
       return despesa;
    }
}
