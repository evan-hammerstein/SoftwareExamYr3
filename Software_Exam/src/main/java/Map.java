import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList.*;
import Shapes.Shape;
import Shapes.*;

public class Map extends JPanel {
    private ArrayList<Keeper> keepers = new ArrayList<>();
    private ArrayList<Lion> lions = new ArrayList<>();
    private ArrayList<Drone> drones = new ArrayList<>();
    private Graphics graphics;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<StringLabel> stringLabels = new ArrayList<>();
    private ArrayList<Point> keeperLocations = new ArrayList<>();
    private ArrayList<Point> lionLocations = new ArrayList<>();
    public Map(ArrayList<Keeper> keepers, ArrayList<Lion> lions, ArrayList<Drone> drones) {
        setBackground(Color.WHITE);
        this.keepers = keepers;
        this.lions = lions;
        this.drones = drones;
        for (Keeper keeper : keepers) {
            try {
                Point location = LocationSystem.getCoords(keeper.getGPStagID());
                keeperLocations.add(location);
                shapes.add(new Circle(2, location, Color.BLUE));
                stringLabels.add(new StringLabel(String.format("Name: %s  Phone Number: %s", keeper.getName(), keeper.getPhoneNumber()), location));
            } catch (IOException e) {
                System.out.println(e.getMessage());}}
        for (Lion lion : lions) {
            try {
                Point location = LocationSystem.getCoords(lion.getGPStagID());
                lionLocations.add(location);
                shapes.add(new Circle(2, location, Color.RED));
                stringLabels.add(new StringLabel(String.format("Name: %s  Age: %d", lion.getName(), lion.getAge()), location));
            } catch (IOException e) {
                System.out.println(e.getMessage());}}
        for (Drone drone : drones) {
            try {
                Point location = LocationSystem.getCoords(drone.getGPStagID());
                shapes.add(new Square(location, Color.BLACK, 3));
                stringLabels.add(new StringLabel(String.format("Name: %s  Freq: %dMHz", drone.getName(), drone.getRadioFreq()), location));
            } catch (IOException e) {System.out.println(e.getMessage());}
        }
    }

    public void refresh(){
        while(true) {
            shapes.clear();
            stringLabels.clear();
            keeperLocations.clear();
            lionLocations.clear();
            for (Keeper keeper : keepers) {
                try {
                    Point location = LocationSystem.getCoords(keeper.getGPStagID());
                    keeperLocations.add(location);
                    if (location != null) {
                        shapes.add(new Circle(2, location, Color.BLUE));
                        stringLabels.add(new StringLabel(String.format("Name: %s  Phone Number: %s", keeper.getName(), keeper.getPhoneNumber()), location));
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());}}
            for (Lion lion : lions) {
                try {
                    Point location = LocationSystem.getCoords(lion.getGPStagID());
                    lionLocations.add(location);
                    if (location != null) {
                        shapes.add(new Circle(2, location, Color.RED));
                        stringLabels.add(new StringLabel(String.format("Name: %s  Age: %d", lion.getName(), lion.getAge()), location));
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());}}
            for (Drone drone : drones) {
                try {
                    Point location = LocationSystem.getCoords(drone.getGPStagID());
                    if (location != null) {
                    shapes.add(new Square(location, Color.BLACK, 3));
                    stringLabels.add(new StringLabel(String.format("Name: %s  Freq: %dMHz", drone.getName(), drone.getRadioFreq()), location));}
                } catch (IOException e) {System.out.println(e.getMessage());}
            }
            //sending alarms to keepers and drones
            for (Point keeperLocation: keeperLocations) {
                for (Point lionLocation : lionLocations) {
                    //calculate the distance between keeper and each lion
                    if (keeperLocation != null && lionLocation != null) {
                        double verticalDistance = Math.abs(keeperLocation.y - lionLocation.y);
                        double horizontalDistance = Math.abs(keeperLocation.x - lionLocation.x);
                        if (Math.hypot(horizontalDistance, verticalDistance) < 60) {
                            //find the associated keepers phone number and alert
                            AlertSystem.alertAKeeper(keepers.get(keeperLocations.indexOf(keeperLocation)).getPhoneNumber());
                            //alert all drones
                            for (Drone drone : drones) {
                                AlertSystem.alertADrone(drone.getRadioFreq());
                            }
                        }
                    }
                }
            }
            repaint();
            try{Thread.sleep(1000);}
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.graphics = g; //Clear the panel
        g.setFont(new Font("Times New Roman", 1, 7));
        for (Shape shape : shapes){
            shape.draw(g);
        }
        for (StringLabel stringLabel : stringLabels){
            stringLabel.draw(g);
        }
    }
}
