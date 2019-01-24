package com.leek.wars.client.util.ais.archi;

import com.leek.wars.client.entities.AI;
import com.leek.wars.client.util.files.FileHelper;

public class NodeFile extends AbstractNode {

	private final AI ai;
	
	public NodeFile(AbstractNode parent, AI ai) {
		super(parent, ai.getId());
		this.ai = ai;
	}

	
	public AI getAi() {
		return ai;
	}

	@Override
	public String getPath() {
		return getParent().getPath() + "/" + ai.getName();
	}

	@Override
	public void generate() {
		FileHelper.INSTANCE.createFile(getPath(), ai.getCode());
	}

}
