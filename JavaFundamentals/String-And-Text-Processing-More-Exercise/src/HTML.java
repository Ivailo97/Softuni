import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String article = scanner.nextLine();
        String content = scanner.nextLine();
        List<String>  comments = new ArrayList<>();

        while(true){

            String comment = scanner.nextLine();

            if (comment.equals("end of comments")){
                break;
            }
            comments.add(comment);
        }

        article = String.format("<h1>\n %s\n</h1>\n",article);
        content = String.format("<article>\n %s\n</article>\n",content);
        System.out.print(article);
        System.out.print(content);

        for (String comment : comments) {

            System.out.printf("<div>\n %s\n</div>\n",comment);
        }
    }
}
