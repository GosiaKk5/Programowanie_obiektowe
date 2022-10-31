package agh.ics.oop;
import java.util.*;

public class OptionsParser {

    public static MoveDirection[] parse(String[] stringDirections){

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
            }
        }

        MoveDirection[] moveDirectionsArray = new MoveDirection[moveDirections.size()];
        moveDirections.toArray(moveDirectionsArray);

        return moveDirectionsArray;
    }
}
