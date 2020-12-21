package com.company;

public class Ogorkowa extends Zupa
{
        private int ogorkowosc;

        public Ogorkowa(int ogorkowosc, int konsystencja, double waga, double cena, int jakosc, boolean przeterminowane)
        {
            super(konsystencja, waga, cena, jakosc, przeterminowane);
            this.nazwa = "OGÓRKOWA";
            this.ogorkowosc = (ogorkowosc > 3 ? 3 : ogorkowosc) < 0 ? 0 : ogorkowosc;
        }


        @Override
        public String toString()
        {
            String string_value = super.toString();

            string_value += "Ogórkowość: "+ ogorkowosc+"/3\n";
            return string_value;
        }
}
