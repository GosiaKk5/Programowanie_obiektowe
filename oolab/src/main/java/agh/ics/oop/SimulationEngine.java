package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final Vector2d[] initialPositions;
    private final MoveDirection[] animalMovements;
    private List<Animal> animals;

    private IWorldMap map;

    public SimulationEngine(MoveDirection[] animalMovements,IWorldMap map, Vector2d[] initialPositions){
        this.initialPositions = initialPositions;
        this.animalMovements = animalMovements;
        this.animals = new ArrayList<>();
        this.map = map;

        for(Vector2d position:initialPositions){
            Animal animal = new Animal(map, position);
            if(this.map.place(animal)){
                this.animals.add(animal);
            };
        }
    }

    public void run(){
        for(int i=0; i < this.animalMovements.length; i++){
            Animal currentAnimal = this.animals.get(i % this.animals.size());
            currentAnimal.move(this.animalMovements[i]);
        }
    }

    public Animal getAnimal(int noAnimal){
        return this.animals.get(noAnimal);
    }
}
