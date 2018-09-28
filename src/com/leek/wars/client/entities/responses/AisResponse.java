package com.leek.wars.client.entities.responses;

import java.util.Iterator;
import java.util.List;

import com.leek.wars.client.entities.AI;

public class AisResponse extends Response implements Iterable<AI> {

	private List<AI> ais;

	
	public List<AI> getAis() {
		return ais;
	}
	public void setAis(List<AI> ais) {
		this.ais = ais;
	}

	
	@Override
	public Iterator<AI> iterator() {
		return ais.iterator();
	}
	
}
