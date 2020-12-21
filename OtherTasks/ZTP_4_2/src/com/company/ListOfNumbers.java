package com.company;

import java.util.ArrayList;
import java.util.Optional;

public class ListOfNumbers implements Multipliable, CustomList
{
    public ArrayList<Optional<Integer>> numbers = new ArrayList<>();
    public static final String type = "numbers";

    public void generate()
    {
        for (int i = 0; i< 10; i++)
        {
            if (i%3==0)
            {
                numbers.add(Optional.empty());
            }
            else
            {
                numbers.add(Optional.of(i));
            }
        }
    }

    public void print()
    {
        System.out.println("Numbers list:");

        for (Optional<Integer> number : numbers)
        {
            System.out.print("[");
            number.ifPresentOrElse(System.out::print, ()->System.out.print("number not found"));
            System.out.println("]");
        }
        System.out.println();

    }
}
