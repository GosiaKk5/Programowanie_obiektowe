package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    public SortedSet<IMapElement> xSet = new TreeSet<>((e1,e2) -> {
        if(e1.getPosition().x != e2.getPosition().x)
            return e1.getPosition().x - e2.getPosition().x;
        else
            return  e1.getPosition().y - e2.getPosition().y;
    });
    public SortedSet<IMapElement> ySet = new TreeSet<>((e1,e2) -> {
        if(e1.getPosition().y != e2.getPosition().y)
            return e1.getPosition().y - e2.getPosition().y;
        else
            return  e1.getPosition().x - e2.getPosition().x;
    });


    @Override
    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition) {
        this.remove(element);
        this.add(element);
    }

    public void add(IMapElement element){
        xSet.add(element);
        ySet.add(element);
    }

    public void remove(IMapElement element){
        xSet.remove(element);
        ySet.remove(element);
    }

    public Vector2d upperRight(){
        Vector2d position = new Vector2d(xSet.last().getPosition().x, ySet.last().getPosition().y );
        return position;
    }

    public Vector2d lowerLeft(){
        Vector2d position = new Vector2d(xSet.first().getPosition().x, ySet.first().getPosition().y );
        return position;
    }
}
