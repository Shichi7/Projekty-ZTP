package com.company;

public class Main {

    public static void main(String[] args)
    {
        //test1();
        //test2();
        //test3();
    }

    public static void test1()
    {
        ListOfNumbers numbers = new ListOfNumbers();
        numbers.generate();

        numbers.print();

        numbers.multiplyByMax(numbers.numbers);
        numbers.multiplyByMin(numbers.numbers);
        numbers.multiplyByValue(numbers.numbers,10);
    }

    public static void test2()
    {
        ListOfStrings strings = new ListOfStrings();
        strings.generate();
        strings.print();

        strings.filter(strings.list);
    }

    public static void test3()
    {
        ListOfNames strings = new ListOfNames();
        strings.generate();
        strings.print();

        strings.filter(strings.list);
    }
}
