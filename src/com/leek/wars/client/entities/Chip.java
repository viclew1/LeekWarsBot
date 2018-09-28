package com.leek.wars.client.entities;

public class Chip {

	private Long id;
	private Integer template;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTemplate() {
		return template;
	}
	public void setTemplate(Integer template) {
		this.template = template;
	}
	
	
	@Override
	public String toString() {
		return "Chip [id=" + id + ", template=" + template + "]";
	}
}
