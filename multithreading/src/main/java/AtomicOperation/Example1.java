package AtomicOperation;

import java.util.Random;

public class Example1 {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BuisnessLogic thread1 = new BuisnessLogic(metrics);
        BuisnessLogic thread2 = new BuisnessLogic(metrics);

        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);

        thread1.start();
        thread2.start();
        metricsPrinter.start();
    }

    public static class MetricsPrinter extends Thread{
        private Metrics metrics;
        public MetricsPrinter(Metrics metrics){
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                double currentAverage = metrics.getAverage();
                System.out.println("Current Average is "+currentAverage);
            }
        }
    }

    public static class BuisnessLogic extends Thread{
        private Metrics metrics;
        private Random random = new Random();
        public BuisnessLogic(Metrics metrics){
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while(true){
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long end = System.currentTimeMillis();
                metrics.addSample(end-start);
            }
        }
    }

    public static class Metrics{
        private long count =0;
        private volatile double average = 0.0;

        public synchronized void addSample(long sample){
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return average;
        }
    }
}
