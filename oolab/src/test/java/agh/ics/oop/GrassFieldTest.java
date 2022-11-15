package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    public void testIfAnimalsMovesCorrect(){
        String[] animalsMovements = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions =  OptionsParser.parse(animalsMovements);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IWorldMap map = new GrassField(10);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(2, -1)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(3, 7)));

        assertEquals(MapDirection.SOUTH, engine.getAnimal(0).getOrientation());
        assertEquals(MapDirection.NORTH, engine.getAnimal(1).getOrientation());

    }

    @Test
    public void testAnimalsAtTheSamePlace(){
        String[] animalsMovements = {"f"};
        MoveDirection[] directions =  OptionsParser.parse(animalsMovements);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
        IWorldMap map = new GrassField(10);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(2, 2)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(2, 3)));
    }

    @Test
    public void testGetMapCorner(){
        String[] animalsMovements = {};
        MoveDirection[] directions =  OptionsParser.parse(animalsMovements);
        Vector2d[] positions = {new Vector2d(1, 1), new Vector2d(2, 3),new Vector2d(-1, -1)};
        GrassField map = new GrassField(0);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertEquals(new Vector2d(2,3), map.getUpperRight());
        assertEquals(new Vector2d(-1,-1), map.getLowerLeft());
    }

}
