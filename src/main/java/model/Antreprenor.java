package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Antreprenor {
    private String A_nume;
    private String A_prenume;
    private String strada;
    private String A_nr_Casa;
    private String A_city;
    @Id
    private String cnp;
    private String serie_Buletin;
    private String A_telefon;

    public String getA_nume() {
        return A_nume;
    }

    public void setA_nume(String a_nume) {
        A_nume = a_nume;
    }

    public String getA_prenume() {
        return A_prenume;
    }

    public void setA_prenume(String a_prenume) {
        A_prenume = a_prenume;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSerie_Buletin() {
        return serie_Buletin;
    }

    public void setSerie_Buletin(String serie_Buletin) {
        this.serie_Buletin = serie_Buletin;
    }

    public String getA_telefon() {
        return A_telefon;
    }

    public void setA_telefon(String a_telefon) {
        A_telefon = a_telefon;
    }

    public String getA_nr_Casa() {
        return A_nr_Casa;
    }

    public void setA_nr_Casa(String a_nr_Casa) {
        A_nr_Casa = a_nr_Casa;
    }

    public String getA_city() {
        return A_city;
    }

    public void setA_city(String a_city) {
        A_city = a_city;
    }

    @Override
    public String toString() {
        return cnp ;
    }
}
