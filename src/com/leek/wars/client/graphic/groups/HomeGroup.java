package com.leek.wars.client.graphic.groups;

import com.leek.wars.client.graphic.LWGroup;
import com.leek.wars.client.graphic.LWPane;
import com.leek.wars.client.graphic.panes.LoginPane;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeGroup extends LWGroup {

	public HomeGroup(Stage stage) {
		super(stage);
	}

	@Override
	protected Node generateChildren() {
		GridPane childrenComplete = new GridPane();
		LWPane loginPane = new LoginPane();
		
		loginPane.getPane().setAlignment(Pos.CENTER);
		childrenComplete.add(loginPane.getPane(), 0, 0, 5, 10);
		return childrenComplete;
	}

}
