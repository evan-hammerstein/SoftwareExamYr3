package Shapes;

import java.awt.*;
public class Square extends Rectangle {
    protected String name = "Square";
    public Square(Point position, Color color, int dim){

        super(position,color, dim, dim);
    }

}
