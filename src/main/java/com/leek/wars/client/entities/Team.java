package com.leek.wars.client.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

	private Long id;
	private String name;
	private Integer level;
	@JsonProperty("emblem_changed")
	private Integer emblemChanged;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getEmblemChanged() {
		return emblemChanged;
	}
	public void setEmblemChanged(Integer emblemChanged) {
		this.emblemChanged = emblemChanged;
	}
	
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", level=" + level + ", emblemChanged=" + emblemChanged + "]";
	}
	
}
