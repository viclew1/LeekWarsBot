package com.leek.wars.bot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fight {

	private Long id;
	private Long date;
	private Integer type;
	private Integer context;
	private Integer status;
	private String winner;
	@JsonProperty("farmer_team")
	private Integer farmerTeam;
	private String result;
	private Long farmer1;
	private Long farmer2;
	@JsonProperty("farmer1_name")
	private String farmer1Name;
	@JsonProperty("farmer2_name")
	private String farmer2Name;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getContext() {
		return context;
	}
	public void setContext(Integer context) {
		this.context = context;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public Integer getFarmerTeam() {
		return farmerTeam;
	}
	public void setFarmerTeam(Integer farmerTeam) {
		this.farmerTeam = farmerTeam;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getFarmer1() {
		return farmer1;
	}
	public void setFarmer1(Long farmer1) {
		this.farmer1 = farmer1;
	}
	public Long getFarmer2() {
		return farmer2;
	}
	public void setFarmer2(Long farmer2) {
		this.farmer2 = farmer2;
	}
	public String getFarmer1Name() {
		return farmer1Name;
	}
	public void setFarmer1Name(String farmer1Name) {
		this.farmer1Name = farmer1Name;
	}
	public String getFarmer2Name() {
		return farmer2Name;
	}
	public void setFarmer2Name(String farmer2Name) {
		this.farmer2Name = farmer2Name;
	}
	
	
	@Override
	public String toString() {
		return "Fight [id=" + id + ", date=" + date + ", type=" + type + ", context=" + context + ", status=" + status
				+ ", winner=" + winner + ", farmer1=" + farmer1 + ", farmer2=" + farmer2 + ", farmer1Name="
				+ farmer1Name + ", farmer2Name=" + farmer2Name + "]";
	}
}
