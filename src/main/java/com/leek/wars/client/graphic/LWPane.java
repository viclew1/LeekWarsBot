package com.leek.wars.client.graphic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class LWPane {

	protected static final Logger logger = LoggerFactory.getLogger(LWPane.class);
	
	private GridPane fullPane;

	public LWPane() {
		this(null);
	}

	public LWPane(String paneName) {
		fullPane = new GridPane();
		GridPane.setHgrow(fullPane, Priority.ALWAYS);
		if (paneName != null) {
			fullPane.add(new Text(paneName), 0, 0);
			Separator sep = new Separator(Orientation.HORIZONTAL);
			GridPane.setMargin(sep, new Insets(10));
			fullPane.add(sep, 0, 1);
		}
		GridPane content = generateContent();
		for (Node n : content.getChildren()) {
			GridPane.setMargin(n, new Insets(3));
		}

		
		fullPane.add(content, 0, 2);

		fullPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
		fullPane.setPadding(new Insets(10));
		GridPane.setMargin(fullPane, new Insets(5));
		fullPane.setBorder(new Border(new BorderStroke(Color.BLACK, 
				BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
	}

	public GridPane getPane() {
		return fullPane;
	}

	protected abstract GridPane generateContent();

}
