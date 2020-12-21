package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wydzial {
    private static final String[] mozliwe_nazwy = {"Mechaniczny", "Informatyczny", "Matematyczny", "Biologiczny", "Historyczny", "Biomechaniczny", "Bioinformatyczny", "Artystyczny"};

    String nazwa;
    int numer;
    public ArrayList<Uczen> uczniowie;

    private Wydzial(int numer, String nazwa, ArrayList<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
        this.nazwa = nazwa;
        this.numer = numer;
    }


    public String toString() {
        String string = "   Wydzial " + nazwa + " " + numer + "\n\n";
        string += "   Uczniowie: \n";
        for (Uczen uczen : uczniowie) {
            string += uczen + "\n";
        }
        return string;
    }

    public List<String> getUczniowieString()
    {
        List<String> lines = uczniowie.stream().map(uczen ->  uczen.toString() + nazwa + " " + numer +"\n\n").collect(Collectors.toList());

        return lines;
    }

    public static Wydzial randWydzial(Random rand, int numer) {
        String nazwa = mozliwe_nazwy[rand.nextInt(mozliwe_nazwy.length)];
        ArrayList<Uczen> uczniowie = new ArrayList<>();
        int ilosc_studentow = rand.nextInt(80) + 20;

        for (int i = 0; i < ilosc_studentow; i++) {
            uczniowie.add(Uczen.randUczen(rand, i));
        }

        return new Wydzial(numer, nazwa, uczniowie);
    }

    public String getStudentsNamed(String beggining)
    {
        int length = beggining.length();
        List<Uczen> filtered = uczniowie.stream().filter(student -> (student.imie).substring(0, (student.imie.length() < length ? 0 : length)).equals(beggining)).collect(Collectors.toList());

        String result = "\nStudenci na ["+beggining+"]:\n\n";
        for (int i = 0; i<filtered.size(); i++)
        {
            result+=filtered.get(i).toString() + "\n";
        }
        return result;
    }

    public String groupByName()
    {
        String result = "";
        Map<String, Long> grouped = uczniowie.stream().collect(Collectors.groupingBy(Uczen::getName, Collectors.counting()));

        for (Map.Entry<String,Long> entry : grouped.entrySet())
        {
            result += entry.getKey() + " - ilość powtórzeń: [" + entry.getValue() + "]\n";
        }
        return result;
    }

    public int getIloscUczniow()
    {
        return uczniowie.size();
    }
}
