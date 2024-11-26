import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI {
    public static GraphicsConfiguration gc;
    public UI(Map map){
        JFrame frame = new JFrame(gc);
        frame.setSize(600,600);
        frame.add(map);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {    // Closes the program if close window clicked
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

}
