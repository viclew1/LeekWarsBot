package com.leek.wars.client.graphic;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class LWGroup extends Group {
	
	private Stage stage;
	
	public LWGroup(Stage stage) {
		this.stage = stage;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void call() {
		ObservableList<Node> children = getChildren();
		children.clear();
		children.add(generateChildren());
		stage.getScene().setRoot(this);
		stage.show();
	}

	protected abstract Node generateChildren();
	
}
