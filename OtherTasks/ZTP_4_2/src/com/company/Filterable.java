package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Filterable
{
    default void filter(ArrayList<Optional<String>> to_filter)
    {
        System.out.println("Shorter than 5 chars:");

        List<String> collect = to_filter.stream().flatMap(Optional::stream)
                .filter(p -> p.length() < 5)
                .collect(Collectors.toList());

        collect.forEach(s -> System.out.println(s));
        System.out.println();
    }
}
