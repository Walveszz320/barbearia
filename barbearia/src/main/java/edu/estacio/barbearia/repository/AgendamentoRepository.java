package edu.estacio.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.estacio.barbearia.model.Agendamento;

public interface AgendamentoRepository
        extends JpaRepository<Agendamento, Long> {

}