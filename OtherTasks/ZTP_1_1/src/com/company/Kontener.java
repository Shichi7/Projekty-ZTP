package com.company;

import java.util.ArrayList;

public class Kontener<T>
{
    private ArrayList<T> lista_potraw = new ArrayList<T>();

    public void dodajPotrawe(T potrawa)
    {
        lista_potraw.add(potrawa);
    }

    public ArrayList<T> zwrocListe()
    {
        return lista_potraw;
    }
}
