package StreamsEx;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Bob","Charlie","David");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering : " + name);
                    return name.length() > 3;
                });
        System.out.println("Before Terminal Operation " + stream);

        List<String> stringResult = stream.toList();
        System.out.println("After Termianl Operation ");
        System.out.println(stringResult);
    }


}
