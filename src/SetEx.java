import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetEx {
    public static void main(String[] args) {
        // Set is a collection that cannot contain duplicate elements.
        // Faster operations
        // Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
        // Set --> HashSet, LinkedHashSet, TreeSet, EnumSet

        NavigableSet<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(46);
        set.add(1);
        set.add(2);
        set.add(12);
        System.out.println(set);
        System.out.println(set.contains(12));
        System.out.println(set.remove(67));
        set.clear();
        System.out.println(set.isEmpty());
        for(int i: set){
            System.out.println(i);
        }

        // For thread safety

        Set<Integer> set1 = new ConcurrentSkipListSet<>();

        // Unmodifiable

        Set<Integer> integers = Set.of(1,2,3,4,5,8,7,6,43,83);
    }
}
