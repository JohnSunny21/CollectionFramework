package StreamsEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 1). Collect
        List<Integer> collect1 = list.stream().skip(1).toList();
        List<Integer> collect2 = list.stream().skip(1).collect(Collectors.toList());


        // 2). ForEach
        list.stream().forEach(x -> System.out.println(x));

        // 3). Reduce : Combines Elements to produce a single unit
        Optional<Integer> optionalInteger = list.stream().reduce((a, b) -> a + b);
        // or we can write it as
        Optional<Integer> optionalIntegerWithMR = list.stream().reduce(Integer::sum);
        System.out.println(optionalIntegerWithMR.get());

        // 4). Count
        long count = list.stream().count();
        System.out.println("Size of list: " + count);

        // 5). anyMatch, allMatch, noneMatch

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        boolean b2 = list.stream().allMatch(x -> x > 0);
        System.out.println(b2);
        boolean b3 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b3);

        // 6). findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // 7). toArray()

        Object[] array = Stream.of(1, 2, 3, 4, 5, 7).toArray();

        // 8). Min / Max
        System.out.println("Max : " + Stream.of(2, 89, 43, 434, 93, 4).max((o1, o2) -> o2 - o1));
        System.out.println("Min : " + Stream.of(2, 89, 43, 434, 93, 4).min(Comparator.naturalOrder()));

        // 9). forEachOrdered
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream : ");
        numbers.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream : ");
        numbers.parallelStream().forEachOrdered(System.out::println);

        // Example : Filtering and Collecting Names
        List<String> names = Arrays.asList("Deane", "Andy", "Raiga", "Lanmer", "Tomaise");
        System.out.println(names.stream().filter(x -> x.length() > 4).toList());


        // Example : Squaring and Sorting Numbers
        List<Integer> numbers0 = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers0.stream().map(x -> x * x).sorted().toList());

        // Example : Summing Values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        // Example : Counting Occurrences of a Character
        String sentence = "Hi there";
        System.out.println(sentence.chars().filter(x -> x == 'e').count());

        // Example :
        // Streams cannot be reused after a terminal operation has been called as shown in the example below
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);

//        List<String> list1 = stream.map(String::toUpperCase).toList(); // this won't work and exception occurs
    }
}
