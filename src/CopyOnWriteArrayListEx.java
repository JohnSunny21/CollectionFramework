import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        // "Copy on write" means that whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that copy
        // This ensures that other threads reading the list while it's being modified are unaffected.

        // Read Operations: Fast and Direct, since they happen on a stable list without interference from modifications.
        // Write Operations: A new Copy of the list is created for every modification.
        // The reference to the list is then updated so that subsequent reads use this new list.

        // notepad --> notepad-copy (multiple users at a time and modified the same file example).


        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List: "+shoppingList);

        for(String item: shoppingList){
            System.out.println(item);
            //Try to modify the list while reading
            if(item.equals("Eggs")){
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading the list.");
            }
        }

        System.out.println("After updating the list will be : "+shoppingList);

        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");

        Thread readerThread = new Thread(()-> {
            try{
                while(true){
                    for(String item: sharedList){
                        System.out.println("Reading Item : "+ item );
                        Thread.sleep(100);
                    }
                }
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("Exception in the reader Thread : " + e);
            }
        });


        Thread writerThread = new Thread(()-> {
            try{
                Thread.sleep(500);
                sharedList.add("Item4");
                System.out.println("Added Item4 to the list.");

                Thread.sleep(500);
                sharedList.remove("Item2");
                System.out.println("Removed Item1 from the list.");
            }catch(Exception ex){
                Thread.currentThread().interrupt();
                System.out.println("Exception in the Writer Thread : " +ex);
            }
        });

        readerThread.start();
        writerThread.start();
    }
}
