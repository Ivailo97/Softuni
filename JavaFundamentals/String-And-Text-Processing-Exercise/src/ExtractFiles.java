import java.util.Scanner;

public class ExtractFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] path = scanner.nextLine().split("\\\\");

        String ext = path[path.length - 1]
                .substring(path[path.length - 1].lastIndexOf(".") + 1);
        String name  = path[path.length - 1]
                .substring(path[path.length - 1].lastIndexOf("\\") + 1, path[path.length - 1].lastIndexOf("."));

        System.out.printf("File name: %s\n", name);
        System.out.printf("File extension: %s\n", ext);
    }
}
