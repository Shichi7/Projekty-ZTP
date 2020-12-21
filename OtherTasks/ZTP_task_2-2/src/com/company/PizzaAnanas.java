package com.company;

public class PizzaAnanas extends Pizza
{
    public Pizza basePizza;
    private final static double cena_ananas =  3.25;

    public PizzaAnanas(Pizza basePizza)
    {
        this.basePizza  = basePizza;
        this.mnoznikZaSkladnik = basePizza.mnoznikZaSkladnik;
        this.currentString  = basePizza.currentString + "\n[Ananas]";
        this.cenaOstateczna = basePizza.cenaOstateczna + cena_ananas * basePizza.mnoznikZaSkladnik;
    }

}
