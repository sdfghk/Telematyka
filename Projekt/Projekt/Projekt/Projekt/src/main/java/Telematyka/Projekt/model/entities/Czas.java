package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "czas")
public class Czas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String termin;

    public Czas() {
    }
    public Czas (String termin){
        this.termin = termin;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }
    @Override
    public String toString(){
        return "Termin: " + termin;
    }
}
