package com.leek.wars.client.entities;

public class Potion {

	private Long id;
	private Integer template;
	private Integer quantity;
	
	
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "Potion [id=" + id + ", template=" + template + ", quantity=" + quantity + "]";
	}
}
