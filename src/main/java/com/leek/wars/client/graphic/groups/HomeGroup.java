package com.leek.wars.client.graphic.groups;

import com.leek.wars.client.graphic.LWGroup;
import com.leek.wars.client.graphic.LWPane;
import com.leek.wars.client.graphic.panes.BannerPane;
import com.leek.wars.client.graphic.panes.LoginPane;

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
		
		LWPane bannerPane = new BannerPane();
		LWPane loginPane = new LoginPane();
		
		childrenComplete.add(bannerPane.getPane(), 0, 0);
		childrenComplete.add(loginPane.getPane(), 0, 1);
		return childrenComplete;
	}

}
