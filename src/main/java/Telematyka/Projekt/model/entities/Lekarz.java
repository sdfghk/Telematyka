package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "lekarz")

public class Lekarz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_lekarza;
    private String imie;
    private String nazwisko;
    private String specjalizacja;

    public Lekarz() {
    }

    public Lekarz(Long id_lekarza, String imie, String nazwisko, String specjalizacja){
        this.id_lekarza = id_lekarza;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.specjalizacja = specjalizacja;
    }

    public Long getId_lekarza() {
        return id_lekarza;
    }

    public void setId_lekarza(Long id_lekarza) {
        this.id_lekarza = id_lekarza;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
    @Override
    public String toString() {
        return "Lekarz: " + id_lekarza  + imie + " " + nazwisko + " " + specjalizacja;
    }
}
