package com.company;

public class Pizza
{
    private String wielkosc;
    private String ciasto;
    private boolean podwojny_ser;
    private boolean ser_w_brzegach;
    private boolean kwadratowe_brzegi;
    private double bazowaCena;

    protected double mnoznikZaSkladnik;
    protected double cenaOstateczna;
    protected String currentString;

    public Pizza() {
    }

    protected Pizza(PizzaBuilder builder)
    {
        wielkosc = builder.wielkosc;
        ciasto = builder.ciasto;

        podwojny_ser = builder.podwojny_ser;
        ser_w_brzegach = builder.ser_w_brzegach;
        kwadratowe_brzegi = builder.kwadratowe_brzegi;

        mnoznikZaSkladnik = 1;
        bazowaCena = 10;


        if (ciasto.equals("grube"))
        {
            mnoznikZaSkladnik += 0.5;
            bazowaCena += 2;
        }

        if (wielkosc.equals("średnia"))
        {
            mnoznikZaSkladnik += 0.5;
            bazowaCena += 2;
        }
        else if (wielkosc.equals("duża"))
        {
            mnoznikZaSkladnik += 1;
            bazowaCena += 4;
        }

        currentString = "\n\nPizza ["+wielkosc+"]\nCiasto ["+ciasto+"]\n";
        if ((ser_w_brzegach)||(kwadratowe_brzegi)||(podwojny_ser))
        {
            currentString += "Uwagi: ";
            if (ser_w_brzegach)
            {
                bazowaCena += 5;
                currentString += "[ser w brzegach]";
            }
            if (kwadratowe_brzegi)
            {
                bazowaCena += 5;
                currentString += "[kwadratowe brzegi]";
            }
            if (podwojny_ser)
            {
                bazowaCena += 2;
                currentString += "[podwójny ser]";
            }
        }
        cenaOstateczna = bazowaCena;

        currentString += "\nSkladniki:\n";
        currentString += "[sos pomidorowy]";
    }

    public String getString()
    {
        return currentString + "\nCena ostateczna: ["+cenaOstateczna+"]zł";
    }

    ///BUILDER
    public static class PizzaBuilder
    {
        private String wielkosc;
        private String ciasto;
        private boolean podwojny_ser;
        private boolean ser_w_brzegach;
        private boolean kwadratowe_brzegi;


        public PizzaBuilder(String wielkosc, String ciasto)
        {
            this.wielkosc = wielkosc;
            this.ciasto = ciasto;

            this.podwojny_ser = false;
            this.ser_w_brzegach = false;
            this.kwadratowe_brzegi = false;
        }

        public PizzaBuilder serWBrzegach()
        {
            this.ser_w_brzegach  = true;
            return this;
        }

        public PizzaBuilder podwojnySer()
        {
            this.podwojny_ser  = true;
            return this;
        }

        public PizzaBuilder kwadratoweBrzegi()
        {
            this.kwadratowe_brzegi  = true;
            return this;
        }

        public Pizza build()
        {
            return new Pizza(this);
        }
    }

}
