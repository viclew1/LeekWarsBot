package com.leek.wars.client.entities;

public class AI {

	private Long id;
	private String name;
	private Integer level;
	private Boolean valid;
	private Long folder;
	private Integer v2;
	private String code;
	
	public Long getId() {
		return id;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Long getFolder() {
		return folder;
	}
	public void setFolder(Long folder) {
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "AI [id=" + id + ", name=" + name + ", level=" + level + "]";
	}
}
