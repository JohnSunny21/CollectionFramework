import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        Integer poppedElement = stack.pop();
        System.out.println(stack);

        Integer peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        int search = stack.search(3);
        System.out.println(search);
        // The search order starts at 1 like firstElement -> 1 -> 2 -> 3 (search)-> 4 -> 5

        // We can use the Linked List as a stack also.

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.getLast(); // which is peek()
        linkedList.removeLast(); // which is pop()
        linkedList.size();
        linkedList.isEmpty();

        // ArrayList as a stack

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(list.size()-1); // which is peek();
        list.remove(list.size() -1); // which is pop()

        // It will be difficult to use Array List as stack because there is not builtin methods like addLast() and removeLast() .
        // So linkedList will be suited to be used as stack as an alternative.

    }
}
