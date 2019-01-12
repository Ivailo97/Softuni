using System;
using System.Collections.Generic;
using System.Linq;

namespace Articles2._0
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Article> articles = new List<Article>();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] tokens = Console.ReadLine().Split(", ");
                string title = tokens[0];
                string content = tokens[1];
                string authort = tokens[2];

                Article article = new Article(title, content, authort);

                articles.Add(article);

            }
            string sort = Console.ReadLine();
            if (sort == "title")
            {
               articles =  articles.OrderBy(x => x.Title).ToList();
            }
            else if (sort == "content")
            {
                articles = articles.OrderBy(x => x.Content).ToList();
            }
            else
            {
                articles = articles.OrderBy(x => x.Author).ToList();
            }

            foreach (var item in articles)
            {
                item.ToStringg();
            }
        }
    }

    class Article
    {
        public string Title { get; set; }
        public string Content { get; set; }
        public string Author { get; set; }

        public Article(string title, string content, string author)
        {
            this.Title = title;
            this.Content = content;
            this.Author = author;
        }

        public void ToStringg()
        {
            Console.WriteLine($"{Title} - {Content}: {Author}");
        }
    }
}
