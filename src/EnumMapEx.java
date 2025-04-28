import java.util.EnumMap;
import java.util.Map;

public class EnumMapEx {
    public static void main(String[] args) {

        // Array of size same as enum size.
        // no hashing
        // According to the Day Enum the size of the Array would be [,"Walk","Gym",,,,,]
        //ordinal/index is used for array.
        // It is faster than the HashMap.
        // It is Memory Efficient.
        Map<Day,String> map = new EnumMap<>(Day.class);
        map.put(Day.TUESDAY,"Gym");
        map.put(Day.MONDAY,"Walk");
        String s = map.get(Day.TUESDAY);
        System.out.println(map);
    }
}

enum Day{
    MONDAY, TUESDAY, WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}
