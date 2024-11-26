package Shapes;

import java.awt.*;

public class Shape implements Drawable{
    protected Point position;
    protected Color color;
    protected String name = "Shape";
    public Shape(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
    }

    public String toString() {
        return this.name;
    }


}
