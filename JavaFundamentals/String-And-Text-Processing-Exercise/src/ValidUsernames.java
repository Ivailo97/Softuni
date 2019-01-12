import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");


        for (String name : names)
        {
            boolean flag = true;

            if (name.length() >= 3 && name.length() <= 16)
            {
                for (char symbol : name.toCharArray())
                {
                    if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_')
                    {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                {
                    System.out.println(name);
                }
            }
        }
    }
}
