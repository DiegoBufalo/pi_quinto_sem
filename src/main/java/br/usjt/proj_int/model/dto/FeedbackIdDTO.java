package br.usjt.proj_int.model.dto;

import br.usjt.proj_int.model.beans.Feedback;

public class FeedbackIdDTO {

	private String id;
	
	public FeedbackIdDTO(Feedback feedback) {
		this.id = feedback.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
}
