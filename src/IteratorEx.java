import java.util.*;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        for (int i : list) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        for (Integer i : numbers) {
            if (i % 2 == 0) {
               // numbers.remove(i); // Concurrent Modification Exception (we cannot modify the list while iterating over it
                //using for loop.
            }

        }

        Iterator<Integer> itr = numbers.iterator();
        while(itr.hasNext()){
            Integer i = itr.next();
            if(i%2==0){
                itr.remove(); // using iterator we can remove the element while iterating.
            }
        }

        System.out.println(numbers);

        ListIterator<Integer> listIterator = numbers.listIterator();
        while(listIterator.hasNext()){
            listIterator.next();
//            listIterator.set(); // we can also set the value in this listIterator when some condition is met.
            // The listIterator has some additional methods than Iterator.
        }

    }
}
