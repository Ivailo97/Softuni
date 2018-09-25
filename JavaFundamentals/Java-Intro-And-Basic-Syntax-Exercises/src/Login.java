import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        char[] array = username.toCharArray();

        String password = "";

        for (int i = 0; i < username.length(); i++) {
            password += array[username.length() - 1 - i];
        }

        String pass = scanner.nextLine();
        int counter = 0;
        boolean blocked = false;

        while (!pass.equals(password)) {

            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", username);
                blocked = true;
                break;
            }

            System.out.println("Incorrect password. Try again.");


            pass = scanner.nextLine();
        }

        if (!blocked) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
