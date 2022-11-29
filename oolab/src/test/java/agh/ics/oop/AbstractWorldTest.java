package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbstractWorldTest {

    @Test
    public void testPlaceException(){
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    GrassField map = new GrassField(10);
                    Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };

                    for(Vector2d position:positions) {
                        Animal animal = new Animal(map, position);
                        map.place(animal);
                    }
                });
    }

}
