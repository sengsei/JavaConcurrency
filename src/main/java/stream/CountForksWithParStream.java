package stream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CountForksWithParStream {
    public static void main(String[] args) {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        List<Integer> numbers = IntStream.rangeClosed(1,64).boxed().toList();
        int max = numbers.stream().parallel().reduce(Integer.MIN_VALUE, CountForksWithParStream::forkCounter);

        System.out.println("Number of forks: " + forks.get());
    }

    static AtomicInteger forks = new AtomicInteger(0);
    static Integer forkCounter(Integer a, Integer b){
        if (a == Integer.MIN_VALUE) forks.getAndIncrement();
        System.out.println("Compare " + a + " to " + b + " in " + Thread.currentThread().getName());
        return Math.max(a,b);
    }
}
