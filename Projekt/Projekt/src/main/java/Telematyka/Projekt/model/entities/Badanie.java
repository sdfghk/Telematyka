package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "badanie")

public class Badanie {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_badania;
    private String rodzaj_badania;

    public Badanie() {
    }

    public Badanie(Long id_badania, String rodzaj_badania){
        this.id_badania = id_badania;
        this.rodzaj_badania = rodzaj_badania;
    }

    public Long getId_badania() {
        return id_badania;
    }

    public void setId_badania(Long id_badania) {
        this.id_badania = id_badania;
    }

    public String getRodzaj_badania() {
        return rodzaj_badania;
    }

    public void setRodzaj_badania(String rodzaj_badania) {
        this.rodzaj_badania = rodzaj_badania;
    }
    @Override
    public String toString() {
        return "Badanie " + '\n' + "id badania: " + id_badania + ' ' + "rodzaj badania: " + rodzaj_badania;
    }
}
