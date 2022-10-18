package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Vector2dTest {

    Vector2d vector1 = new Vector2d(1,2);
    Vector2d vector2 = new Vector2d(1,2);
    Vector2d vector3 = new Vector2d(-1,4);
    Vector2d vector4 = new Vector2d(-1,8);
    Vector2d vector5 = new Vector2d(8,10);
    Vector2d vector6 = new Vector2d(-8,-10);
    Vector2d vector7 = new Vector2d(0,0);


    @Test
    void testForEquals(){
        assertEquals(vector1, vector2);
        assertNotEquals(vector1, vector4);
        assertNotEquals(null, vector1);
    }

    @Test
    void testForToString(){
        assertEquals(vector1.toString(), "(1, 2)");
        assertEquals(vector2.toString(), "(1, 2)");
        assertEquals(vector3.toString(), "(-1, 4)");
        assertEquals(vector4.toString(), "(-1, 8)");
    }

    @Test
    void testForPrecedes(){
        assertTrue(vector3.precedes(vector5));
        assertTrue(vector4.precedes(vector4));
        assertFalse(vector4.precedes(vector3));

    }
    @Test
    void testForFollows(){
        assertFalse(vector3.follows(vector5));
        assertTrue(vector4.follows(vector4));
        assertTrue(vector4.follows(vector3));
    }
    @Test
    void testForUpperRight(){
        assertEquals(vector1.uperRight(vector2), new Vector2d(1,2));
        assertEquals(vector6.uperRight(vector7), new Vector2d(0,0));
        assertEquals(vector3.uperRight(vector4), new Vector2d(-1,8));
    }

    @Test
    void testForUpperLeft(){
        assertEquals(vector1.lowerLeft(vector2), new Vector2d(1,2));
        assertEquals(vector6.lowerLeft(vector7), new Vector2d(-8,-10));
        assertEquals(vector3.lowerLeft(vector4), new Vector2d(-1,4));
    }

    @Test
    void testForAdd(){
        assertEquals(vector1.add(vector2), new Vector2d(2,4));
        assertEquals(vector4.add(vector7), new Vector2d(-1,8));
        assertEquals(vector3.add(vector5), new Vector2d(7,14));

    }

    @Test
    void testForSubtract(){
        assertEquals(vector1.subtract(vector2), new Vector2d(0,0));
        assertEquals(vector4.subtract(vector7), new Vector2d(-1,8));
        assertEquals(vector3.subtract(vector5), new Vector2d(-9,-6));
    }

    @Test
    void testForOpposite(){
        assertEquals(vector5, vector6.opposite());
        assertNotEquals(vector1, vector1.opposite());
        assertEquals(vector7, vector7.opposite());
    }


}
