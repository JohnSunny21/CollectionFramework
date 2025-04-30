import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        // It is part of the Queue interface
        // orders elements based on their natural ordering (for primitives lowest first)
        // custom comparator for customized ordering
        // does not allow null elements.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(15);
        pq.add(5);
        System.out.println(pq); // not sorted.
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // Internal working
        // Priority Queue is implemented as a min-heap by default (for natural ordering)
    }
}
