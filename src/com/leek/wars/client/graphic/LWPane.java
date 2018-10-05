package com.leek.wars.client.graphic;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class LWPane {

	private GridPane fullPane;

	public LWPane() {
		this(null);
	}

	public LWPane(String paneName) {
		fullPane = new GridPane();
		if (paneName != null) {
			fullPane.add(new Text(paneName), 0, 0);
			Separator sep = new Separator(Orientation.HORIZONTAL);
			GridPane.setMargin(sep, new Insets(10));
			fullPane.add(sep, 0, 1);
		}
		fullPane.add(generateContent(), 0, 2);

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
