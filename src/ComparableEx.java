import java.util.ArrayList;
import java.util.List;

public class ComparableEx {
    public static void main(String[] args) {
        List<Student> student = new ArrayList<>();
        student.add(new Student("Andy",4.5));
        student.add(new Student("Mandy",5.5));
        student.add(new Student("Syndy",9.8));
        student.add(new Student("Rosita",9.8));
        student.add(new Student("Neon",5.6));

        student.sort(null);
        System.out.println(student);
    }
}
