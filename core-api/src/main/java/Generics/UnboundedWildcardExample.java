package Generics;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardExample {

    public static void print(List<?> list){
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        print(Arrays.asList("Kevin","Adam"));
    }
}
