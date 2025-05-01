package StreamsEx;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreamsEX {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numbers);

        System.out.println(IntStream.range(1,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));

        IntStream.of(1,2,3);

        DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.sum());
//        System.out.println(doubles.min());
//        System.out.println(doubles.max());
//        System.out.println(doubles.average());
//        DoubleSummaryStatistics doubleSummaryStatistics = doubles.summaryStatistics();
////        System.out.println(doubleSummaryStatistics);
//        IntStream intStream = doubles.mapToInt(x -> (int) (x + 1));
//        System.out.println(intStream);
        System.out.println(doubles.boxed().toList());

        IntStream intStream1 = new Random().ints(5);
        System.out.println(intStream1.boxed().toList());
    }
}
