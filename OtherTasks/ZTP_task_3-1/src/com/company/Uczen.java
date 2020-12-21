package com.company;

import java.util.Random;

public class Uczen
{
    private static final String[] mozliwe_imiona = {"Anton", "Aleksander", "Aleksandra", "Paweł", "Małgorzata", "Aleksandra", "Bartłomiej", "Zygmunt", "Alicja", "Krzysztof"
    ,"Błażej", "Miłosz", "Olga", "Roman", "Adam", "Dominik", "Natalia", "Weronika"};

    private static final String[] mozliwe_nazwiska = {"Nowak", "Kowalski/a", "Wiśniewski/a", "Wójcik", "Kowalczyk", "Kamiński/a", "Lewandowski/a", "Zieliński/a", "Szymańska/i", "Dąbrowska/i"
            ,"Kozłowska/i", "Jankowska/i", "Mazur ", "Kwiatkowska/i", "Wojciechowska/i", "Krawczyk", "Kaczmarek", "Piotrowska/i"};

    int numer_indeksu;
    String imie;
    String nazwisko;

    private Uczen(int indeks, String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer_indeksu = indeks;
    }

    public String getName()
    {
        return imie;
    }

    public String toString()
    {
        String string = imie + "\n";
        string += nazwisko + "\n";
        string += numer_indeksu + "\n";

        return string;
    }

    public static Uczen randUczen(Random rand, int indeks)
    {
        String imie = mozliwe_imiona[rand.nextInt(mozliwe_imiona.length)];
        String nazwisko = mozliwe_nazwiska[rand.nextInt(mozliwe_nazwiska.length)];
        return new Uczen(indeks, imie, nazwisko);
    }
}
