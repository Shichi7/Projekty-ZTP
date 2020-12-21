package com.company;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class ListOfStrings implements CustomList, Filterable
{
    public ArrayList<Optional<String>> list = new ArrayList<>();

    public void generate()
    {
        for (int i = 0; i< 10; i++)
        {
            if (i%3==0)
            {
                list.add(Optional.empty());
            }
            else
            {
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'

                Random random = new Random();

                int targetStringLength = random.nextInt(5) + 3;

                String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

                list.add(Optional.of(generatedString));
            }
        }
    }

    public void print()
    {
        System.out.println("Strings list:");
        for (Optional<String> string : list)
        {
            System.out.print("[");
            string.ifPresentOrElse(System.out::print, ()->System.out.print("string not found"));
            System.out.println("]");
        }
        System.out.println();
    }
}
