package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pacjent")
public class Pacjent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pacjenta;
    private String imie;
    private String nazwisko;
    private String PESEL;

    public Pacjent() {
    }
    public Pacjent(Long id_pacjenta, String imie, String nazwisko, String PESEL) {
        this.id_pacjenta = id_pacjenta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
    }

    public Long getId_pacjenta() {
        return id_pacjenta;
    }

    public void setId_pacjenta(Long id_pacjenta) {
        this.id_pacjenta = id_pacjenta;
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

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
    @Override
    public String toString() {
        return "Pacjent" + '\n' + "Id pacjenta: " + id_pacjenta + '\n'
        +"Imię: " + imie + '\n' + "Nazwisko: " + nazwisko + '\n' + "PESEL: " + PESEL;
    }
}
