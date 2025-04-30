import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueEx {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(()-> {
            try{
                System.out.println("Producer is waiting to transfer...");
                queue.put("Hello from produer");
                System.out.println("Producer has transferred the message.");
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
                System.err.println("Producer was interrupted.");
            }
        });

        Thread consumer = new Thread(()->{
            try{
                System.out.println("Consumer is waiting to receive...");
                String message = queue.take();
                System.out.println("Consumer received: " + message);
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
                System.err.println("Consumer was interrupted.");
            }
        });

        producer.start();
        consumer.start();
    }
}
