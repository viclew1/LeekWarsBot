package com.leek.wars.client.graphic.groups;

import com.leek.wars.client.graphic.panes.LoginPane;

import fr.lewon.ihm.builder.GenericGroup;
import fr.lewon.ihm.builder.GenericPane;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeGroup extends GenericGroup {

	public HomeGroup(Stage stage) {
		super(stage);
	}

	@Override
	protected Node generateChildren(Stage stage) {
		GridPane childrenComplete = new GridPane();
		
		GenericPane loginPane = new LoginPane(stage);
		
		childrenComplete.add(loginPane, 0, 0);
		return childrenComplete;
	}

}
