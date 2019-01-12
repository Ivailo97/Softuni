package softuni.bandregister.bindingModels;

public class BandBindingModel {

    private String name;

    private String members;

    private Double honorarium;

    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Double getHonorarium() {
        return honorarium;
    }

    public void setHonorarium(Double honorarium) {
        this.honorarium = honorarium;
    }

    public BandBindingModel(){

    }

    public  BandBindingModel(String members, String name, Double honorarium, String genre){
        this.name = name;
        this.members = members;
        this.honorarium = honorarium;
        this.genre = genre;
    }
}
