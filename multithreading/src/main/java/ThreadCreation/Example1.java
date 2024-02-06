package ThreadCreation;

public class Example1 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("We are now in thread "+Thread.currentThread().getName());
            System.out.println("Thread Priority:  "+Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: "+Thread.currentThread().getName()+" before starting a new thread");
        thread.start();
        System.out.println("We are in thread: "+Thread.currentThread().getName()+" after starting a new thread");
    }
}
