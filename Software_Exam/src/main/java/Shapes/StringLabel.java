package Shapes;
import java.awt.*;

public class StringLabel implements Drawable{
    private Point position;
    private String name = "StringLabels";
    private String message;
    public StringLabel(String message, Point position) {
        this.message = message;
        this.position = position;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(message, position.x, position.y);
    }


}