package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private int noGrass;
    private List<Grass> setOfGrass;
    //private List<Animal> animals;
    private Vector2d upperRight;
    private Vector2d lowerLeft;

    public GrassField(int noGrass) {
        this.upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.noGrass = noGrass;
        this.setOfGrass = new ArrayList<>();
        this.animals = new ArrayList<>();
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
                this.setOfGrass.add(new Grass(new Vector2d(x, y)));
                countGrass += 1;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (objectAt(position) != null) {
            return !(objectAt(position) instanceof Animal);
        }
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        for (Grass grass : setOfGrass) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public Vector2d getUpperRight() {
        this.upperRight = this.animals.get(0).getPosition();

        for (Animal animal : animals) {
            this.upperRight = this.upperRight.uperRight(animal.getPosition());
        }
        for (Grass grass : setOfGrass) {
            this.upperRight = this.upperRight.uperRight(grass.getPosition());
        }
        return this.upperRight;
    }

    @Override
    public Vector2d getLowerLeft() {
        this.lowerLeft = animals.get(0).getPosition();

        for (Animal animal : animals) {
            this.lowerLeft = this.lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : setOfGrass) {
            this.lowerLeft = this.lowerLeft.lowerLeft(grass.getPosition());
        }
        return this.lowerLeft;
    }
}