package edu.estacio.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.estacio.barbearia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByLogin(String login);

}