package edu.estacio.barbearia.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import edu.estacio.barbearia.model.Produto;
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
    
    @PostConstruct
    public void init() {

        eventModel = new DefaultScheduleModel();

        DefaultScheduleEvent<?> event = DefaultScheduleEvent.builder()
                .title("Antônio")
                .description("Rafael Matos")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusHours(1))
                .build();

        eventModel.addEvent(event);
    }

    public List<Produto> getServicosSelecionados() {
        return servicosSelecionados;
    }

    public void setServicosSelecionados(List<Produto> servicosSelecionados) {
        this.servicosSelecionados = servicosSelecionados;
    }

    public double getTotal() {
        return servicosSelecionados.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

    public int getQuantidadeServicos() {
        return servicosSelecionados.size();
    }

    public String confirmar() {
        if (servicosSelecionados.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Atenção", "Selecione pelo menos um serviço!"));
            return null;
        } else {
        	   DefaultScheduleEvent<?> event = DefaultScheduleEvent.builder()
                       .title(sessaobean.getUsuarioLogado().getNome())
                       .description(getBarbeiroSelecionado())
                       .startDate(dataSelecionada)
                       .endDate(dataSelecionada.plusHours(1))
                       .build();

               eventModel.addEvent(event);
        }
        
        return null;
    }

    public String cancelar() {
        servicosSelecionados = new ArrayList<>();
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Cancelado", "Agendamento cancelado."));
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
}
