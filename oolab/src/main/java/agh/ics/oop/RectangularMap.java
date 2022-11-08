package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;

    private List<Animal> animals;


    public RectangularMap(int width, int heigth) {
        this.upperRight = new Vector2d(width, heigth);
        this.lowerLeft = new Vector2d(0,0);
        this.animals = new ArrayList<>();
    }

    public boolean canMoveTo(Vector2d position){
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !isOccupied(position);
    }
    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    };

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position){
        for(Animal animal:animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }


}
