package Deadlock;

import java.util.Random;

public class CircularWaitDeadlockSolution {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread threadA = new Thread(new TrainA(intersection));
        Thread threadB = new Thread(new TrainB(intersection));

        threadA.start();
        threadB.start();
    }

    public static class TrainA implements Runnable{
        private Intersection intersection;
        private Random random = new Random();
        public TrainA(Intersection intersection){
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true){
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                intersection.takeRoadA();
            }
        }
    }

    public static class TrainB implements Runnable{
        private Intersection intersection;
        private Random random = new Random();
        public TrainB(Intersection intersection){
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true){
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                intersection.takeRoadB();
            }
        }
    }

    public static class Intersection {
        private Object roadA = new Object();
        private Object roadB = new Object();
        public void takeRoadA(){
            synchronized (roadA){
                System.out.println("Road A is locked by thread "+Thread.currentThread().getName());
                synchronized (roadB){
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        public void takeRoadB(){
            synchronized (roadA){
                System.out.println("Road A is locked by thread "+Thread.currentThread().getName());
                synchronized (roadB){
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
