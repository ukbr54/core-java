package Generics;

import java.util.stream.Stream;

class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age,o.getAge());
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

public class BoundedGenericsExample {

    /**
     * input T[] and specified item T
     * o/p -> count how many items are greater than this specified T item
     * [1,2,3,4,5] and item = 3 ----> result is 2
     */
    public static <T extends Comparable<T>> Long countGreaterItems(T[] items,T item){
        long count = Stream.of(items).filter(i -> i.compareTo(item) > 0).count();
        return count;
    }

    public static <T extends Number> void addNumbers(T item1,T item2){
        double result = item1.doubleValue() + item2.doubleValue();
        System.out.println("The result of addition: "+result);
    }

    public static <T extends Comparable<T>> T calculateMin(T item1, T item2){
        if(item1.compareTo(item2) < 0)
            return item1;
        return item2;
    }

    public static void main(String[] args) {
        System.out.println(calculateMin("Adam","Kevin"));
        System.out.println(calculateMin(new Person("Adam",45),new Person("Kevin",34)));
        Integer[] nums = {1, 2, 3, 4, 5};
        System.out.println("Result: "+countGreaterItems(nums,3));
    }
}
