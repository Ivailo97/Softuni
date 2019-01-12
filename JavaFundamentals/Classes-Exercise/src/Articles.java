import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        String title = tokens[0];
        String content = tokens[1];
        String author = tokens[2];

        Article1 article = new Article1(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] action = scanner.nextLine().split(": ");

            if (action[0].equals("Edit")) {
                article.Edit(action[1]);
            } else if (action[0].equals("ChangeAuthor")) {
                article.ChangeAuthor(action[1]);
            } else if (action[0].equals("Rename")) {
                article.Rename(action[1]);
            }
        }

        article.ToStringg();
    }
}


class Article1 {
    public String Title;
    public String Content;
    public String Author;

    public Article1(String title, String content, String author) {
        this.Title = title;
        this.Content = content;
        this.Author = author;
    }

    public void Edit(String content) {
        this.Content = content;
    }

    public void ChangeAuthor(String newAuthor) {
        this.Author = newAuthor;
    }

    public void Rename(String title) {
        this.Title = title;
    }

    public void ToStringg() {
        System.out.printf("%s - %s: %s%n", Title, Content, Author);
    }
}
