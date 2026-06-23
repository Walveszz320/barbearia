package edu.estacio.barbearia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    private String barbeiro;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    public Agendamento() {
    }

    public Agendamento(String cliente,
                       String barbeiro,
                       LocalDateTime inicio,
                       LocalDateTime fim) {

        this.setCliente(cliente);
        this.setBarbeiro(barbeiro);
        this.setInicio(inicio);
        this.setFim(fim);
    }

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(String barbeiro) {
		this.barbeiro = barbeiro;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

    // getters e setters
}
