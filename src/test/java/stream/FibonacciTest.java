package stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class FibonacciTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,1", "3,2", "11, 89", "-1, -1", "20,6765", "30,832040"})
    void shouldComputeFib(int input, int expected){
        assertEquals(expected, new Fibonacci(input).compute());
    }
}