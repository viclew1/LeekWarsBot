package com.leek.wars.client.graphic.panes;

import java.io.IOException;

import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.graphic.LWPane;
import com.leek.wars.client.graphic.util.PropertiesKeys;
import com.leek.wars.client.graphic.util.SharedProperties;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
		PasswordField passwordInput = new PasswordField();
		Text errorText = new Text();
		Button connectButton = new Button("Connect");
		GridPane.setHalignment(connectButton, HPos.RIGHT);
		
		connectButton.setOnAction(new EventHandler<ActionEvent>() {
			
			
			
			@Override
			public void handle(ActionEvent event) {
				try {
					errorText.setFill(Color.BLACK);
					errorText.setText("Trying to connect ...");
					logger.info("Trying to connect ...");
					SessionResponse sr = RequestProcessor.INSTANCE.getSession(loginInput.getText(), passwordInput.getText());
					if (sr.isSuccess()) {
						errorText.setFill(Color.GREEN);
						errorText.setText("Connexion success !");
						logger.info("Connection success !");
						SharedProperties.INSTANCE.put(PropertiesKeys.SESSION, sr);
					} else {
						errorText.setFill(Color.RED);
						errorText.setText("Could not connect.");
						logger.info("Could not connect.");
					}
				} catch (ServerException | IOException e) {
					errorText.setFill(Color.RED);
					errorText.setText("Could not connect.");
					logger.error("Could not connect.", e);
				}
			}
		});
		
		pane.add(loginText, 0, 0);
		pane.add(loginInput, 1, 0);
		pane.add(passwordText, 0, 1);
		pane.add(passwordInput, 1, 1);
		pane.add(errorText, 0, 2, 2, 1);
		pane.add(connectButton, 1, 2);
		
		return pane;
	}
	
}
