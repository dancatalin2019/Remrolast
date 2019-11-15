package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Client {
    private String c_Nume;
    private String c_Prenume;
    @Id
    private String c_cnp;
    private String serie_Buletin;
    private String c_nr_Telefon;
    private String c_Street;
    private String c_City;
    private String c_House_nr;

    public String getC_Street() {
        return c_Street;
    }

    public void setC_Street(String c_Street) {
        this.c_Street = c_Street;
    }

    public String getC_City() {
        return c_City;
    }

    public void setC_City(String c_City) {
        this.c_City = c_City;
    }

    public String getC_House_nr() {
        return c_House_nr;
    }

    public void setC_House_nr(String c_House_nr) {
        this.c_House_nr = c_House_nr;
    }

    public String getC_Nume() {
        return c_Nume;
    }

    public void setC_Nume(String c_Nume) {
        this.c_Nume = c_Nume;
    }

    public String getC_Prenume() {
        return c_Prenume;
    }

    public void setC_Prenume(String c_Prenume) {
        this.c_Prenume = c_Prenume;
    }

    public String getC_cnp() {
        return c_cnp;
    }

    public void setC_cnp(String c_cnp) {
        this.c_cnp = c_cnp;
    }

    public String getSerie_Buletin() {
        return serie_Buletin;
    }

    public void setSerie_Buletin(String serie_Buletin) {
        this.serie_Buletin = serie_Buletin;
    }

    public String getC_nr_Telefon() {
        return c_nr_Telefon;
    }

    public void setC_nr_Telefon(String c_nr_Telefon) {
        this.c_nr_Telefon = c_nr_Telefon;
    }

    @Override
    public String toString() {
        /*return "Client{" +
                "c_Nume='" + c_Nume + '\'' +
                ", c_Prenume='" + c_Prenume + '\'' +
                ", c_cnp='" + c_cnp + '\'' +
                ", serie_Buletin='" + serie_Buletin + '\'' +
                ", c_nr_Telefon='" + c_nr_Telefon + '\'' +
                '}';*/
        return c_cnp;

    }
}
