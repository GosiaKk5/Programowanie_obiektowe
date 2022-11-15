package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;

    //private List<Animal> animals;


    public RectangularMap(int width, int heigth) {
        this.upperRight = new Vector2d(width, heigth);
        this.lowerLeft = new Vector2d(0,0);
        this.mapElements = new ArrayList<>();
    }


    public boolean canMoveTo(Vector2d position){
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !isOccupied(position);
    }

    public Object objectAt(Vector2d position){
        for(IMapElement animal:mapElements){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public Vector2d getUpperRight() {
        return this.upperRight;
    }

    @Override
    public Vector2d getLowerLeft() {
        return this.lowerLeft;
    }

//    public String toString(){
//        MapVisualizer mapVisualizer = new MapVisualizer(this);
//        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
//    }


}
