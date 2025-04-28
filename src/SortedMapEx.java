import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapEx {
    public static void main(String[] args) {
        SortedMap<Integer,String> map = new TreeMap<>((a,b)-> b-a);
        map.put(45,"Dorkey");
        map.put(55,"Lena");
        map.put(75,"Serine");
        map.put(76,"Vjara");
        map.put(78,"Rheanyra");
        map.get(78);
        System.out.println(map.containsKey(75));
        System.out.println(map.containsKey(100));
        System.out.println(map.containsValue(76));


        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(55)); // exclude 55 key and print all the keys,value pairs after that.
        System.out.println(map.tailMap(55)); // include 55 key and print all key,value pairs from 55 to below values.

        NavigableMap<Integer,String> navigableMap = new TreeMap<>();
        navigableMap.put(1,"One");
        navigableMap.put(2,"Two");
        navigableMap.put(3,"Three");
        navigableMap.put(4,"Four");
        navigableMap.put(5,"Five");
        navigableMap.put(0,"Zero");

        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(4));
        System.out.println(navigableMap.ceilingKey(3));
        System.out.println(navigableMap.higherEntry(1));
        System.out.println(navigableMap.descendingMap());

    }
}
