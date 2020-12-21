package com.company;

import com.rits.cloning.Cloner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {



    public static void main(String[] args)
    {

        Random random = new Random();
        boolean print_data = false;
        int liczba_uczelni = 10;
        int liczba_wydzialow = 10;
        int liczba_studentow = 1000;

        long startTime = System.nanoTime();

        //TEST 1 KOPIA PLYTKA
        //TEST 2 GLEBOKA KONSTRUKTORY KOPIUJACE
        //TEST 3 GLEBOKA GOTOWA BIBLIOTEKA
        test4(random, liczba_uczelni, liczba_wydzialow, liczba_studentow, print_data);

        long endTime   = System.nanoTime();
        double totalTime = (endTime - startTime)/1000000000.0;

        System.out.println("TOTAL TIME: ["+ new DecimalFormat("#0.0000").format(totalTime)+"]s");
    }

    public static void test1(Random random, int liczba_uczelni, int liczba_wydzialow, int liczba_studentow, boolean print_data)
    {
        ArrayList<Uczelnia> uczelnie1, uczelnie2;
        uczelnie1 = randData(random, liczba_uczelni, liczba_wydzialow, liczba_studentow);
        uczelnie2 = uczelnie1; //shallow copy

        String przed = uczelnieRowne(uczelnie1, uczelnie2);
        zmienImieStudenta(uczelnie1, 0,0,0, "Test");
        String po = uczelnieRowne(uczelnie1, uczelnie2);

        printResults(uczelnie1, uczelnie2, przed, po, print_data);

    }

    public static void test2(Random random, int liczba_uczelni, int liczba_wydzialow, int liczba_studentow, boolean print_data)
    {
        ArrayList<Uczelnia> uczelnie1, uczelnie2;

        uczelnie1 = randData(random, liczba_uczelni, liczba_wydzialow, liczba_studentow);
        uczelnie2 = kopiaGleboka1(uczelnie1);

        String przed = uczelnieRowne(uczelnie1, uczelnie2);
        zmienImieStudenta(uczelnie1, 0,0,0, "Test");
        String po = uczelnieRowne(uczelnie1, uczelnie2);

        printResults(uczelnie1, uczelnie2, przed, po, print_data);
    }

    public static void test3(Random random, int liczba_uczelni, int liczba_wydzialow, int liczba_studentow, boolean print_data)
    {
        ArrayList<Uczelnia> uczelnie1, uczelnie2;

        Cloner cloner= new Cloner();
        uczelnie1 = randData(random, liczba_uczelni, liczba_wydzialow, liczba_studentow);
        uczelnie2 = cloner.deepClone(uczelnie1);

        String przed = uczelnieRowne(uczelnie1, uczelnie2);
        zmienImieStudenta(uczelnie1, 0,0,0, "Test");
        String po = uczelnieRowne(uczelnie1, uczelnie2);

        printResults(uczelnie1, uczelnie2, przed, po, print_data);
    }

    public static void test4(Random random, int liczba_uczelni, int liczba_wydzialow, int liczba_studentow, boolean print_data)
    {
        boolean success = true;
        ArrayList<Uczelnia> uczelnie1, uczelnie2;

        uczelnie1 = randData(random, liczba_uczelni, liczba_wydzialow, liczba_studentow);
        try
        {
            uczelnie2 = kopiaGlebokaSerializacja(uczelnie1);

        } catch (Exception e)
        {
            System.out.println("Problem z serializacją");
            uczelnie2 = null;
            success = false;
        }

        if (success)
        {
            String przed = uczelnieRowne(uczelnie1, uczelnie2);
            zmienImieStudenta(uczelnie1, 0,0,0, "Test");
            String po = uczelnieRowne(uczelnie1, uczelnie2);

            printResults(uczelnie1, uczelnie2, przed, po, print_data);
        }
    }

    public static void printResults(ArrayList<Uczelnia> uczelnie1, ArrayList<Uczelnia> uczelnie2, String przed, String po, boolean print_data)
    {
        if (print_data)
        {
            print(uczelnieToString(uczelnie1));
            print(uczelnieToString(uczelnie2));
        }

        print("Przed zmianą: "+przed);
        print("Po zmianie: "+po);
    }


    public static void print(String to_print)
    {
        System.out.println(to_print);
    }

    public static String uczelnieToString(ArrayList<Uczelnia> uczelnie)
    {
        String string = "";
        for (Uczelnia uczelnia : uczelnie)
        {
            string += uczelnia + "\n";
        }
        return string;
    }

    public static String uczelnieRowne(ArrayList<Uczelnia> uczelnie1, ArrayList<Uczelnia> uczelnie2)
    {
        String string;
        if (uczelnie1.toString().equals(uczelnie2.toString()))
        {
            string = "takie same";
        }
        else
        {
            string = "inne";
        }

        return string;
    }

    public static ArrayList<Uczelnia> randData(Random random, int liczba_uczelni, int liczba_wydzialow, int liczba_studentow)
    {
        ArrayList<Uczelnia> uczelnie = new ArrayList<>();
        for (int i =0; i<liczba_uczelni; i++)
        {
            uczelnie.add(Uczelnia.randUczelnia(random, i, liczba_wydzialow, liczba_studentow));
        }
        return uczelnie;
    }

    public static void zmienImieStudenta(ArrayList<Uczelnia> uczelnie, int numer_uczelni, int numer_wydzialu, int numer_studenta, String imie)
    {
        uczelnie.get(numer_uczelni).zmienImieStudenta(numer_wydzialu, numer_studenta, imie);
    }

    public static ArrayList<Uczelnia> kopiaGleboka1(ArrayList<Uczelnia> uczelnie_kopiowane)
    {
        ArrayList<Uczelnia> uczelnie = new ArrayList<>();
        for (Uczelnia uczelnia_kopiowana : uczelnie_kopiowane)
        {
            uczelnie.add(new Uczelnia(uczelnia_kopiowana));
        }
        return uczelnie;
    }

    static public ArrayList<Uczelnia> kopiaGlebokaSerializacja(ArrayList<Uczelnia> uczelnie_kopiowane) throws Exception
    {
        ArrayList<Uczelnia> uczelnie = new ArrayList<>();

        for (Uczelnia uczelnia_kopiowana : uczelnie_kopiowane)
        {
            uczelnie.add(Uczelnia.kopiaGlebokaSerializacja(uczelnia_kopiowana));
        }
        return uczelnie;
    }
}
