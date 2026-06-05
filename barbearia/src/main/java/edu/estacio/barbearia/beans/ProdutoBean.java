package edu.estacio.barbearia.beans;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.springframework.web.context.annotation.RequestScope;

import edu.estacio.barbearia.model.Produto;

@Named
@RequestScope
public class ProdutoBean {

	private List<Produto> produtos;

	@PostConstruct
	public void init() {

		produtos = new ArrayList<Produto>();
		
		Produto produto1 = new Produto();
		produto1.setNome("Corte Masculino Tradicional");
		produto1.setPreco(30.00);
		produtos.add(produto1);
		
		Produto produto2 = new Produto();
		produto2.setNome("Corte Infantil (até 12 anos)");
		produto2.setPreco(20.00);
		produtos.add(produto2);
		
		Produto produto3 = new Produto();
		produto3.setNome("Barba Completa");
		produto3.setPreco(20.00);
		produtos.add(produto3);
		
		Produto produto4 = new Produto();
		produto4.setNome("Corte + Barba");
		produto4.setPreco(40.00);
		produtos.add(produto4);
		
		Produto produto5 = new Produto();
		produto5.setNome("Sobrancelha Masculina");
		produto5.setPreco(2.00);
		produtos.add(produto5);
		
		Produto produto6 = new Produto();
		produto6.setNome("Hidratação Capilar");
		produto6.setPreco(20.00);
		produtos.add(produto6);
		
		Produto produto7 = new Produto();
		produto7.setNome("Camuflagem de Fios Brancos");
		produto7.setPreco(15.00);
		produtos.add(produto7);
		
		Produto produto8 = new Produto();
		produto8.setNome("Relaxamento/Alisamento");
		produto8.setPreco(50.00);
		produtos.add(produto8);
		
		Produto produto9 = new Produto();
		produto9.setNome("Corte Social Premium");
		produto9.setPreco(60.00);
		produtos.add(produto9);
	
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
