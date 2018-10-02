package com.leek.wars.client.entities;

public class Leek {
	
	private Long id;
	private String name;
	private String color;
	private Integer capital;
	private Integer level;
	private Integer talent;
	private Integer skin;
	private Integer hat;
	
	
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getTalent() {
		return talent;
	}
	public void setTalent(Integer talent) {
		this.talent = talent;
	}
	public Integer getSkin() {
		return skin;
	}
	public void setSkin(Integer skin) {
		this.skin = skin;
	}
	public Integer getHat() {
		return hat;
	}
	public void setHat(Integer hat) {
		this.hat = hat;
	}
	
	
	@Override
	public String toString() {
		return "Leek [id=" + id + ", name=" + name + ", color=" + color + ", capital=" + capital + ", level=" + level
				+ ", talent=" + talent + ", skin=" + skin + ", hat=" + hat + "]";
	}
	
	public String toSimpleString() {
		return getName() + " (" + getLevel() + " - " + getTalent() + ")";
	}
}
