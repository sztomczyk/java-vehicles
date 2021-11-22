package vehicles;

public class Vehicle implements Comparable<Vehicle> {
    double maxSpeed;
    String manufacturer;
    String type;

    public Vehicle(double maxSpeed, String manufacturer, String type) {
        this.maxSpeed = maxSpeed;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.maxSpeed > o.maxSpeed)
            return 1;
        if (this.maxSpeed < o.maxSpeed)
            return -1;

        return 0;
    }
}
