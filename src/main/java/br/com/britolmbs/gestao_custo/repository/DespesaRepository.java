package br.com.britolmbs.gestao_custo.repository;

import br.com.britolmbs.gestao_custo.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DespesaRepository extends JpaRepository<Despesa, UUID> {
}
