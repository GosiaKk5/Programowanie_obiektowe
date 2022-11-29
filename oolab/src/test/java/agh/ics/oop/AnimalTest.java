package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    RectangularMap map = new RectangularMap(4,4);
    Vector2d initialPosition = new Vector2d(2,2);
    Animal animal = new Animal(map, initialPosition);

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
    public void testParseException(){
        String[] stringDirections = new String[]{"forward", "eeee", "l", "r", "cos", "left"};
        MoveDirection[] moveDirections = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    OptionsParser.parse(stringDirections);
                });
    }

    @Test
    public void testParseNoException(){
        String[] stringDirections = new String[]{"forward", "l", "r", "left"};
        MoveDirection[] moveDirections = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(moveDirections, OptionsParser.parse(stringDirections));
    }


}
