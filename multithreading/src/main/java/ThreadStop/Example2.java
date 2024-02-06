package ThreadStop;

import java.math.BigInteger;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2"),new BigInteger("10")));
        thread.start();
        Thread.sleep(100);
    }

    private static class LongComputationTask implements Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base+"^"+power+" = "+pow(base,power));
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
    }
}
