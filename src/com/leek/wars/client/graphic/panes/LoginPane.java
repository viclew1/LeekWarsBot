package com.leek.wars.client.graphic.panes;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LoginPane extends GridPane {

	
	private Text loginText;
	private TextField loginInput;
	private Text passwordText;
	private TextField passwordInput;
	
	public LoginPane() {
		loginText = new Text("Login");
		loginInput = new TextField();
		passwordText = new Text("Password");
		passwordInput = new TextField();
		
		add(loginText, 0, 0);
		add(loginInput, 1, 0);
		add(passwordText, 0, 1);
		add(passwordInput, 1, 1);
	}
	
}
