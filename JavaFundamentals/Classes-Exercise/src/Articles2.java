import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];
            Article article = new Article(title, content, author);
            articles.add(article);

        }
        String sort = scanner.nextLine();
        if (sort.equals("title")) {
            articles = articles.stream().sorted(Comparator.comparing(Article::GetTitle)).collect(Collectors.toList());
        } else if (sort.equals("content")) {
            articles = articles.stream().sorted(Comparator.comparing(Article::GetContent)).collect(Collectors.toList());
        } else {
            articles = articles.stream().sorted(Comparator.comparing(Article::GetAuthor)).collect(Collectors.toList());
        }

        for (var item : articles) {
            String result = item.toString();
            System.out.println(result);
        }
    }
}

class Article {
    private String Title;
    private String Content;
    private String Author;

    public Article(String title, String content, String author) {
        this.Title = title;
        this.Content = content;
        this.Author = author;
    }

    @Override
    public String toString() {


        return String.format("%s - %s: %s%n", Title, Content, Author);
    }

    public String GetTitle() {

        return Title;
    }

    public String GetAuthor() {

        return Author;
    }

    public String GetContent() {

        return Content;
    }
}
