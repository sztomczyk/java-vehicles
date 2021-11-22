package vehicles;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger logger
            = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) {
        List<Vehicle> vehicles = new LinkedList<Vehicle>();
        vehicles.add(new Vehicle(270.25, "BMW", "CAR"));
        vehicles.add(new Vehicle(150.13, "Fiat", "CAR"));
        vehicles.add(new Vehicle(22.5, "Hyundai", "SHIP"));
        vehicles.add(new Vehicle(30.3, "Daewoo", "SHIP"));
        vehicles.add(new Vehicle(740.12, "Beechcraft", "PLANE"));
        vehicles.add(new Vehicle(850.55, "Cessna", "PLANE"));
        vehicles.add(new Vehicle(30.1, "KROSS", "BICYCLE"));
        vehicles.add(new Vehicle(60.8, "TREK", "BICYCLE"));

        int choice = 0;

        do {
            choice = menu();

            switch (choice) {
                case 1:
                    Vehicle fastestCar = getFastestVehicle(vehicles, "CAR");
                    logger.info("Pojazd CAR producenta {} jest najszybszy (maksymalna predkosc to = {})", fastestCar.manufacturer, fastestCar.maxSpeed);
                    break;
                case 2:
                    Vehicle fastestShip = getFastestVehicle(vehicles, "SHIP");
                    logger.info("Pojazd SHIP producenta {} jest najszybszy (maksymalna predkosc to = {})", fastestShip.manufacturer, fastestShip.maxSpeed);
                    break;
                case 3:
                    Vehicle fastestPlane = getFastestVehicle(vehicles, "PLANE");
                    logger.info("Pojazd PLANE producenta {} jest najszybszy (maksymalna predkosc to = {})", fastestPlane.manufacturer, fastestPlane.maxSpeed);
                    break;
                case 4:
                    Vehicle fastestBicycle = getFastestVehicle(vehicles, "BICYCLE");
                    logger.info("Pojazd BICYCLE producenta {} jest najszybszy (maksymalna predkosc to = {})", fastestBicycle.manufacturer, fastestBicycle.maxSpeed);
                    break;
                case 5:
                    Vehicle fastestVehicle = getFastestVehicle(vehicles, "ALL");
                    logger.info("Pojazd {} producenta {} jest najszybszy (maksymalna predkosc to = {})",fastestVehicle.type, fastestVehicle.manufacturer, fastestVehicle.maxSpeed);
                    break;
                case 0:
                    //
                    break;
                default:
                    System.out.println("Podaj prawidłowa opcje!");
            }
        } while (choice != 0);
    }

    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Wybierz jedna z opcji");
        System.out.println("-------------------------");
        System.out.println("1 - CAR");
        System.out.println("2 - SHIP");
        System.out.println("3 - PLANE");
        System.out.println("4 - BICYCLE");
        System.out.println("5 - ALL");
        System.out.println("0 - QUIT");

        selection = input.nextInt();
        return selection;
    }

    public static Vehicle getFastestVehicle(List vehicles, String type) {
        List<Vehicle> toCompare = new LinkedList<Vehicle>();
        Iterator<Vehicle> itr = vehicles.iterator();
        while (itr.hasNext()) {
            Vehicle next = itr.next();
            if (next.type == type)
                toCompare.add(next);
        }

        return Collections.max(type == "ALL" ? vehicles : toCompare);
    }
}
