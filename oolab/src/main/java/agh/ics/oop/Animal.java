package agh.ics.oop;

public class Animal implements IMapElement {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }

//    public Animal(){
//        this(null);
//    }


    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        Vector2d newPosition;
        switch (direction){
            case RIGHT -> this.orientation = orientation.next();
            case LEFT -> this.orientation = orientation.previous();
            case FORWARD -> {
                newPosition = this.position.add(orientation.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                newPosition = this.position.subtract(orientation.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
        }
    }
}

