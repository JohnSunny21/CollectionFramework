import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>(17,0.5f);
        map.put(22,"Alex");
        map.put(23,"Dany");
        map.put(45,"Fiona");
        map.put(1,"Nikki");
        map.put(2,"Saijin");
        System.out.println(map);


        String sName = map.get(45);
        System.out.println(sName);
        String s = map.get(50);
        System.out.println(s);

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Fiona"));

        for(int i: map.keySet()){
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer,String> entry: entries){
            entry.setValue(entry.getValue().toUpperCase());
        }

        System.out.println(map);

        map.remove(1);
        System.out.println(map);

        boolean res = map.remove(88, "Esme");
        System.out.println("Removed (True or False) : " + res);
        System.out.println(map);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean contains = list.contains(6);
        System.out.println(contains);

    }
}
