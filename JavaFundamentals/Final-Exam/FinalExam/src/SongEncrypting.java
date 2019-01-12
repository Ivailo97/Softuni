import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncrypting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?<artist>[A-Z][a-z' ]+):(?<song>[A-Z ]+)$");
        StringBuilder result = new StringBuilder();

        while (!line.equals("end")) {

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {

                int key = matcher.group("artist").length();

                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) != ':' && line.charAt(i) != '\'' && line.charAt(i) != ' ') {

                        char current = line.charAt(i);

                        char toAppend;

                        if (current >= 65 && current <= 90){

                            toAppend = (char) (line.charAt(i) + key);

                            if (toAppend > 90){

                                toAppend = (char)('A' + (toAppend % 90) - 1);
                            }

                            result.append(toAppend);

                        }else if (current >= 97 && current <=122){

                            toAppend = (char) (line.charAt(i) + key);

                            if (toAppend > 122){

                                toAppend = (char)('a' + (toAppend % 122) - 1);
                            }

                            result.append(toAppend);
                        }


                    } else if (line.charAt(i) == ':') {

                        result.append('@');
                    } else {

                        result.append(line.charAt(i));
                    }
                }

                System.out.printf("Successful encryption: %s%n", result);
                result.setLength(0);

            } else {

                System.out.println("Invalid input!");
            }

            line = scanner.nextLine();
        }
    }
}
