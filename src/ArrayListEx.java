import java.util.*;

class Student implements Comparable<Student>{
    private final String name;
    private final double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGpa(),this.getGpa());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length(); // It is ascending order . For Descending use o2 - o1.
    }
}

class IntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // returns Descending Order.
    }
}
public class ArrayListEx {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(5);

        System.out.println(list.get(2)); // Gets the third element in the list i.e => 4.
        System.out.println(list.size()); // Gets the size of the list.
        for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }

        for(int x: list){
            System.out.println(x);  // Enhanced For-loop
        }

        System.out.println(list.contains(5));
        System.out.println(list.contains(50));

        list.remove(2);
        for(int x: list){
            System.out.println(x);
        }

        list.add(2,50);
        for(int x: list){
            System.out.println(x);
        }

        list.add(1);
        list.add(5);
        list.add(80);
        System.out.println(list);

        list.set(2,80); // replaces index 2 with 50;
        System.out.println(list);




        List<String> list1 = new ArrayList<>();
        System.out.println(list1.getClass().getName());

        List<String> list2 = Arrays.asList("Sunday","Monday","Tuesday");
        System.out.println(list2);
        System.out.println(list2.getClass().getName());
        list2.set(1,"Wednesday");
        System.out.println(list2);

        String[] array = {"Apple","Banana","Coconuts"};
        List<String> list3 = Arrays.asList(array);  //The asList() method returns a fixed list can replace the values with new ones but cannot be added new ones.
        // Can also create the Lists by using the array.
        System.out.println(list3.getClass().getName());

        List<String> list4 = new ArrayList<>(list2);
        // Can also create the list using another list.
        list4.add("Saturday");
        System.out.println(list4);

        List<Integer> list5 = List.of(1, 2, 3, 4); // The of() method Returns an unmodifiable list containing  elements
//        list5.set(1,33);  // Exception tries to modify the unmodifiable list.

        List<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(2);
        list6.add(3);

        list6.remove(2); // Given the int then it works as an index
        // If we want to remove the value '2' from the list6 then we need to convert it to Integer
        // Because list has another overloaded remove method which takes the object as an argument.
        list6.remove(Integer.valueOf(2)); // removes the value 2 from the list6.

        Object[] array1 = list6.toArray();
        // creating an array from list.
        // creating an Integer array from list.
        Integer[] array2 = list.toArray(new Integer[0]);


        List<String> fruits = Arrays.asList("Apple","Cherry","Coconut","Banana","JackFruit");
        fruits.sort((a,b)->b.length() - a.length()); // sorts in the descending order.
        System.out.println(fruits);

        List<Integer> list7 = new ArrayList<>();
        list7.add(2);
        list7.add(3);
        list7.add(4);
        list7.add(1);
        list7.add(8);
        list7.add(10);
        list7.add(11);

        list7.sort(null); // sorts the list in ascending order which is default.
        // or list.sort((a,b)-> a -b)); to be sorted in ascending order.
        System.out.println(list7);


        List<Student> students = new ArrayList<>();
        students.add(new Student("Sunny",3.9));
        students.add(new Student("Alice",4.7));
        students.add(new Student("Rosita",9.9));
        students.add(new Student("Edward",5.8));
        students.add(new Student("Bella",4.8));

        // Sorts the students according to the gpa in descending order if the order consists of some name with same
        // gpa then we compare the names and sort them.
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        students.sort(comparator);
        for(Student s: students){
            System.out.println(s.getName() + " : " + s.getGpa());
        }

    }


}
