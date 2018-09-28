package com.leek.wars.client.entities.responses;

import java.util.Iterator;
import java.util.List;

import com.leek.wars.client.entities.Leek;

public class OpponentLeeksResponse extends Response implements Iterable<Leek> {

	private List<Leek> opponents;
	
	
	public List<Leek> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Leek> opponents) {
		this.opponents = opponents;
	}

	@Override
	public Iterator<Leek> iterator() {
		return opponents.iterator();
	}

}
