package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static java.lang.String.valueOf;


public class App extends Application{
    private AbstractWorldMap map;
    GridPane gridPane = new GridPane();
    private SimulationEngine simulationEngine;

    @Override
    public void init() throws Exception {
        super.init();
        Parameters parameters = getParameters();
        String[] args = parameters.getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            simulationEngine = new SimulationEngine(directions, map, positions, 1000, this);

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage){

        TextField textField = new TextField();
        Button startButton = getButton(textField);
        HBox hBox = new HBox(this.gridPane, textField, startButton);
        createMap();
        Scene scene = new Scene(hBox, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public Button getButton(TextField textField){
        Button button = new Button("Start");
        button.setOnAction((action) -> {
            String text = textField.getText();
            MoveDirection[] directions = OptionsParser.parse(text.split(" "));
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4)};
            GrassField map = new GrassField(10);
            simulationEngine.addDirections(directions);
            Thread thread = new Thread(this.simulationEngine);
            thread.start();

        });
        return button;
    }

    public void refreshMap(){
        Platform.runLater(() ->{
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(false);
            gridPane.getColumnConstraints().clear();
            gridPane.getRowConstraints().clear();

            createMap();
        });
    }

    public void createMap(){

        int startX = map.getLowerLeft().x;
        int startY = map.getLowerLeft().y;
        int endX = map.getUpperRight().x;
        int endY = map.getUpperRight().y;

        int cellWidth = 40;
        int cellHeight = 40;

        Label xy = new Label("x/y");
        gridPane.add(xy, 0 , 0);
        gridPane.setHalignment(xy, HPos.CENTER);

        for(int i = startX; i <= endX; i++){
            Label label = new Label(String.valueOf(i));
            gridPane.add(label, i-startX+1 , 0);
            gridPane.setHalignment(label, HPos.CENTER);
        }

        for(int i = endY; i >= startY; i--){
            Label label = new Label(String.valueOf(i));
            gridPane.add(label, 0 , endY - i + 1);
            gridPane.setHalignment(label, HPos.CENTER);
        }

        gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
        gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));

        for (int y = endY; y >= startY; y--) {
            gridPane.getRowConstraints().add(new RowConstraints(cellHeight));

            for (int x = startX; x <= endX; x++) {
                if (y==endY)
                    gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
                Vector2d currentPosition = new Vector2d(x,y);
                Label label = new Label("");
                if (this.map.isOccupied(currentPosition)) {
                    Object object = this.map.objectAt(currentPosition);
                    if (object != null) {
                        GuiElementBox vBox = new GuiElementBox((IMapElement) this.map.objectAt(currentPosition));
                        gridPane.add(vBox.box, x-startX+1,endY - y+1);
                        //gridPane.setHalignment(vBox.box, HPos.CENTER);
                    }else{
                        gridPane.add( label, x-startX+1,endY - y+1);
                    }
                }else{
                    gridPane.add( label, x-startX+1,endY - y+1);
                }


            }}
        gridPane.setGridLinesVisible(true);
    }
}



