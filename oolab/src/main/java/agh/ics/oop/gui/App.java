package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.String.valueOf;


public class App extends Application {
    private AbstractWorldMap map;

    @Override
    public void init() throws Exception {
        super.init();
        Parameters parameters = getParameters();
        String[] args = parameters.getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map.toString());

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage){

        int startX = map.getLowerLeft().x;
        int startY = map.getLowerLeft().y;
        int endX = map.getUpperRight().x;
        int endY = map.getUpperRight().y;

        int cellWidth = 30;
        int cellHeight =30;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);


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
                String result = null;
                Vector2d currentPosition = new Vector2d(x,y);
                if (this.map.isOccupied(currentPosition)) {
                    Object object = this.map.objectAt(currentPosition);
                    if (object != null) {
                        result = object.toString();
                    } else {
                        result = " ";
                    }
                } else {
                    result = " ";
                }
                Label label = new Label(result);

                gridPane.add(label, x-startX+1,endY - y+1);
                gridPane.setHalignment(label, HPos.CENTER);
            }}


        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }}




