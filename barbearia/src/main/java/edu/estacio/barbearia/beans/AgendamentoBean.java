package edu.estacio.barbearia.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import edu.estacio.barbearia.model.Agendamento;
import edu.estacio.barbearia.model.Produto;
import edu.estacio.barbearia.repository.AgendamentoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class AgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SessaoBean sessaobean;

	private ScheduleModel eventModel;

	private List<Produto> servicosSelecionados = new ArrayList<>();

	private String barbeiroSelecionado;

	private LocalDateTime dataSelecionada;

	private List<Date> datasValidas;

	@Inject
	private AgendamentoRepository repository;

	@PostConstruct
	public void init() {
				
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (!context.isPostback() && !sessaobean.isLogado()) {
	        try {
	            context.getExternalContext().redirect(
	                context.getExternalContext().getRequestContextPath() + "/login.xhtml"
	            );
	            context.responseComplete();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

		servicosSelecionados = new ArrayList<>();
		barbeiroSelecionado = "";
		dataSelecionada = null;

//        eventModel = new DefaultScheduleModel();
//
//        DefaultScheduleEvent<?> event = DefaultScheduleEvent.builder()
//                .title("Antônio")
//                .description("Rafael Matos")
//                .startDate(LocalDateTime.now())
//                .endDate(LocalDateTime.now().plusHours(1))
//                .build();
//
//        eventModel.addEvent(event);

		eventModel = new DefaultScheduleModel();

		List<Agendamento> lista = repository.findAll();

		for (Agendamento ag : lista) {

			DefaultScheduleEvent<?> event = DefaultScheduleEvent.builder().title(ag.getCliente())
					.description(ag.getBarbeiro()).startDate(ag.getInicio()).endDate(ag.getFim()).build();

			eventModel.addEvent(event);
		}

	}

	public List<Produto> getServicosSelecionados() {
		return servicosSelecionados;
	}

	public void setServicosSelecionados(List<Produto> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	public double getTotal() {
		return servicosSelecionados.stream().mapToDouble(Produto::getPreco).sum();
	}

	public int getQuantidadeServicos() {
		return servicosSelecionados.size();
	}

	public String confirmar() {
		if (servicosSelecionados.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Selecione pelo menos um serviço!"));
			return null;
		} else {
//        	   DefaultScheduleEvent<?> event = DefaultScheduleEvent.builder()
//                       .title(sessaobean.getUsuarioLogado().getNome())
//                       .description(getBarbeiroSelecionado())
//                       .startDate(dataSelecionada)
//                       .endDate(dataSelecionada.plusHours(1))
//                       .build();
//
//               eventModel.addEvent(event);

			Agendamento agendamento = new Agendamento();

			agendamento.setCliente(sessaobean.getUsuarioLogado().getNome());
			agendamento.setBarbeiro(barbeiroSelecionado);
			agendamento.setInicio(dataSelecionada);
			agendamento.setFim(dataSelecionada.plusHours(1));

			repository.save(agendamento);

			init();
		}

		return null;
	}

	public String cancelar() {
		servicosSelecionados = new ArrayList<>();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelado", "Agendamento cancelado."));
		return null;
	}

	public LocalDateTime getDataSelecionada() {
		return dataSelecionada;
	}

	public void setDataSelecionada(LocalDateTime dataSelecionada) {
		this.dataSelecionada = dataSelecionada;
		System.out.println("Data selecionada: " + dataSelecionada);
	}

	public List<Date> getDatasValidas() {
		return datasValidas;
	}

	public void setDatasValidas(List<Date> datasValidas) {
		this.datasValidas = datasValidas;
		System.out.println("Data válida: " + datasValidas);
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public String getBarbeiroSelecionado() {
		return barbeiroSelecionado;
	}

	public void setBarbeiroSelecionado(String barbeiroSelecionado) {
		this.barbeiroSelecionado = barbeiroSelecionado;
		System.out.println("Barbeiro selecionado: " + barbeiroSelecionado);
	}

	public SessaoBean getSessaobean() {
		return sessaobean;
	}

	public void setSessaobean(SessaoBean sessaobean) {
		this.sessaobean = sessaobean;
	}

	public AgendamentoRepository getRepository() {
		return repository;
	}

	public void setRepository(AgendamentoRepository repository) {
		this.repository = repository;
	}
}
