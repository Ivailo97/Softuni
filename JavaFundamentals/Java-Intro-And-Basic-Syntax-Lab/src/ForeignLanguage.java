import java.util.Scanner;

public class ForeignLanguage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        switch (country) {
            case "USA":
            case "England":

                System.out.println("English");
                break;

            case "Mexico":
            case "Argentina":
            case "Spain":

                System.out.println("Spanish");
                break;

            default:
                System.out.println("unknown");
                break;
        }
    }
}
