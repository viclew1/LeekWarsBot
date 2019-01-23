package com.leek.wars.client.entities.responses;

import java.util.Iterator;
import java.util.List;

import com.leek.wars.client.entities.AI;
import com.leek.wars.client.entities.Folder;

public class AisResponse extends Response implements Iterable<AI> {

	private List<AI> ais;
	private List<Folder> folders;
	
	public List<AI> getAis() {
		return ais;
	}
	public void setAis(List<AI> ais) {
		this.ais = ais;
	}
	public List<Folder> getFolders() {
		return folders;
	}
	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}
	
	@Override
	public Iterator<AI> iterator() {
		return ais.iterator();
	}
	
}
