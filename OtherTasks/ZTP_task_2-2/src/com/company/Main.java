package com.company;

public class Main {

    public static void main(String[] args) {

        Pizza pizza1 = new Pizza.PizzaBuilder("mała",  "cienkie").build();
        System.out.println(pizza1.getString());

        Pizza pizza2 = new Pizza.PizzaBuilder("duża",  "cienkie").kwadratoweBrzegi().build();
        System.out.println(pizza2.getString());

        Pizza pizza3 = new Pizza.PizzaBuilder("duża",  "grube").kwadratoweBrzegi().podwojnySer().serWBrzegach().build();
        System.out.println(pizza3.getString());


        PizzaAnanas pizza4 = new PizzaAnanas(pizza1);
        System.out.println(pizza4.getString());

        PizzaAnanas pizza5 = new PizzaAnanas(pizza2);
        System.out.println(pizza5.getString());

        PizzaPieczarki pizza6 = new PizzaPieczarki(pizza5);
        System.out.println(pizza6.getString());

        PizzaSzynka pizza7 = new PizzaSzynka(pizza6);
        System.out.println(pizza7.getString());
    }
}
