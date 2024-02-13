package Generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {

    public static void showAll(List<? super Number> nums){
        nums.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<? super Integer> l1 = new ArrayList<Integer>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();

        //how to read items using lower bounded wildcard
        List<Serializable> list = new ArrayList<>();
        list.add("Adam");
        list.add("Kevin");
        list.add("Ana");
        showAll(list);

        //insert Items
        List<? super Number> nums = new ArrayList<>();
        nums.add(3);
        nums.add(3.3);
        nums.add(4.9f);
    }
}
