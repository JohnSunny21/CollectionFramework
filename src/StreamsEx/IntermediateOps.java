package StreamsEx;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked.

        // 1). Filter
        List<String> list = Arrays.asList("Reena", "Renold", "Andy", "Steward", "Leena");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("R"));

        // Not filtered currently
        long res = list.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(res);

        // 2). Map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3). Sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamWithComparator = list.stream().sorted((a, b) -> b.length() - a.length());

        // 4). Distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5). Limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        // 6). Skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

        // 7). Peek
        // Performs an action on each element as it is consumed.
        Stream.iterate(1, x -> x + 1).skip(100).limit(100).peek(System.out::println);

        // 8). FlatMap
        // Handle streams of collections, lists, or arrays where each element is itself a collection.
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements.
        // Transform and flatten elements at the same time.

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Humpty", "Dumpty"),
                Arrays.asList("Sat", "On"),
                Arrays.asList("A", "Wall")
        );


        System.out.println(listOfLists.get(1).get(1));
        System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());
        List<String> sentences = Arrays.asList("Hello world", "Java Streams are powerful", "flatMap is useful");

        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList());

    }
}
