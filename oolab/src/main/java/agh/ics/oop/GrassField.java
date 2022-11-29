package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {


    private int noGrass;
    private Map<Vector2d, Grass> setOfGrass;


    public GrassField(int noGrass) {
        super();
        this.setOfGrass = new HashMap<>();
        addingGrass(noGrass);

    }

    private void addingGrass(int noGrass) {
        int countGrass = 0;
        Random rand = new Random();
        int x;
        int y;
        while (countGrass < noGrass) {
            x = rand.nextInt((int) sqrt(noGrass * 10));
            y = rand.nextInt((int) sqrt(noGrass * 10));

            if (!isOccupied(new Vector2d(x, y))) {
                Grass grass = new Grass(new Vector2d(x, y));
                this.setOfGrass.putIfAbsent(new Vector2d(x, y), grass);
                this.mapBoundary.add((IMapElement) grass);
                countGrass += 1;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (objectAt(position) != null) {
            return (objectAt(position) instanceof Grass);
        }
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {

        if (animals.get(position) != null) {
            return animals.get(position);
        }
        return setOfGrass.get(position);
    }

    @Override
    public Vector2d getLowerLeft() {
        return mapBoundary.lowerLeft();
    }

    @Override
    public Vector2d getUpperRight() {
        return mapBoundary.upperRight();
    }

}

//        for (Animal animal : animals) {
//            if (animal.getPosition().equals(position)) {
//                return animal;
//            }
//        }
//        for (Grass grass : setOfGrass) {
//            if (grass.getPosition().equals(position)) {
//                return grass;
//            }
//        }
//        return null;



/*    @Override
    public Vector2d getUpperRight() {
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Animal animal : animals.values()) {
            upperRight = upperRight.uperRight(animal.getPosition());
        }
        for (Grass grass : setOfGrass.values()) {
            upperRight = upperRight.uperRight(grass.getPosition());
        }
        return upperRight;
    }

    @Override
    public Vector2d getLowerLeft() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Animal animal : animals.values()) {
            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : setOfGrass.values()) {
            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        return lowerLeft;
    }*/


