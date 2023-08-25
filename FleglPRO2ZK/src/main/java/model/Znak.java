package model;

public class Znak {

    private int absCetnost;
    private double relCetnost;
    private String nazev;

    private int pocet;

    public Znak(String nazev, int pocet) {
        this.nazev = nazev;
        this.pocet = pocet;
    }

    public Znak(String nazev, int absCetnost, double relCetnost) {
        this.absCetnost = absCetnost;
        this.relCetnost = relCetnost;
        this.nazev = nazev;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getAbsCetnost() {
        return absCetnost;
    }

    public void setAbsCetnost(int absCetnost) {
        this.absCetnost = absCetnost;
    }

    public double getRelCetnost() {
        return relCetnost;
    }

    public void setRelCetnost(int relCetnost) {
        this.relCetnost = relCetnost;
    }
}
