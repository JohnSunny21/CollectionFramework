import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheEx<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRUCacheEx(int capacity){
        super(capacity,0.75f,true);
        this.capacity= capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {

        LRUCacheEx<String,Integer> studentMap = new LRUCacheEx<>(3);
        studentMap.put("Dany",99);
        studentMap.put("Ramen",45);
        studentMap.put("Carie",99);
        studentMap.put("Joey",94);

        System.out.println(studentMap.get("Dany"));

        System.out.println(studentMap);
    }
}
