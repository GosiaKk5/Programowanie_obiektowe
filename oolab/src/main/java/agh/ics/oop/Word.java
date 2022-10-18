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

    }

}