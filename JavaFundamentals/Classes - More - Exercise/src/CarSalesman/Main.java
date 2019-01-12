package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] dataForEngines = reader.readLine().split(" ");
            String model = dataForEngines[0];
            int power = Integer.parseInt(dataForEngines[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            if (dataForEngines.length == 4) {

                displacement = dataForEngines[2];
                efficiency = dataForEngines[3];

            } else if (dataForEngines.length == 3) {

                try {
                    int disp = Integer.parseInt(dataForEngines[2]);
                    displacement = dataForEngines[2];

                } catch (Exception e) {
                    efficiency = dataForEngines[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }
        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {

            String[] data = reader.readLine().split(" ");
            String model = data[0];
            String engineModel = data[1];
            String weight = "n/a";
            String color = "n/a";

            if (data.length == 4) {

                weight = data[2];
                color = data[3];

            } else if (data.length == 3) {

                try {
                    int test = Integer.parseInt(data[2]);
                    weight = data[2];
                } catch (Exception e) {
                    color = data[2];
                }
            }

            Engine currentEngine = engines.stream().filter(x -> x.getModel().equals(engineModel)).findFirst().get();

            Car car = new Car(model, currentEngine, weight, color);

            cars.add(car);
        }
        for (Car car : cars) {

            System.out.print(car.toString());

        }
    }
}
