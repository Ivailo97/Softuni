package RawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower){

        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return this.enginePower;
    }
}
