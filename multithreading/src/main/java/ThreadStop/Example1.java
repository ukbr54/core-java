package ThreadStop;

/**
 * When we interrupt a Thread?
 *  - If the thread is executing a method that throws an InterruptedException
 *  - If the thread's code is handling the interrupt signal explicitly.
 */
public class Example1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking Thread");
            }
        }
    }
}
