package edu.estacio.barbearia.beans;

import java.io.Serializable;
import java.util.List;

import edu.estacio.barbearia.model.Usuario;
import edu.estacio.barbearia.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
    private SessaoBean sessaoBean;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	private String login;
	private String senha;

	private List<Usuario> usuarios; // vai vir do banco

	@PostConstruct
	public void init() {
		
		usuarios = usuarioRepository.findAll();

//		usuarios = new ArrayList<Usuario>();
//
//		Usuario usuario1 = new Usuario();
//		usuario1.setNome("Guilherme");
//		usuario1.setLogin("guilherme");
//		usuario1.setSenha("senha01");
//		usuarios.add(usuario1);

	}

	private boolean login() {

		for (int i = 0; i < usuarios.size(); i++) {

			Usuario u = usuarios.get(i);

			if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
				sessaoBean.setUsuarioLogado(u);
				return true;
			}

		}
		return false;

	}

	public String efetuarlogin() {

		if (login()) {
			
			System.out.println("Sucesso, login efetuado!");
			return "index.xhtml?faces-redirect=true";

		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Usuário ou senha inválidos."));

			System.out.println("Erro, login não efetuado!");
		}
		return null;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public SessaoBean getSessaoBean() {
		return sessaoBean;
	}

	public void setSessaoBean(SessaoBean sessaoBean) {
		this.sessaoBean = sessaoBean;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
