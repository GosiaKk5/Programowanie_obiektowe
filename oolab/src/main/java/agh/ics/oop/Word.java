package agh.ics.oop;
import java.util.*;

public class Word {

    public static void move2(String[] directions, Direction[] convDirections){
        for(int i = 0; i < directions.length; i++) {
            switch(directions[i]) {
                case "f":
                    convDirections[i] = Direction.FORWARD;
                    break;
                case "b":
                    convDirections[i] = Direction.BACKWARD;
                    break;
                case "l":
                    convDirections[i] = Direction.LEFT;
                    break;
                case "r":
                    convDirections[i] = Direction.RIGHT;
                    break;
                default:
                    convDirections[i] = Direction.NO;
            };
        }
    }
    public static void run (Direction[] convDirections){

        for(int i = 0; i < convDirections.length; i++){
            if (!convDirections[i].equals(Direction.NO)){
                System.out.println("zwierzak idzie " + convDirections[i]);
            }
        }
        }

    public static void animalMove(String[] args, Animal animal){
        MoveDirection[] moveDirectionsArray = OptionsParser.parse(args);

        for(MoveDirection direction:moveDirectionsArray){
            animal.move(direction);
            System.out.println(animal.toString());
        }
    }


    public static void main(String[] args) {
        /*
        System.out.println("system wystartował");
        Direction[] directions = new Direction[args.length];
        move2(args, directions);
        run(directions);
        System.out.println("system zakończył działanie");

        //lab2
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("North to " + MapDirection.NORTH.toString());
        System.out.println("Po NORTH jest " + MapDirection.NORTH.next());
        System.out.println("Przed NORTH jest " + MapDirection.NORTH.previous());
        System.out.println("Wektor NORTH to " + MapDirection.NORTH.toUnitVector());
*/
        //lab3
        /*Animal animal1 = new Animal();

        System.out.println(animal1.toString());
        System.out.println(animal1.isAt(new Vector2d(2,1)));
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);

        System.out.println(animal1.toString());

        animalMove(args, animal1);*/

        /*lab4*//*
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.println(map.toString());*/

        /*lab5*/
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.println(map.toString());


    }

}
