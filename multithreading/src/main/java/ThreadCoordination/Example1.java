package ThreadCoordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Example1 {

    public static void main(String[] args) {
        List<Long> inputNumbers = List.of(0L, 3435L, 35435L, 2324L, 5656L, 23L, 5556L);
        List<FactorialThread> threads = new ArrayList<>();
        for(long inputNumber : inputNumbers){
            threads.add(new FactorialThread(inputNumber));
        }

        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        IntStream.range(0,inputNumbers.size())
                .forEach(i -> {
                    FactorialThread factorialThread = threads.get(i);
                    if(factorialThread.isFinished){
                        System.out.println("Factorial of "+inputNumbers.get(i)+" is "+factorialThread.getResult());
                    }else{
                        System.out.println("The calculation for "+inputNumbers.get(i)+" is still in progress");
                    }
                });
    }

    public static class FactorialThread extends Thread{
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;
        public FactorialThread(long inputNumber){
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished=true;
        }

        private BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;
            for(long i=n; i>0; i--){
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
