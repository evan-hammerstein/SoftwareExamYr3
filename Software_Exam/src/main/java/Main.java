import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //creating arraylists to store future additions to instances
        ArrayList<Keeper> keepers = new ArrayList<>();
        ArrayList<Lion> lions = new ArrayList<>();
        ArrayList<Drone> drones = new ArrayList<>();

        //instantiating the given objects and adding to intended lists
        Keeper geoff = new Keeper("Geoff","4392",80);
        keepers.add(geoff);
        Lion simba = new Lion("Simba",7,30);
        lions.add(simba);
        Drone monitor1 = new Drone("Monitor1", 128, 124);
        drones.add(monitor1);
        Map map = new Map(keepers, lions, drones);
        UI ui = new UI(map);
        map.refresh();


    }
}