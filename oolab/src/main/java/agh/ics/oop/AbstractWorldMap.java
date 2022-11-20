package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animals = new ArrayList<>();
    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){

        return objectAt(position) != null;
    }

    public abstract Vector2d getUpperRight();

    public abstract Vector2d getLowerLeft();

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }
}


