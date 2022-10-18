package agh.ics.oop;

public class Word {

    public static void move(String[] directions, Direction[] convDirections){
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


    public static void main(String[] args) {
        System.out.println("system wystartował");
        Direction[] directions = new Direction[args.length];
        move(args, directions);
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

    }

}
