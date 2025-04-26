import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethodEx {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();

        Person p1 = new Person("Dany",1);
        Person p2 = new Person("Alice",2);
        Person p3 = new Person("Dany",1);

        map.put(p1,"Engineer");
        map.put(p2,"Designer");
        map.put(p3,"Manager");

        // Above map will provide 3 entries in the map even if the p1 and p3 data are same.
        // They are two different objects in the head memory so their hashcodes are different.

        // But when we use the Override the hashcode and equals method in the Person class then the
        // p3 value is replaced by checking whether the object values are equal if equal replace it or if not new entry created.

        map.put(p1,"Engineer"); // hashcode1 ===> index1
        map.put(p2,"Designer"); // hashcode2 ===> index2
        map.put(p3,"Manager"); // hashcode1 ===> index1 ==> equals ===> replace

        System.out.println("HashMap Size: " + map.size());
        System.out.println("Value for p1: " + map.get(p1));
        System.out.println("Value for p3: " + map.get(p3));


        // Consider new map
        Map<String,Integer> newMap = new HashMap<>();
        newMap.put("Anika",90); // hashcode1 ===> index1
        newMap.put("Belin",89); // hashcode2 ===> index2
        newMap.put("Anika",99); // hashcode1 ===> index1 ===> equals() ===> replace.
        // In this using the hashcode method the Anika value 90 is replaced by 99.

    }
}

class Person{
    private String name;
    private int id;


    public Person(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
