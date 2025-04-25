import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.get(4); // Time Complexity: O(n) because it needs to go all the elements to find the correct element
        // because linked list stores the data as node . Each node contains [data,address] data=>"element" address=>"address of next element"
        // unlike array in which the elements are stored in contiguous memory whereas in linked list they are stored at different address pointing to each other.

        linkedList.addLast(8); // O(1) because we have predefined method to get this done.
        linkedList.addFirst(0); // O(1)
        linkedList.getFirst();
        linkedList.getLast();
        System.out.println(linkedList);
        linkedList.removeIf( x -> x%2 == 0); // removes the even element
        System.out.println(linkedList);


        // Let's take some examples based upon the strings
        LinkedList<String> fruits = new LinkedList<>(Arrays.asList("Apple","Mango","Banana","Grapes","Guava"));
        LinkedList<String> delFruits = new LinkedList<>(Arrays.asList("Mango","PineApple"));
        fruits.removeAll(delFruits);
        System.out.println(fruits);
    }
}
