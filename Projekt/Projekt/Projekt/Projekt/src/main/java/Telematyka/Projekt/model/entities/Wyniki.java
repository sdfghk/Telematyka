package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "wyniki")

public class Wyniki {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_wyniku;
    private Long id_p;
    private Long id_b;
    private Long id_l;
    private String termin_b;
    private String opis_wyniku;

    public Wyniki(){
    }
    public Wyniki (Long id_wyniku, Long id_p, Long id_b, Long id_l, String termin_b, String opis_wyniku){
        this.id_wyniku = id_wyniku;
        this.id_p = id_p;
        this.id_b = id_b;
        this.id_l = id_l;
        this.termin_b = termin_b;
        this.opis_wyniku = opis_wyniku;
    }

    public Long getId_wyniku() {
        return id_wyniku;
    }

    public void setId_wyniku(Long id_wyniku) {
        this.id_wyniku = id_wyniku;
    }

    public Long getId_p() {
        return id_p;
    }

    public void setId_p(Long id_p) {
        this.id_p = id_p;
    }

    public Long getId_b() {
        return id_b;
    }

    public void setId_b(Long id_b) {
        this.id_b = id_b;
    }

    public Long getId_l() {
        return id_l;
    }

    public void setId_l(Long id_l) {
        this.id_l = id_l;
    }

    public String getTermin_b() {
        return termin_b;
    }

    public void setTermin_b(String termin_b) {
        this.termin_b = termin_b;
    }

    public String getOpis_wyniku() {
        return opis_wyniku;
    }

    public void setOpis_wyniku(String opis_wyniku) {
        this.opis_wyniku = opis_wyniku;
    }
    @Override
    public String toString(){
        return "Id wyniku: " + id_wyniku + '\n' + "Id pacjenta: " + id_p + '\n' + "Id badania: " + id_b + '\n'
                + " Id lekarza: " + id_l + '\n' + "Termin badania: " + termin_b + '\n' +
    "Opis wyniku: " + opis_wyniku;

    }
}
