package br.projeto.api.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.api.springapi.entity.Agendamento;


@Repository
	public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

    
}


