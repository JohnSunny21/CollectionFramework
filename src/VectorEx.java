import java.util.LinkedList;
import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        // The Vector class in Java, part of the java.util package,
        // is a legacy collection that implements the List interface.
        // It provides a thread-safe dynamic array but is generally less
        // preferred due to its performance overhead in single-threaded scenarios.

        Vector<Integer> list = new Vector<>(10,5); // creates the initial capacity of 10 and capacityIncrement of 5.
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(list.capacity());
        list.add(11);
        System.out.println(list.capacity());
        // when the list reaches the capacity limit then it will increase it size by capacityIncrement.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // The linkedList can also be passed to the constructor of the vector to create a vector with the linkedList elements.
        Vector<Integer> vector = new Vector<>(linkedList);
        System.out.println(vector);

        for(int i=0 ; i<vector.size() ; i++){
            System.out.println(vector.get(i));
        }

        vector.clear(); // clearing all the elements in the vector.
        System.out.println(vector);

        // As the vector is synchronized we get the output as 2000 but in case of an arrayList the output will be different due to inconsistency.
        Vector<Integer> threadList = new Vector<>();
        Thread t1 = new Thread(()->{
            for(int i = 0; i< 1000; i++){
                threadList.add(i);
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i< 1000; i++){
                threadList.add(i);
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            System.out.println("Thread is Interrupted");
        }
        System.out.println("Size of list: " +threadList.size()); // O/P: 2000

    }
}
