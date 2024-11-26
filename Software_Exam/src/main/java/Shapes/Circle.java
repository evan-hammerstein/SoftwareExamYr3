package Shapes;
import java.awt.*;

public class Circle extends Shape {
    private int radius;
    private String name = "Circle";

    public Circle(int radius, Point position, Color color) {
        super(position, color);
        this.radius = radius;
    }

    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(position.x, position.y, radius, radius);
    }


}
