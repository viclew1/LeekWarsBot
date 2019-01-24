package com.leek.wars.client.util.ais;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.AI;
import com.leek.wars.client.entities.Folder;
import com.leek.wars.client.util.ais.archi.AbstractNode;
import com.leek.wars.client.util.ais.archi.NodeFile;
import com.leek.wars.client.util.ais.archi.NodeFolder;
import com.leek.wars.client.util.ais.archi.TreeRoot;
import com.leek.wars.client.util.files.FileHelper;

public enum AisHelper {

	INSTANCE;

	private static final Logger logger = LoggerFactory.getLogger(AisHelper.class);

	private File accountsDir;

	private AisHelper() {}

	public void init(String dataDirPath) throws IOException {
		String accountsFilePath = dataDirPath + "/AIs/";
		accountsDir = FileHelper.INSTANCE.createDir(accountsFilePath);
	}

	public void saveAIs(String user, List<AI> ais, List<Folder> folders) {
		String userDirPath = accountsDir.getAbsolutePath() + "/" + user + "/";
		FileHelper.INSTANCE.createDir(userDirPath);
		
		Map<Long, NodeFolder> foldersNodes = folders.stream()
				.map(f -> new NodeFolder(null, f))
				.collect(Collectors.toMap(AbstractNode::getId, Function.identity()));
		
		List<NodeFile> filesNodes = ais.stream()
				.map(ai -> new NodeFile(null, ai))
				.collect(Collectors.toList());
		
		TreeRoot root = new TreeRoot(userDirPath);
		generateTree(root, foldersNodes, filesNodes);
		root.generate();
		logger.info("AIs saved to : {}", userDirPath);
	}


	private void generateTree(TreeRoot root, Map<Long, NodeFolder> foldersNodes, List<NodeFile> filesNodes) {
		for (NodeFolder folderNode : foldersNodes.values()) {
			generateFolderNode(root, folderNode, foldersNodes);
		}
		for (NodeFile fileNode : filesNodes) {
			generateFileNode(root, fileNode, foldersNodes);
		}
	}
	
	private void generateFolderNode(TreeRoot root, NodeFolder folderNode, Map<Long, NodeFolder> foldersNodes) {
		Long parentId = folderNode.getFolder().getFolder();
		generateNode(root, folderNode, parentId, foldersNodes);
	}
	
	private void generateFileNode(TreeRoot root, NodeFile fileNode, Map<Long, NodeFolder> foldersNodes) {
		Long parentId = fileNode.getAi().getFolder();
		generateNode(root, fileNode, parentId, foldersNodes);
	}
	
	private void generateNode(TreeRoot root, AbstractNode node, Long parentId, Map<Long, NodeFolder> foldersNodes) {
		AbstractNode parent = foldersNodes.get(parentId);
		
		if (parent == null) {
			parent = root;
		}
		
		parent.getChildren().add(node);
		node.setParent(parent);
	}
	
}
