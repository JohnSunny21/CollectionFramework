import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeEx {
    public static void main(String[] args) {
        // non-blocking, thread-safe and double-ended queue
        // Compare and swap mechanism

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("Element 1");
        deque.addFirst("Element 0");
        deque.addLast("Element 2");
        System.out.println(deque);

        String first = deque.removeFirst();
        String last = deque.removeLast();

    }
}
