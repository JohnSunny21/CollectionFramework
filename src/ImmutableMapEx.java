import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapEx {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("Andrea",1);
        map.put("Bulma",2);
        Map<String,Integer> map1 = Collections.unmodifiableMap(map);
        System.out.println(map1);
//        map1.put("Vegeta",3); // throws exception
        map.put("Vegeta",3); // no exception
        System.out.println(map);

        Map<String,Integer> map3 = Map.of("Zoel",22,"Krai",58);
        // But with the above method we are able to create only entries limited for only 10 .
        Map<String,Integer> map4 = Map.ofEntries(Map.entry("Andy",10),Map.entry("Brad",99));
    }
}
