package edu.estacio.barbearia.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.estacio.barbearia.model.Barbeiro;
import edu.estacio.barbearia.repository.BarbeiroRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BarbeiroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String especialidade;
    private int id;
    private int experiencia;
    private int idade;
    private int avaliacao;
    

    // Lista fixa de barbeiros
    private List<Barbeiro> barbeiros;
    
    @Inject
    private BarbeiroRepository barbeiroRepository;

    @PostConstruct
    public void init() {

        barbeiros = barbeiroRepository.findAll();

//        // Barbeiro 1
//        Barbeiro barbeiro1 = new Barbeiro();
//        barbeiro1.setNome("Carlos Silva");
//        barbeiro1.setEspecialidade("Corte & Barba");
//        barbeiro1.setId(Long.valueOf(1));
//        barbeiro1.setExperiencia(5);
//        barbeiro1.setIdade(28);
//        barbeiro1.setAvaliacao(4);
//        barbeiros.add(barbeiro1);
//
//        // Barbeiro 2
//        Barbeiro barbeiro2 = new Barbeiro();
//        barbeiro2.setNome("João Pedro");
//        barbeiro2.setEspecialidade("Degradê");
//        barbeiro2.setId(Long.valueOf(2));
//        barbeiro2.setExperiencia(8);
//        barbeiro2.setIdade(32);
//        barbeiro2.setAvaliacao(5);
//        barbeiros.add(barbeiro2);
//
//        // Barbeiro 3
//        Barbeiro barbeiro3 = new Barbeiro();
//        barbeiro3.setNome("Rafael Matos");
//        barbeiro3.setEspecialidade("Colaração");
//        barbeiro3.setId(Long.valueOf(3));
//        barbeiro3.setExperiencia(3);
//        barbeiro3.setIdade(24);
//        barbeiro3.setAvaliacao(4);
//        barbeiros.add(barbeiro3);
    }


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Barbeiro> getBarbeiros() {
		return barbeiros;
	}

	public void setBarbeiros(List<Barbeiro> barbeiros) {
		this.barbeiros = barbeiros;
	}


	public BarbeiroRepository getBarbeiroRepository() {
		return barbeiroRepository;
	}


	public void setBarbeiroRepository(BarbeiroRepository barbeiroRepository) {
		this.barbeiroRepository = barbeiroRepository;
	}

    
}

   