package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "czas")
public class Czas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_czas;
    private Date termin;

    public Czas() {
    }
    public Czas (Long id_czas, Date termin){
        this.id_czas = id_czas;
        this.termin = termin;
    }

    public Long getId_czas() {
        return id_czas;
    }

    public void setId_czas(Long id_czas) {
        this.id_czas = id_czas;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }
    @Override
    public String toString(){
        return "Termin: " + termin;
    }
}
