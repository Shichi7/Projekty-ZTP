package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Uczelnia
{
    private static final String[] mozliwe_nazwy = {"Wrocławska", "Słupska", "Warszawska", "Krakowska", "Zielonogórska"};

    private String nazwa;
    private int numer;
    public ArrayList<Wydzial> wydzialy;

    private Uczelnia(int numer, String nazwa , ArrayList<Wydzial> wydzialy)
    {
        this.nazwa = nazwa;
        this.numer = numer;
        this.wydzialy = wydzialy;
    }

    public String toString()
    {
        String string = "Uczelnia "+nazwa+" "+numer + "\n";
        string += "Wydzialy: \n";
        for (Wydzial wydzial : wydzialy)
        {
            string+=wydzial+"\n";
        }
        return string;
    }

    public static Uczelnia randUczelnia(Random rand, int numer, int ilosc_wydzialow)
    {
        String nazwa = mozliwe_nazwy[rand.nextInt(mozliwe_nazwy.length)];
        ArrayList<Wydzial> wydzialy = new ArrayList<>();
        for (int i = 0; i<ilosc_wydzialow; i++)
        {
            wydzialy.add(Wydzial.randWydzial(rand, i));
        }

        return new Uczelnia(numer, nazwa, wydzialy);
    }

    public String getWydzialMaxUczniowie()
    {
        Wydzial wydzial_max = wydzialy.stream().max(Comparator.comparing(Wydzial::getIloscUczniow)).get();
        return wydzial_max.nazwa + " " + wydzial_max.numer;
    }
}
