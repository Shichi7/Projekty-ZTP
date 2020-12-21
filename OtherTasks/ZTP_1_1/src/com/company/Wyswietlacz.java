package com.company;

import java.util.ArrayList;

public class Wyswietlacz {

    public static void main(String[] args)
    {
        Kontener<Potrawa> kontener_potraw = new Kontener<Potrawa>();
        Kontener<Zupa> kontener_zup = new Kontener<Zupa>();
        Kontener<Ogorkowa> kontener_ogorkowych = new Kontener<Ogorkowa>();

        kontener_potraw.dodajPotrawe(new Potrawa(2, 35, 4, false));
        kontener_potraw.dodajPotrawe(new Potrawa(1.5, 20, 3, false));
        kontener_potraw.dodajPotrawe(new Potrawa(1, 30, 1, true));

        kontener_zup.dodajPotrawe(new Zupa(1, 2, 35, 4, false));
        kontener_zup.dodajPotrawe(new Zupa(2, 1.5, 20, 3, false));
        kontener_zup.dodajPotrawe(new Zupa(3, 1, 30, 1, true));

        kontener_ogorkowych.dodajPotrawe(new Ogorkowa(1, 1, 2, 35, 4, false));
        kontener_ogorkowych.dodajPotrawe(new Ogorkowa(2,2, 1.5, 20, 3, false));
        kontener_ogorkowych.dodajPotrawe(new Ogorkowa(3,3, 1, 30, 1, true));

        wyswietlPotrawy(kontener_potraw);
        wyswietlPotrawy(kontener_zup);
        wyswietlPotrawy(kontener_ogorkowych);

        //wyswietlZupy(kontener_potraw);        oczekiwany błąd kompilacji
        wyswietlZupy(kontener_zup);
        wyswietlZupy(kontener_ogorkowych);

        //wyswietlOgorkowe(kontener_potraw);         oczekiwany błąd kompilacji
        //wyswietlOgorkowe(kontener_zup);            oczekiwany błąd kompilacji
        wyswietlOgorkowe(kontener_ogorkowych);
    }


    public static void wyswietlPotrawy(Kontener<? extends Potrawa> kontener)
    {
        System.out.println("~~KONTENER POTRAW~~");
        for (Potrawa potrawa : kontener.zwrocListe())
        {
            System.out.println(potrawa);
        }
    }

    public static void wyswietlZupy(Kontener<? extends Zupa> kontener)
    {
        System.out.println("~~KONTENER ZUP~~");
        for (Zupa zupa : kontener.zwrocListe())
        {
            System.out.println(zupa);
        }
    }

    public static void wyswietlOgorkowe(Kontener<Ogorkowa> kontener)
    {
        System.out.println("~~KONTENER OGÓRKOWYCH~~");
        for (Ogorkowa ogorkowa : kontener.zwrocListe())
        {
            System.out.println(ogorkowa);
        }
    }

    /*public static void wyswietl(Kontener kontener)
    {
        System.out.println("~~KONTENER~~");
        for (Potrawa potrawa : (ArrayList<Potrawa>)kontener.zwrocListePotraw())
        {
            System.out.println(potrawa);
        }
    }*/
}
