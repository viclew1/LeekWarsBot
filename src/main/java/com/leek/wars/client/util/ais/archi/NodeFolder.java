package com.leek.wars.client.util.ais.archi;

import com.leek.wars.client.entities.Folder;
import com.leek.wars.client.util.files.FileHelper;

public class NodeFolder extends AbstractNode {

	private final Folder folder;
	
	public NodeFolder(AbstractNode parent, Folder folder) {
		super(parent, folder.getId());
		this.folder = folder;
	}
	
	public Folder getFolder() {
		return folder;
	}

	@Override
	public String getPath()  {
		return getParent().getPath() + "/" + folder.getName();
	}
	
	@Override
	public void generate() {
		FileHelper.INSTANCE.createDir(getPath());
		for (AbstractNode node : getChildren()) {
			node.generate();
		}
	}

}
