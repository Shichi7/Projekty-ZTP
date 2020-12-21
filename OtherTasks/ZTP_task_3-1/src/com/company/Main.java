package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static Random random = new Random();
    public static Uczelnia uczelnia = Uczelnia.randUczelnia(random, 1, 5);

    public static void main(String[] args)
    {
        //1 FILTER
        //przyklad1();

        //2 MAP
        przyklad2();

        //3 MAX/MIN
        //przyklad3();

        //4 GROUPING
        //przyklad4();

    }

    public static void przyklad1()
    {
        Wydzial wydzial = uczelnia.wydzialy.get(0);
        print(wydzial.getStudentsNamed("Ma"));
    }

    public static void przyklad2()
    {
        for(int i = 0; i<uczelnia.wydzialy.size(); i++)
        {
            System.out.println(uczelnia.wydzialy.get(i).getUczniowieString());
        }
    }

    public static void przyklad3()
    {
        for(int i = 0; i<uczelnia.wydzialy.size(); i++)
        {
            print(uczelnia.wydzialy.get(i).nazwa + " "+ uczelnia.wydzialy.get(i).numer + "   ilosc uczniow: [" + uczelnia.wydzialy.get(i).getIloscUczniow()+"]");
        }

        print("\n" + uczelnia.getWydzialMaxUczniowie());
    }

    public static void przyklad4()
    {
        Wydzial wydzial = uczelnia.wydzialy.get(0);
        print(wydzial.groupByName());
    }

    public static void print(String to_print)
    {
        System.out.println(to_print);
    }
}
