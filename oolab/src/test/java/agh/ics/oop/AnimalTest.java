package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AnimalTest {

    Animal animal = new Animal();

    @Test
    public void testOrientation(){

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal.getOrientation());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal.getOrientation());
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void testPosition(){

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3), animal.getPosition());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3,3), animal.getPosition());
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,3), animal.getPosition());
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(3,3), animal.getPosition());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(3,4), animal.getPosition());

    }

    @Test
    public void testAnimalOutside(){

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,4), animal.getPosition());

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0,0), animal.getPosition());
    }

    @Test
    public void testPerse(){
        String[] stringDirections = new String[]{"forward", "eeee", "l", "r", "cos", "left"};
        MoveDirection[] moveDirections = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(moveDirections, OptionsParser.parse(stringDirections));
    }




}
