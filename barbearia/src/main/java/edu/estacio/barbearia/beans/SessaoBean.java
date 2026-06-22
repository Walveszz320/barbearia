package edu.estacio.barbearia.beans;
import java.io.Serializable;

import edu.estacio.barbearia.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class SessaoBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void init() { 
		System.out.println("Session Bean Iniciado");
	}

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean isLogado() {
        return usuarioLogado != null;
    }

    public String logout() {
        usuarioLogado = null; 
        return "login.xhtml?faces-redirect=true";
    }
}