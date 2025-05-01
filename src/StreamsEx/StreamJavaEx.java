package StreamsEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamJavaEx {
    public static void main(String[] args) {
        // This Feature is introduced in Java 8
        // It processes collections of data in a functional and declarative manner.
        // Simplify Data Processing.
        // Improve Readability and Maintainability
        // Embrace Functional Programming
        // Enable Easy Parallelism

        // Stream is a sequence of elements supporting functional and declarative programming.

        // Stream can be used as
        // Source, Intermediate operations and terminal operations.

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().filter(x -> x%2 ==0));
        System.out.println(numbers.stream().filter(x -> x%2 == 0).count());

        // we can create Streams as follows
        // 1. From Collections
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        // 2. From Array
        String[] array = {"a","b","c"};
        Stream<String> stream1 = Arrays.stream(array);

        // 3. Using Stream.of()
        Stream<String> stream2 = Stream.of("a","b");

        // 4. Infinite Streams
        Stream.generate(()-> 1);
        Stream.iterate(1,x-> x+1);
    }
}
