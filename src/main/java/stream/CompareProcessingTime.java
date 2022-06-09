package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class CompareProcessingTime {
    static List<Integer> numbers;
    public static void main(String[] args) {
        int iterations = 100;
        numbers = IntStream.rangeClosed(1,1000000).boxed().collect(Collectors.toList());
        shuffle(numbers);
        boolean[] parallelOptions = {false, true};

        for (boolean parallel : parallelOptions) {
            long processingTime = 0;
            for (int i = 1; i <= iterations; i++) {
                processingTime += getMaxNumber(parallel);
            }
            System.out.println("Avg. processing time for " + (parallel ? "" : "non-") + "parallel stream: " + (processingTime / iterations) + " ms");
        }
    }
    static long getMaxNumber(boolean isParallel){
        long startTime = System.currentTimeMillis();
        if (isParallel){
            int max = numbers.stream().parallel().reduce(Integer.MIN_VALUE, Math::max);
        } else {
            int max = numbers.stream().reduce(Integer.MIN_VALUE, Math::max);
        }
        return System.currentTimeMillis() - startTime;
    }
}
