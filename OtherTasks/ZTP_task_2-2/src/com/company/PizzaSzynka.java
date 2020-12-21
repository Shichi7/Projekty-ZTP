package com.company;

public class PizzaSzynka extends Pizza
{
    public Pizza basePizza;
    private final static double cena_szynka =  2.00;

    public PizzaSzynka(Pizza basePizza)
    {
        this.basePizza  = basePizza;
        this.mnoznikZaSkladnik = basePizza.mnoznikZaSkladnik;
        this.currentString  = basePizza.currentString + "\n[Pieczarki]";
        this.cenaOstateczna = basePizza.cenaOstateczna + cena_szynka * basePizza.mnoznikZaSkladnik;
    }
}

