public class Drone {
    //this will provide important info about each of the drones
    private String name;
    private int radioFreq;
    private int GPStagID;
    public Drone(String name, int radioFreq, int GPStagID) {
        this.name = name;
        this.radioFreq = radioFreq;
        this.GPStagID = GPStagID;
    }
    public String getName() {
        return name;
    }
    public int getRadioFreq() {
        return radioFreq;
    }
    public int getGPStagID() {
        return GPStagID;
    }


}
