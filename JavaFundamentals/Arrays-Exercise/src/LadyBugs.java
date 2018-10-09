import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] bugsPositions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] field = new int[size];

        for (int i = 0; i < bugsPositions.length; i++)
        {
            if (bugsPositions[i] >= 0 && bugsPositions[i] < size)
            {
                int index = bugsPositions[i];
                field[index] = 1;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end"))
        {
            String[] tokens = command.split(" ");

            int bugPosition = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            boolean condition = bugPosition < 0
                    || bugPosition >= size
                    || field[bugPosition] != 1
                    || distance == 0;

            if (condition)
            {
                command = scanner.nextLine();
                continue;
            }

            Move(field, direction, bugPosition, distance);
        }

        String[] stringField = new String [field.length];

        for (int i = 0; i < field.length; i++) {

            stringField[i] = String.valueOf(field[i]);

        }
        System.out.println(String.join(" ", stringField));
    }

    public static void Move(int[] field, String direction, int position, int distance)
    {
        int startIndex = 0;
        boolean hasChanged = false;

        switch (direction)
        {
            case "right":
                startIndex = position + distance;
                field[position] = 0;

                for (int i = startIndex; i < field.length; i += distance)
                {
                    if (field[i] == 0)
                    {
                        field[i] = 1;
                        field[position] = 0;

                        hasChanged = true;
                        break;
                    }
                }

                break;

            case "left":
                startIndex = position - distance;
                field[position] = 0;

                for (int i = startIndex; i >= 0; i -= distance)
                {
                    if (field[i] == 0)
                    {
                        field[i] = 1;
                        field[position] = 0;

                        hasChanged = true;
                        break;
                    }
                }
                break;
        }

        if (!hasChanged)
        {
            field[position] = 0;
        }
    }
}
