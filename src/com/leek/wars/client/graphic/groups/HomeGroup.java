package com.leek.wars.client.graphic.groups;

import com.leek.wars.client.graphic.LWGroup;
import com.leek.wars.client.graphic.panes.LoginPane;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HomeGroup extends LWGroup {

	public HomeGroup(Stage stage) {
		super(stage);
	}

	@Override
	protected Node generateChildren() {
		GridPane childrenComplete = new GridPane();
		childrenComplete.add(new Rectangle(100, 100, Color.RED), 0, 0);
		childrenComplete.add(new LoginPane(), 1, 0);
		childrenComplete.add(new Rectangle(200, 50, Color.BLACK), 0, 1);
		childrenComplete.add(new Rectangle(200, 50, Color.GREEN), 1, 1);
		return childrenComplete;
	}

}
