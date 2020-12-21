package com.company;

public class Potrawa
{
    protected String nazwa;
    private double waga;
    private double cena;
    private int jakosc;
    private boolean przeterminowane;

    public Potrawa(double waga, double cena, int jakosc, boolean przeterminowane)
    {
        this.nazwa = "POTRAWA";
        this.waga = waga;
        this.cena = cena;
        this.jakosc = jakosc;
        this.przeterminowane = przeterminowane;
    }

    @Override
    public String toString()
    {
         String string_value = "\n\n"+nazwa+"\nWaga: "+this.waga+"kg\nCena: "+this.cena+"zł\nJakość: "+jakosc+"/5\nPrzeterminowane: ";
         string_value += this.przeterminowane ? "TAK" : "NIE";
         string_value += "\n";
         return string_value;
    }
}
