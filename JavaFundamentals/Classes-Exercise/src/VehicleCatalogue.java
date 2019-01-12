import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> catalogue = new ArrayList<>();

        while (true) {
            String[] tokens = scanner.nextLine().split(" ");

            if (tokens[0].equals("End")) {
                break;
            }

            String type = tokens[0];

            if (type.toLowerCase().equals("truck")) {
                type = "Truck";
            } else {
                type = "Car";
            }

            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);


            catalogue.add(vehicle);
        }

        while (true) {
            String model = scanner.nextLine();

            if (model.equals("Close the Catalogue")) {
                break;
            }

            Vehicle currentVehicle = catalogue.stream().filter(x -> x.Model.equals(model)).findFirst().orElse(null);

            System.out.printf("Type: %s%n", currentVehicle.Type);
            System.out.printf("Model: %s%n", currentVehicle.Model);
            System.out.printf("Color: %s%n", currentVehicle.Color);
            System.out.printf("Horsepower: %s%n", currentVehicle.HorsePower);
        }

        double truckTotalHorsepower = 0;
        double totalTrucks = 0;
        double carTotalHorsepower = 0;
        double totalCars = 0;

        for (var vehicle : catalogue) {
            if (vehicle.Type.equals("Truck")) {
                totalTrucks++;
                truckTotalHorsepower += vehicle.HorsePower;
            } else {
                totalCars++;
                carTotalHorsepower += vehicle.HorsePower;
            }
        }

        double averageTruckHorsepower = 0;
        double averageCarHorsepower = 0;

        if (truckTotalHorsepower != 0) {
            averageTruckHorsepower = truckTotalHorsepower / totalTrucks;
        }

        if (carTotalHorsepower != 0) {
            averageCarHorsepower = carTotalHorsepower / totalCars;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTruckHorsepower);
    }
}

class Vehicle {
    public String Type;
    public String Model;
    public String Color;
    public int HorsePower;

    public Vehicle(String type, String model, String color, int horsePower) {

        this.Type = type;
        this.Color = color;
        this.Model = model;
        this.HorsePower = horsePower;
    }
}
