import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(11,0.3f,true);
        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Apple",20);
        linkedHashMap.put("PineApple",23);

        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("PineApple");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Apple");
        linkedHashMap.get("PineApple");

        for(Map.Entry<String,Integer> entry: linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + " <== : ==> " + entry.getValue());
        }

        HashMap<String,Integer> hashMap = new HashMap<>();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(hashMap);

        hashMap.put("Sunny",47);
        hashMap.put("Bunny",99);
        hashMap.put("Dany",73);

        Integer stray = hashMap.getOrDefault("Stray", 0);
        System.out.println(stray);
        hashMap.put("Bunny",20);
        System.out.println(hashMap);
    }
}
