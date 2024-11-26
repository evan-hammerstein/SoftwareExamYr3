public class Lion {
    //this will provide the data about each lion in the park
    private String name;
    private int age;
    private int GPStagID;
    public Lion(String name, int age, int GPStagID) {
        this.name = name;
        this.age = age;
        this.GPStagID = GPStagID;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getGPStagID() {
        return GPStagID;
    }
}
