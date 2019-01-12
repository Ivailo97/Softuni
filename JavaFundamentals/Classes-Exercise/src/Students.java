import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String firstName = data[0];
            String lastName = data[1];
            double grade = Double.parseDouble(data[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        students.stream().sorted((e1, e2) -> Double.compare(e2.Grade, e1.Grade)).forEach(x -> {

            System.out.printf("%s %s: %.2f%n", x.FirstName, x.LastName, x.Grade);
        });
    }
}


class Student {
    public String FirstName;
    public String LastName;
    public double Grade;

    public Student(String first, String last, double grade) {
        this.FirstName = first;
        this.LastName = last;
        this.Grade = grade;
    }
}
