package com.company;

public class PizzaPieczarki extends Pizza{

    public Pizza basePizza;
    private final static double cena_pieczarki =  2.75;

    public PizzaPieczarki(Pizza basePizza)
    {
        this.basePizza  = basePizza;
        this.mnoznikZaSkladnik = basePizza.mnoznikZaSkladnik;
        this.currentString  = basePizza.currentString + "\n[Pieczarki]";
        this.cenaOstateczna = basePizza.cenaOstateczna + cena_pieczarki * basePizza.mnoznikZaSkladnik;
    }
}
