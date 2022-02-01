package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;


public class ShapeFactory {

    public static Shape create(RegularShapeType type){
        Shape result;
        switch (type) {
            case Triangle:
                result = new Triangle(3);
                break;
            case Quadrilateral:
                result = new Quadrilateral(4);
                break;
            case Pentagon:
                result = new Pentagon(5);
                break;
            case Hexagon:
                result =  new Hexagon(6);
                break;
            default:
                result = null;
        }
        return result;
    }
}
