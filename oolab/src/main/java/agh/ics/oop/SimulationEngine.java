package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{

    private final Vector2d[] initialPositions;
    private MoveDirection[] animalMovements;
    private List<Animal> animals;

    private IWorldMap map;

    private int moveDelay;
    private App app;

    public SimulationEngine(MoveDirection[] animalMovements,IWorldMap map, Vector2d[] initialPositions, int moveDelay, App app){
        this.initialPositions = initialPositions;
        this.animals = new ArrayList<>();
        this.map = map;
        this.moveDelay = moveDelay;
        this.app = app;

        for(Vector2d position:initialPositions){
            Animal animal = new Animal(map, position);
            if(this.map.place(animal)){
                this.animals.add(animal);
            };
        }
    }



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

    public void addDirections(MoveDirection[] directions){
        this.animalMovements = directions;
    }



    public void run(){
        System.out.println("Threat started");
        System.out.println(this.map);
        for(int i=0; i < this.animalMovements.length; i++){
            Animal currentAnimal = this.animals.get(i % this.animals.size());
            currentAnimal.move(this.animalMovements[i]);
            System.out.println(this.map);
            System.out.println(map);
            app.refreshMap();

            try {
                Thread.sleep(moveDelay);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public Animal getAnimal(int noAnimal){
        return this.animals.get(noAnimal);
    }
}
