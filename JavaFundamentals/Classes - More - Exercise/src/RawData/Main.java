package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            String[] rawData = reader.readLine().split(" ");
            String model = rawData[0];
            int engineSpeed = Integer.parseInt(rawData[1]);
            int enginePower = Integer.parseInt(rawData[2]);
            int cargoWeight = Integer.parseInt(rawData[3]);
            String cargoType = rawData[4];
            Double tirePressure1 = Double.parseDouble(rawData[5]);
            int tireAge1 = Integer.parseInt(rawData[6]);
            Double tirePressure2 = Double.parseDouble(rawData[7]);
            int tireAge2 = Integer.parseInt(rawData[8]);
            Double tirePressure3 = Double.parseDouble(rawData[9]);
            int tireAge3 = Integer.parseInt(rawData[10]);
            Double tirePressure4 = Double.parseDouble(rawData[11]);
            int tireAge4 = Integer.parseInt(rawData[12]);
            Tire tire1 = new Tire(tirePressure1, tireAge1);
            Tire tire2 = new Tire(tirePressure2, tireAge2);
            Tire tire3 = new Tire(tirePressure3, tireAge3);
            Tire tire4 = new Tire(tirePressure4, tireAge4);
            Tire[] tires = new Tire[]{tire1, tire2, tire3, tire4};
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String type = reader.readLine();

        switch (type) {

            case "fragile":
                cars.stream().filter(x -> x.getCargo().getType().equals(type)
                        && Arrays.stream(x.getTires()).anyMatch(e -> e.getPressure() < 1))
                        .forEach(c -> System.out.println(c.toString()));
                break;
            case "flamable":
                cars.stream().filter(x -> x.getCargo().getType().equals(type)
                        && x.getEngine().getEnginePower() > 250).forEach(c -> System.out.println(c.toString()));
                break;
        }
    }
}
