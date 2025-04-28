import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new IdentityHashMap<>();
        String key1 = new String("Akshit");
        String key2 = new String("Akshit");

        map.put(key1, 85);
        map.put(key2, 90);


        System.out.println(map);
    }
}
