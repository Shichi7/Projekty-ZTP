package com.company;

public class Zupa extends Potrawa {

    private String konsystencja;

    public Zupa(int konsystencja, double waga, double cena, int jakosc, boolean przeterminowane)
    {
        super(waga, cena, jakosc, przeterminowane);
        this.nazwa = "ZUPA";
        ustawKonsystencje(konsystencja);
    }

    private void ustawKonsystencje(int konsystencja)
    {
        if (konsystencja==0)
        {
            this.konsystencja = "płynna";
        }
        else if (konsystencja==1)
        {
            this.konsystencja = "półpłynna";
        }
        else
        {
            this.konsystencja = "krem";
        }
    }

    @Override
    public String toString()
    {
        String string_value = super.toString();

        string_value += "Konsystencja: "+ konsystencja+"\n";
        return string_value;
    }
}
