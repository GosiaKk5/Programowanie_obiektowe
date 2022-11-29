package agh.ics.oop;
import java.util.*;

public class OptionsParser {

    public static MoveDirection[] parse(String[] stringDirections) throws IllegalArgumentException {

        List<MoveDirection> moveDirections = new ArrayList<MoveDirection>();

        for(String directions:stringDirections){
            switch (directions){
                case "f", "forward" -> {
                    moveDirections.add(MoveDirection.FORWARD);
                }
                case "b", "backward" -> {
                    moveDirections.add(MoveDirection.BACKWARD);
                }
                case "l", "left" -> {
                    moveDirections.add(MoveDirection.LEFT);
                }
                case "r", "right" -> {
                    moveDirections.add(MoveDirection.RIGHT);
                }
                default -> {
                    throw new IllegalArgumentException(directions + " is not legal move specification");
                }
            }
        }

        MoveDirection[] moveDirectionsArray = new MoveDirection[moveDirections.size()];
        moveDirections.toArray(moveDirectionsArray);

        return moveDirectionsArray;

        /*ROZIAZANIE Z STREAM*/ /*
        Arrays.stream(stringDirections)
                .map(instruction -> switch(instruction){
                    case "f", "forward" -> {
                        MoveDirection.FORWARD;
                    }
                    case "b", "backward" -> {
                        MoveDirection.BACKWARD;
                    }
                    case "l", "left" -> {
                        MoveDirection.LEFT;
                    }
                    case "r", "right" -> {
                        MoveDirection.RIGHT;
                    }
                    default -> null;

                })
                .filter(Objects::nonNull).toArray(MoveDirection[]::new);
                */
    }
}
