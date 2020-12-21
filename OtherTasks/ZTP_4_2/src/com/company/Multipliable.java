package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Multipliable
{
    default void multiplyByMax(ArrayList<Optional<Integer>> list)
    {
        List<Integer> collect = list.stream().flatMap(Optional::stream).collect(Collectors.toList());

        int max = Collections.max(collect);
        multiply(collect, max);
    }

    default void multiplyByMin(ArrayList<Optional<Integer>> list)
    {
        List<Integer> collect = list.stream().flatMap(Optional::stream).collect(Collectors.toList());

        int min = Collections.min(collect);
        multiply(collect, min);
    }

    default void multiplyByValue(ArrayList<Optional<Integer>> list, int value)
    {
        List<Integer> collect = list.stream().flatMap(Optional::stream).collect(Collectors.toList());

        multiply(collect, value);
    }

    private void multiply(List<Integer> list, int multiplier)
    {
        List<Integer> multiplied = list.stream().map(i -> multiplier*i).collect(Collectors.toList());
        multiplied.forEach(s -> System.out.println(s));
        System.out.println();
    }

}
