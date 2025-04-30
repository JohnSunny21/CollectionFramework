import java.util.Comparator;
import java.util.concurrent.*;

class Producer implements Runnable{
    private BlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){
            try{
                System.out.println("Producer produced : " + value);
                queue.put(value++);
                Thread.sleep(1000);
            }catch (Exception ex){
                Thread.currentThread().interrupt();
                System.err.println("Producer Interrupted.");
            }
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try{
                Integer value = queue.take();
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(2000);
            }catch (Exception ex){
                Thread.currentThread().interrupt();
                System.err.println("Consumer Interrupted");
            }
        }
    }
}



public class BlockingQueueEx {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Blocking Queue is thread-safe
        // wait for queue to become non-empty (or) wait for the space to be available in the queue.
        // simplify concurrency problems like producer - consumer.
        // standard queue --> immediately takes operations
        //     empty ----> remove(no waiting)
        //     full  ----> add (no waiting)
        // Blocking Queue
        //     put   ----> Blocks if the queue is full until space become available.
        //     take  ----> Blocks if the queue is empty until an element or data becomes available in the queue.
        //     offer ----> Waits for space to become available, up to the specified timeout.


        // The ArrayBlockingQueue is bounded, blocking queue is backed by circular array.
        // it has low memory overhead.
        // uses a single lock for both enqueue and dequeue operations.
        // more threads ---> problem.
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
        // optionally bounded backed by linkedList.
        // Uses two separate locks for enqueue and dequeue operations.
        // Higher concurrency between producers and consumers.

        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        // Unbounded
        // Binary Head as array and can grow dynamically
        // Head is based on their natural ordering or a provided Comparator like priority queue.
        // put won't block
        queue2.add("Andy");
        queue2.add("Mandy");
        queue2.add("Jenny");
        queue2.add("Raiga");
        queue2.add("Meisany");
        System.out.println(queue2);

        BlockingQueue<Integer> queue3 = new SynchronousQueue<>();
        // Each insert operation must wait for a corresponding remove operation by another thread and vice versa.
        // it cannot store elements , capacity of at most one element.

    }
}
