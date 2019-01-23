package com.leek.wars.client.util.ais.archi;

import com.leek.wars.client.entities.AI;
import com.leek.wars.client.util.files.FileHelper;

public class NodeFile extends AbstractNode {

	private final AI ai;
	private String content;
	
	public NodeFile(AbstractNode parent, AI ai, String content) {
		super(parent, null);
		this.ai = ai;
		this.content = content;
	}

	
	public AI getAi() {
		return ai;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String getPath() {
		return getParent().getPath() + "/" + ai.getName();
	}

	@Override
	public void generate() {
		FileHelper.INSTANCE.createFile(getPath(), getContent());
	}

}
