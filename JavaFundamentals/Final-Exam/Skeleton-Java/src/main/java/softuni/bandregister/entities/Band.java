package softuni.bandregister.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;


@Entity
@Table(name = "bands")
public class Band {

    private Integer id;

    private String name;

    private String members;

    private Double honorarium;

    private String genre;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    @Column(nullable = false)
    @DecimalMin("1.0")
    public Double getHonorarium() {
        return honorarium;
    }

    public void setHonorarium(Double honorarium) {
        this.honorarium = honorarium;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(nullable = false)
    public String getGenre() {
        return genre;
    }

    public Band() {
    }

    public Band(String name, String members, Double honorarium, String genre) {
        this.name = name;
        this.members = members;
        this.honorarium = honorarium;
        this.genre = genre;
    }
}