package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car( String model, Engine engine, Cargo cargo, Tire[] tires){

        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    @Override
    public String toString() {
        return this.model;
    }

    public Tire[] getTires() {
        return this.tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }
}
