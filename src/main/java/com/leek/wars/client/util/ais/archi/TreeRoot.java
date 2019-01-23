package com.leek.wars.client.util.ais.archi;

public class TreeRoot extends AbstractNode {

	private String rootPath;
	
	public TreeRoot(String rootPath) {
		super(null, 0L);
		this.rootPath = rootPath;
	}
	
	@Override
	public String getPath() {
		return rootPath;
	}

	@Override
	public void generate() {
		for (AbstractNode node : getChildren()) {
			node.generate();
		}
	}
	
}
