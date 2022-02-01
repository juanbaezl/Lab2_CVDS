package edu.eci.cvds.patterns.shapes.concrete;
import edu.eci.cvds.patterns.shapes.Shape;

public class Quadrilateral implements Shape {
    private int edges;
    public Quadrilateral(int edges){
        this.edges=edges;
    }
    public int getNumberOfEdges() {
        return edges;
    }
}