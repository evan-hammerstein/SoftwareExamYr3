public class Keeper {
    //this will describe the identity and how to contact the keepers in case of emergency
    private String name;
    private String phoneNumber;
    private int GPStagID;
    public Keeper(String name, String phoneNumber, int GPStagID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.GPStagID = GPStagID;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getGPStagID() {
        return GPStagID;
    }
}
