package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<User> users = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split(" ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            User user = new User(name,age);

            users.add(user);
        }

        users.stream().filter(x-> x.getAge() > 30).sorted(Comparator.comparing(User::getName)).forEach(
                y -> System.out.println(y.toString())
        );
    }
}
