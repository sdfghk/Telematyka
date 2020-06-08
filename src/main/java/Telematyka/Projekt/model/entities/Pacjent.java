package Telematyka.Projekt.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pacjent")
public class Pacjent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pacjenta;
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String adres;
    private String kod_pocztowy;
    private String miejscowosc;
    private String numer_telefonu;


    public Pacjent() {
    }
    public Pacjent(Long id_pacjenta, String imie, String nazwisko, String PESEL) {
        this.id_pacjenta = id_pacjenta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miejscowosc = miejscowosc;
        this.numer_telefonu = numer_telefonu;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    @Override
    public String toString() {
        return "Pacjent" + '\n' + "Id pacjenta: " + id_pacjenta + '\n'
        +"Imię: " + imie + '\n' + "Nazwisko: " + nazwisko + '\n' + "PESEL: " + PESEL;
    }
}
