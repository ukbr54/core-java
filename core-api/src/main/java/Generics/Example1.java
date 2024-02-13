package Generics;


public class Example1 {

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.setContent(100);
        System.out.println(b1.getContent());

        Hashtable<String,Integer> hashtable = new Hashtable<>("Hello",23);
        System.out.println(hashtable);

        GenericMethod genericMethod = new GenericMethod();
        genericMethod.showItem("Hello");
        System.out.println(genericMethod.returnItem("World"));
        genericMethod.printItems("Hello",54);
    }
}

class GenericMethod{

    public <T,E> void printItems(T t,E e){
        System.out.println(t.toString());
        System.out.println(e.toString());
    }

    public <T> void showItem(T item){
        System.out.println("The item: "+item);
    }

    public <T> T returnItem(T item){
        return item;
    }
}

class Hashtable<K,V>{
    K key;
    V value;
    public Hashtable(K key,V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Hashtable{" + "key=" + key + ", value=" + value + '}';
    }
}

class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}
