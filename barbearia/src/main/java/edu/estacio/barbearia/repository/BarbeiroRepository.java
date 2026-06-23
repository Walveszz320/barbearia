package edu.estacio.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.estacio.barbearia.model.Barbeiro;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {

}
