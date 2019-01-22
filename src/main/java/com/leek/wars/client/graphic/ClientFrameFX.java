package com.leek.wars.client.graphic;

import com.leek.wars.client.graphic.groups.HomeGroup;

import fr.lewon.ihm.builder.GenericApplication;
import fr.lewon.ihm.builder.GenericGroup;
import javafx.stage.Stage;

public class ClientFrameFX extends GenericApplication {

	public ClientFrameFX() {
		super("LeekWars Client");
	}

	@Override
	protected GenericGroup getBaseGroup(Stage stage) {
		return new HomeGroup(stage);
	}

}
