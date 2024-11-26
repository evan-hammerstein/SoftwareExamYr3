package Shapes;

import java.awt.*;
public class Rectangle extends Shape {
    protected int width;
    protected int height;
    protected String name = "Rectangle";
    public Rectangle(Point position, Color color, int width, int height) {
        super(position, color);
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics g){
        super.draw(g);
        g.fillRect(position.x, position.y, width, height);
    }
}
