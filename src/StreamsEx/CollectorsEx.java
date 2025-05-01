package StreamsEx;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsEx {
    public static void main(String[] args) {
        // The Collectors is a Utility Class
        // It provides a set of methods to create common collectors


        // 1). Collecting to a List
        List<String> names = Arrays.asList("Andy","Mandy","Candy","Jenny","Emily");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("M"))
                .collect(Collectors.toList());
        System.out.println(result);

        // 2). Collecting to a Set
        List<Integer> nums = Arrays.asList(1,2,3,4,4,3,434,5);
        Set<Integer> setResult = nums.stream().collect(Collectors.toSet());
        System.out.println(setResult);

        // 3). Collecting to a Specific Collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(()-> new ArrayDeque<>()));

        // 4). Joining Strings
        // Concatenates stream elements into a single string
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(concatenatedNames);

        // 5). Summarizing Data
        // Generates statistical summary (count, sum, min , average, max)

        List<Integer> numbers = Arrays.asList(2,3,5,7,6,84,89,11);
        IntSummaryStatistics statistics = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count : "+statistics.getCount());
        System.out.println("Sum : "+statistics.getSum());
        System.out.println("Min : "+statistics.getMin());
        System.out.println("Max : "+statistics.getMax());
        System.out.println("Average : " +statistics.getAverage());

        // 6). Calculating Averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average : "+average);

        // 7). Counting Elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count : "+count);

        // 8). Grouping Elements
        List<String> words = Arrays.asList("Hello","World","Java","Is","Robust");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        TreeMap<Integer,Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length,TreeMap::new,Collectors.counting()));
        System.out.println(treeMap);


        // 9). Partitioning Elements
        // Partitions elements into two groups (true and false) based on a predicate.
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length()> 4)));

        // 10). Mapping and Collecting
        // Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(),Collectors.toList())));


        // Example 1: Collecting Names by Length
        List<String> list1 = Arrays.asList("Emily","Thomas","Eddie","Leah","Jadis");
        System.out.println(list1.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2: Counting Word Occurrences
        String sentence = "Hey There Java Hello World";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x,Collectors.counting())));

        // Example 3: Partitioning Even and Odd Numbers
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,7,6,9,8,10,11);
        System.out.println(list2.stream().collect(Collectors.partitioningBy(x -> x%2 ==0)));

        // Example 4: Summing Values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple",10);
        items.put("Banana",20);
        items.put("Orange",15);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summarizingInt(x->x)));

        // Example 5: Creating a Map from Stream Elements
        List<String> fruits = Arrays.asList("Apple","Banana","CupCake");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x-> x.length())));

        // Example 6:
        List<String> words2 = Arrays.asList("Apple","Banana","Cat","Ball","Aeroplane","Banana","Apple","Cat","Ball");
        System.out.println(words2.stream().collect(Collectors.toMap(k->k,v -> 1,(x,y)-> x+y)));

    }
}
