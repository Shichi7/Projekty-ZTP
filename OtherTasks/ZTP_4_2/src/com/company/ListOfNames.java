package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListOfNames implements CustomList, Filterable
{
    public ArrayList<Optional<String>> list = new ArrayList<>();

    public void generate()
    {
        list.add(Optional.empty());
        list.add(Optional.of("Aleksander"));
        list.add(Optional.empty());
        list.add(Optional.of("Maciek"));
        list.add(Optional.empty());
        list.add(Optional.of("Zygmunt"));
        list.add(Optional.of("Amadeusz"));
        list.add(Optional.empty());
        list.add(Optional.of("Kamil"));
        list.add(Optional.of("Szymon"));
        list.add(Optional.of("Agnieszka"));
        list.add(Optional.empty());
    }

    @Override
    public void filter(ArrayList<Optional<String>> to_filter)
    {
        System.out.println("Names starting with 'A':");

        List<String> filtered = to_filter.stream().flatMap(Optional::stream)
                .filter(e -> e.toString().charAt(0) == 'A')
                .collect(Collectors.toList());

        filtered.forEach(s -> System.out.println(s));
        System.out.println();
    }

    public void print()
    {
        System.out.println("Names list:");
        for (Optional<String> string : list)
        {
            System.out.print("[");
            string.ifPresentOrElse(System.out::print, ()->System.out.print("string not found"));
            System.out.println("]");
        }
        System.out.println();
    }

}
