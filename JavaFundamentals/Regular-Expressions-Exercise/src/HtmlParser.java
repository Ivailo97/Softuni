import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern titlePattern = Pattern.compile("(?<=<title>).+(?=<\\/title>)");
        Pattern bodyPattern = Pattern.compile("(?<=>|\\\\n|<body>)(?<!<title>)[^<>\\n\\d\\\\]+?(?=<|<\\/body>)");

        Matcher titleMatcher = titlePattern.matcher(text);
        String title = "";
        if (titleMatcher.find()){
             title = titleMatcher.group(0);
        }

        Matcher bodyMatcher = bodyPattern.matcher(text);
        StringBuilder sb = new StringBuilder();

        while (bodyMatcher.find())
        {
            sb.append(bodyMatcher.group(0) + " ");
        }

        System.out.printf("Title: %s%n",title);
        System.out.printf("Content: %s%n",sb);
    }
}
