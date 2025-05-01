package StreamsEx;



import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Java8Intro {
    public static void main(String[] args) {
        // Streams it is one of the feature in Java 8.

        // Java 8 ---> Mainly focuses on minimal code, and usage of functional programming.
        // Java 8 ---> lambda expression, Streams,DateTime API, Method and Constructor references,Default and static methods
        // in interfaces,Optional class, Functional Interface are the features introduced in the Java 8.

        // The lambda function is an anonymous function (with no name, no return type, no access modifier)

        Thread thread1 = new Thread(()->{
            System.out.println("Hello");
        });

        MathOperation sumOperation = (a,b)-> a+b;
        MathOperation subtractOperation = (a,b) -> a-b;
        int res = sumOperation.operate(1,3);
        int sub = subtractOperation.operate(5,5);
        System.out.println("Sum is : "+res);
        System.out.println("Sub is : "+sub);

        // Predicate ===> Functional interface (Boolean valued Function)
        Predicate<Integer> isEven = x -> x%2 == 0;
        System.out.println(isEven.test(5));
        Predicate<String> isWordStartWithN = x -> x.toLowerCase().startsWith("n");
        Predicate<String> isWordEndsWithA = x -> x.toLowerCase().endsWith("a");
        Predicate<String> and = isWordStartWithN.and(isWordEndsWithA);
        System.out.println(and.test("Nata"));

        // Function ===> makes the operations on the stream.
        Function<Integer,Integer> doubleIt = x -> 2*x;
        Function<Integer,Integer> tripleIt = x -> 3*x;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(30)); // same
        System.out.println(doubleIt.compose(tripleIt).apply(30)); // same

        System.out.println(doubleIt.apply(100));
        System.out.println(tripleIt.apply(100));
        Function<Integer,Integer> identity = Function.identity(); // returns input value.
        Integer identityResult = identity.apply(25);
        System.out.println(identityResult);


        // Consumer
        Consumer<Integer> print1 = y -> System.out.println(y);
        print1.accept(53);
        List<Integer> consumerList = Arrays.asList(1,3,2);
        Consumer<List<Integer>> printList = x -> {
            for(Integer i : x){
                System.out.println(i);
            }
        };

        printList.accept(consumerList);

        Supplier<String> giveMeHelloWorld = () -> "Hello World";
        System.out.println(giveMeHelloWorld.get());


        // Combined Example
        Predicate<Integer> predicate = x -> x%2 == 0;
        Function<Integer,Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate

        BiPredicate<Integer,Integer> isSumEven = (x,y) -> (x + y) % 2 ==0;
        System.out.println(isSumEven.test(5,5));

        // BiConsumer

        BiConsumer<Integer,String> biConsumer = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        // BiFunction

        BiFunction<String, String, Integer> biFunction = (x,y) -> (x + y).length();
        System.out.println(biFunction.apply("Hello","Github"));

        // UnaryOperator

        UnaryOperator<Integer> a = x -> 2 * x;

        // BinaryOperator
        BinaryOperator<Integer> b = (x,y) -> x + y;

        // Method References
        List<String> students = Arrays.asList("Andy","Rosi","Tarly");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);

        // Constructor Reference
        List<String> names = Arrays.asList("A","Z","Santro","iki");
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).toList();
    }
}

class MobilePhone{
    String name;
    public MobilePhone(String name){
        this.name = name;
    }
}

@FunctionalInterface
interface MathOperation{
    int operate(int a, int b);
}