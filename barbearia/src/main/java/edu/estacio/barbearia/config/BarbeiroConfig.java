package edu.estacio.barbearia.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.estacio.barbearia.model.Barbeiro;
import edu.estacio.barbearia.repository.BarbeiroRepository;

@Configuration
public class BarbeiroConfig {

    @Bean
    CommandLineRunner carregarBarbeiros(BarbeiroRepository repository) {

        return args -> {

            if (repository.count() == 0) {

                Barbeiro b1 = new Barbeiro();
                b1.setNome("João Pedro");
                b1.setEspecialidade("Degradê");
                b1.setExperiencia(5);
                b1.setIdade(28);
                b1.setAvaliacao(5);
                repository.save(b1);

                Barbeiro b2 = new Barbeiro();
                b2.setNome("Carlos Silva");
                b2.setEspecialidade("Corte & barba");
                b2.setExperiencia(8);
                b2.setIdade(35);
                b2.setAvaliacao(4);
                repository.save(b2);

                Barbeiro b3 = new Barbeiro();
                b3.setNome("Rafael Matos");
                b3.setEspecialidade("Social");
                b3.setExperiencia(3);
                b3.setIdade(24);
                b3.setAvaliacao(5);
                repository.save(b3);
            }
        };
    }
}