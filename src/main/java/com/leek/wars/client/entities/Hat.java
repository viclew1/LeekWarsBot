package com.leek.wars.client.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hat {

	private Long id;
	private Integer template;
	private Integer level;
	private String name;
	@JsonProperty("hat_template")
	private Integer hatTemplate;
	
	
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHatTemplate() {
		return hatTemplate;
	}
	public void setHatTemplate(Integer hatTemplate) {
		this.hatTemplate = hatTemplate;
	}
	
	
	@Override
	public String toString() {
		return "Hat [id=" + id + ", template=" + template + ", level=" + level + ", name=" + name + ", hatTemplate="
				+ hatTemplate + "]";
	}
}
