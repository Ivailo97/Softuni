import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String town = tokens[3];
            Student student = new Student(firstName, lastName, town, age);
            students.add(student);
        }

        String input = scanner.nextLine();

        for (var student : students) {
            if (student.HomeTown.equals(input)) {

                System.out.printf("%s %s is %d years old%n",student.FirstName,student.LastName,student.Age);
            }
        }
    }
}

class Student {
    public String FirstName;
    public String LastName;
    public String HomeTown;
    public int Age;

    public Student(String firstName, String lastName, String hometown, int age) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.HomeTown = hometown;
        this.Age = age;
    }
}
