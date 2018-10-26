import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftuniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {

            String line = scanner.nextLine();

            if (line.equals("course start")) {
                break;
            }

            String[] tokens = line.split(":");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    AddLesson(tokens[1], lessons);
                    break;
                case "Insert":
                    InsertLesson(lessons, tokens);
                    break;
                case "Remove":
                    Remove(lessons, tokens[1]);
                    break;
                case "Swap":
                    Swap(lessons, tokens);
                    break;
                case "Exercise":
                    AddExercise(lessons, tokens[1]);
                    break;
            }
        }

        for (int i = 0; i < lessons.size(); i++) {

            System.out.println(i + 1 + "." + lessons.get(i));
        }
    }

    private static void AddExercise(List<String> lessons, String token) {

        if (lessons.contains(token) && !lessons.contains(token + "-Exercise")) {

            int index = lessons.indexOf(token);
            lessons.add(index + 1, token + "-Exercise");
        } else if (!lessons.contains(token)) {
            lessons.add(token);
            lessons.add(token + "-Exercise");
        }
    }

    private static void Swap(List<String> lessons, String[] tokens) {

        String first = tokens[1];
        String second = tokens[2];
        int firstIndex = -1;
        int secondIndex = -1;
        int firstExerciseIndex = -1;
        int secondExerciseIndex = -1;

        for (int i = 0; i < lessons.size(); i++) {

            String current = lessons.get(i);

            if (current.equals(first)) {
                firstIndex = i;
            } else if (current.equals(second)) {
                secondIndex = i;
            } else if (current.contains(first) && current.contains("Exercise")) {
                firstExerciseIndex = i;
            } else if (current.contains(second) && current.contains("Exercise")) {
                secondExerciseIndex = i;
            }
        }

        if (firstIndex != -1 && secondIndex != -1) {

            List<String> firstPart = new ArrayList<>();
            List<String> secondPart = new ArrayList<>();

            firstPart.add(lessons.get(firstIndex));
            if (firstExerciseIndex == firstIndex + 1) {
                firstPart.add(lessons.get(firstExerciseIndex));
            }

            secondPart.add(lessons.get(secondIndex));
            if (secondExerciseIndex == secondIndex + 1) {
                secondPart.add(lessons.get(secondExerciseIndex));
            }

            lessons.set(firstIndex, secondPart.get(0));
            lessons.set(secondIndex, firstPart.get(0));

            if (firstExerciseIndex == firstIndex + 1 && secondExerciseIndex != secondIndex + 1) {

                lessons.add(secondIndex + 1, lessons.get(firstExerciseIndex));
                lessons.remove(firstExerciseIndex + 1);
            } else if (firstExerciseIndex != firstIndex + 1 && secondExerciseIndex == secondIndex + 1) {

                lessons.add(firstIndex + 1, lessons.get(secondExerciseIndex));
                lessons.remove(secondExerciseIndex + 1);
            } else if (firstExerciseIndex == firstIndex + 1 && secondExerciseIndex == secondIndex + 1) {

                lessons.set(firstExerciseIndex, secondPart.get(1));
                lessons.set(secondExerciseIndex, firstPart.get(1));
            }
        }
    }

    public static void Remove(List<String> lessons, String token) {

        int lessonIndex = -1;
        int exerciseIndex = -1;

        for (int i = 0; i < lessons.size(); i++) {

            if (lessons.get(i).equals(token)) {
                lessonIndex = i;
            }

            if (lessons.get(i).contains("Exercise") && lessons.get(i).contains(token)) {

                exerciseIndex = i;
            }
        }

        if (lessonIndex != -1) {
            lessons.remove(lessonIndex);
        }

        if (exerciseIndex != -1 && lessonIndex != -1 && exerciseIndex > lessonIndex) {
            lessons.remove(exerciseIndex);
        }
    }

    public static void InsertLesson(List<String> lessons, String[] tokens) {

        String lessonToInsert = tokens[1];
        int index = Integer.parseInt(tokens[2]);

        if (!lessons.contains(lessonToInsert) && index >= 0 && index <= lessons.size()) {

            lessons.add(index, lessonToInsert);
        }
    }

    public static void AddLesson(String token, List<String> lessons) {

        if (!lessons.contains(token)) {

            lessons.add(token);
        }
    }
}
