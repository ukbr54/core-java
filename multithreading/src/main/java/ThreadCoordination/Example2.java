package ThreadCoordination;

import java.math.BigInteger;

public class Example2 {

    public static void main(String[] args) {
        BigInteger result;
        LongComputationTask thread1 = new LongComputationTask(new BigInteger("2"),new BigInteger("10"));
        LongComputationTask thread2 = new LongComputationTask(new BigInteger("3"),new BigInteger("10"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = thread1.getResult().add(thread2.getResult());
        System.out.println("Result: "+result);
    }

    private static class LongComputationTask extends Thread{
        private BigInteger base;
        private BigInteger power;
        private BigInteger result;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = pow(base,power);
            System.out.println(base+"^"+power+" = "+result);
        }

        private BigInteger pow(BigInteger base,BigInteger power){
            BigInteger result = BigInteger.ONE;
            for(BigInteger i=BigInteger.ZERO; i.compareTo(power) !=0; i=i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Thread interrupted");
                    return BigInteger.ONE;
                }
                result = result.multiply(base);
            }
            return result;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
