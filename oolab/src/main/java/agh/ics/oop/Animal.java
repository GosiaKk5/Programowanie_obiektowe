package agh.ics.oop;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public String toString(){
        return position.toString() + " " + orientation;
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
                if (newPosition.precedes(new Vector2d(4, 4)) && newPosition.follows(new Vector2d(0,0))) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                newPosition = this.position.subtract(orientation.toUnitVector());
                if (newPosition.precedes(new Vector2d(4, 4)) && newPosition.follows(new Vector2d(0,0))) {
                    this.position = newPosition;
                }
            }
        }
    }
}

