package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();
    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();

        if(this.canMoveTo(position)){
            this.animals.put(position, animal);
            this.mapBoundary.add(animal);
            animal.addObserver(this);
            animal.addObserver(mapBoundary);
            return true;
        }else{
            throw new IllegalArgumentException("There is animal on position " + position);
        }
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

    @Override
    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}


