package edu.eci.cvds.patterns.shapes.concrete;
import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    private int edges;
    public Triangle(int edges){
        this.edges=edges;
    }
    public int getNumberOfEdges() {
        return edges;
    }
}