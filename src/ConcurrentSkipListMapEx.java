import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapEx {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String,Integer> map = new ConcurrentSkipListMap<>();
        map.put("Alexander",2);
    }
}
