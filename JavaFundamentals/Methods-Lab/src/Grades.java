import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        String result = Judge(grade);

        System.out.println(result);

    }

    private static String Judge(double grade) {

        if (grade >= 5.50) {

            return "Excellent";
        } else if (grade >= 4.50) {

            return "Very good";
        } else if (grade >= 3.50) {

            return "Good";
        } else if (grade >= 3.00) {

            return "Poor";
        } else {

            return "Fail";
        }
    }
}
