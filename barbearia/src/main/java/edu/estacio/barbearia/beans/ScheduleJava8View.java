package edu.estacio.barbearia.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.primefaces.event.RateEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ScheduleJava8View implements Serializable {

    private static final long serialVersionUID = 1L;

    private ScheduleModel eventModel;
    
    private Integer rating = 0;

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

    public ScheduleModel getEventModel() {
        return eventModel;
    }
    
    public void onrate(RateEvent<Integer> rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + rateEvent.getRating());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Integer getRating() {
		System.out.println("Valor atual: " + rating);
		return rating;
		
	}

	public void setRating(Integer rating) {
		this.rating = rating; 
		System.out.println("Novo valor: " + rating);
	}
}