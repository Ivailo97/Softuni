package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {

        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;

    }

    public String getModel() {
        return this.model;
    }


    @Override
    public String toString() {
        return String.format("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s\n"
                , this.model, this.engine.getModel(), this.engine.getPower(), this.engine.getDisplacement(), this.engine.getEfficiency()
                , this.weight, this.color);
    }
}
