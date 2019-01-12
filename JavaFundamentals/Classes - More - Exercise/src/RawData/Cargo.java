package RawData;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type){

        this.type = type;
        this.weight = weight;
    }

    public String getType() {

        return this.type;
    }
}
