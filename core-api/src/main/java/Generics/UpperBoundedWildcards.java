package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {

    // read the item
    public static void showAll(List<? extends Number> list){
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<? extends Number> l1 = new ArrayList<Integer>();
        List<? extends Number> l2 = new ArrayList<Double>();
        List<? extends Number> l3 = new ArrayList<Float>();

        //l1.add(new Integer(11)); -> Not allowed to insert the item the upper bounded wildcards

        showAll(Arrays.asList(1,2,3,4));
    }
}
