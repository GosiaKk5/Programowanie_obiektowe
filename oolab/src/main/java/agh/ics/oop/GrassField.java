package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{


    private int noGrass;
    private Vector2d upperRight;
    private Vector2d lowerLeft;

    public GrassField(int noGrass){
        super();
        this.upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.noGrass = noGrass;

        addingGrass(noGrass);

    }

    private void addingGrass(int noGrass){
        int countGrass = 0;
        Random rand = new Random();
        int x;
        int y;
        while (countGrass < noGrass){
            x = rand.nextInt((int) sqrt(noGrass*10));
            y = rand.nextInt((int) sqrt(noGrass*10));

            if(!isOccupied(new Vector2d(x, y))){
                this.mapElements.add(new Grass(new Vector2d(x, y)));
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
        for(IMapElement element:mapElements){
            if(element.getPosition().equals(position)){
                return element;
            }
        }
        return null;
    }

    @Override
    public Vector2d getUpperRight() {
        for(IMapElement element:mapElements){
            this.upperRight = this.upperRight.uperRight(element.getPosition());
        }
        return this.upperRight;
    }

    @Override
    public Vector2d getLowerLeft() {

        for(IMapElement element:mapElements){
            this.lowerLeft = this.lowerLeft.lowerLeft(element.getPosition());
        }
        return this.lowerLeft;
    }
}

