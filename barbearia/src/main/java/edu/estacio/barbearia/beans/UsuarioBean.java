package edu.estacio.barbearia.beans;

import jakarta.inject.Named;
import org.springframework.web.context.annotation.RequestScope;

@Named
@RequestScope
public class UsuarioBean {

	private String nome = "Wilson";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
