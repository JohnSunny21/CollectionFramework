package StreamsEx;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamsEx {
    public static void main(String[] args) {
        // This is a special type of stream that enables the parallel processing of elements in a collection.
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets.
        // Workload is distributed across multiple threads.

        long startTime = System.currentTimeMillis();
        List<Integer> list  = Stream.iterate(1,x-> x+1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(ParallelStreamsEx::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with Sequential Stream : " +(endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStreamsEx::factorial).toList();
        // or we can use
//        factorialList = list.parallelStream().map(ParallelStreamsEx::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with Parallel Stream : " +(endTime - startTime) + " ms");

        // Parallel Streams are most effective for CPU-intensive or large datasets where tasks are independent.
        // They may add overhead for simple tasks or small datasets.

        // Cumulative Sum
        // [1,2,3,4,5,34,43,5,8] ===> [1, 3, 6, 10, 15, 49, 92, 97, 105]
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,34,43,5,8);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSum = numbers.stream().sequential().map(sum::addAndGet).toList();
        System.out.println("Expected cumulative sum : [1,3,6,10,15,49,91,96,104]");
        System.out.println("Actual result with parallel stream : " +cumulativeSum);
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2 ; i<=n; i++){
            result *= i;
        }
        return result;
    }
}
