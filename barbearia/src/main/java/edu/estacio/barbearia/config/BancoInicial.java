package edu.estacio.barbearia.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.estacio.barbearia.model.Usuario;
import edu.estacio.barbearia.repository.UsuarioRepository;

@Configuration
public class BancoInicial {

    @Bean
    CommandLineRunner carregarBanco(UsuarioRepository repository) {

        return args -> {

            if(repository.count() == 0) {

                repository.save(new Usuario(
                        "Guilherme",
                        "guilherme",
                        "senha01"));

                repository.save(new Usuario(
                        "Carlos",
                        "carlos",
                        "senha02"));

                repository.save(new Usuario(
                        "João",
                        "joao",
                        "senha03"));
            }

        };

    }

}