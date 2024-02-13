package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExcerciseOnReadAndWriteGenericsWithBounded {

    public static <T> void copy(List<? extends T> source,List<? super T> destination){
        source.stream().map(destination::add).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> source = Arrays.asList("Adam","Ana","Kevin");
        List<String> destination = new ArrayList<>();
        copy(source,destination);
        System.out.println("Copy List example: "+destination);
    }
}
