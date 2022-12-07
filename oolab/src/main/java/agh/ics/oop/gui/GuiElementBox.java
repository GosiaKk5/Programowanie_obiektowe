package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {




    VBox box = new VBox();
    Label label;

    public GuiElementBox(IMapElement element) {

        Image image = null;
        try {
            image = new Image(new FileInputStream(element.getImagePath()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        if (element instanceof Animal) {
            this.label = new Label(element.toString() + element.getPosition().toString());
        } else
            this.label = new Label("Grass");
            this.box.getChildren().addAll(imageView, label);
            this.box.setAlignment(Pos.CENTER);

    }


}
