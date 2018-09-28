package com.leek.wars.client.entities;

public class AI {

	private Long id;
	private String name;
	private Integer level;
	private Boolean valid;
	private Integer folder;
	private Integer v2;
	
	public Long getId() {
		return id;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Integer getFolder() {
		return folder;
	}
	public void setFolder(Integer folder) {
		this.folder = folder;
	}
	public Integer getV2() {
		return v2;
	}
	public void setV2(Integer v2) {
		this.v2 = v2;
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
	
	
	@Override
	public String toString() {
		return "AI [id=" + id + ", name=" + name + ", level=" + level + "]";
	}
}
