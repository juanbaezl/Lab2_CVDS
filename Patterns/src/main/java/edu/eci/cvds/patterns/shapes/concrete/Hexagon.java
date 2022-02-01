package edu.eci.cvds.patterns.shapes.concrete;
import edu.eci.cvds.patterns.shapes.Shape;

public class Hexagon implements Shape{
    private int edges;
    public Hexagon(int edges){
        this.edges=edges;
    }
    public int getNumberOfEdges() {
        return edges;
    }
}
