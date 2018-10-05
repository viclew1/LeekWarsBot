package com.leek.wars.client.graphic;

import com.leek.wars.client.graphic.groups.HomeGroup;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class ClientFrameFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LWGroup home = new HomeGroup(primaryStage);
		LWScene scene = new LWScene(new Group());
		
		primaryStage.setScene(scene);
		home.call();
	}

}
