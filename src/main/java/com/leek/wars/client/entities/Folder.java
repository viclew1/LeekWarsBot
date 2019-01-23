package com.leek.wars.client.entities;

public class Folder {

	private Long id;
	private String name;
	private Long folder;
	
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
	public Long getFolder() {
		return folder;
	}
	public void setFolder(Long folder) {
		this.folder = folder;
	}
	
	@Override
	public String toString() {
		return "Folder [id=" + id + ", name=" + name + ", folder=" + folder + "]";
	}
}
