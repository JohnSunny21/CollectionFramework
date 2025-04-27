import java.util.Hashtable;

public class HashTableEx {
    public static void main(String[] args) {
        Hashtable<Integer,String> hashtable = new Hashtable<>();

        /*
        HashTable is synchronized and no null key or no null value in it.
        Slower than hashmap because it is synchronized.
        Linked List is used in case of collision
        Methods are synchronized.
         */

        hashtable.put(1,"Apple");
        hashtable.put(2,"Banana");
        hashtable.put(3,"Cherry");
        System.out.println(hashtable);

        System.out.println("Value of the key 3 is : " +hashtable.get(3));
        System.out.println("Does key 1 exist? " + hashtable.containsKey(1));
        hashtable.remove(1); // remove the element using the key.

        System.out.println("After removing : " + hashtable);
        // if we try to insert null value as a key or as a value then Exception arises.
//        hashtable.put(null,"entry"); // throws exception
//        hashtable.put(4,"null"); // throws exception



        Hashtable<Integer,String> table = new Hashtable<>();
        Thread thread1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                table.put(i,"Thread1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i=1000;i<2000;i++){
                table.put(i,"Thread2");
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            System.out.println(ex);
        }

        System.out.println("Total size of the HashTable is : " + table.size());
    }
}
