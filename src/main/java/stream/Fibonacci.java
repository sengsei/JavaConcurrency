package stream;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {
    int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Long compute() {

        Fibonacci fibonacciTaskOne = new Fibonacci(n - 1);
        fibonacciTaskOne.fork();
        Fibonacci fibonacciTaskTwo = new Fibonacci(n - 2);

        return n <= 1 ? n : fibonacciTaskTwo.compute() + fibonacciTaskOne.join();
    }
}
