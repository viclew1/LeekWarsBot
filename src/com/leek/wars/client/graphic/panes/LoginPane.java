package com.leek.wars.client.graphic.panes;

import com.leek.wars.client.graphic.LWPane;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LoginPane extends LWPane {

	
	public LoginPane() {
		super("Connexion");
	}

	@Override
	protected GridPane generateContent() {
		GridPane pane = new GridPane();
		
		Text loginText = new Text("Login");
		TextField loginInput = new TextField();
		Text passwordText = new Text("Password");
		TextField passwordInput = new TextField();
		
		pane.add(loginText, 0, 0);
		pane.add(loginInput, 1, 0);
		pane.add(passwordText, 0, 1);
		pane.add(passwordInput, 1, 1);
		
		return pane;
	}
	
}
