package com.leek.wars.client.util.ais.archi;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode {

	private final Long id;
	private AbstractNode parent;
	private final List<AbstractNode> children;
	
	
	public AbstractNode(AbstractNode parent, Long id) {
		this.id = id;
		this.parent = parent;
		this.children = new ArrayList<>();
	}

	
	public List<AbstractNode> getChildren() {
		return children;
	}

	public AbstractNode getParent() {
		return parent;
	}

	public void setParent(AbstractNode parent) {
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}


	public abstract String getPath();
	
	public abstract void generate();

	@Override
	public String toString() {
		return "AbstractNodeAI [id=" + id + ", parent=" + parent + ", children=" + children + "]";
	}

}
