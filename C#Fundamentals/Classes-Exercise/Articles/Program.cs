using System;
using System.Collections.Generic;
using System.Linq;

namespace Articles
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine().Split(", ");
            string title = tokens[0];
            string content = tokens[1];
            string authort = tokens[2];

            Article article = new Article(title, content, authort);

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] action = Console.ReadLine().Split(": ");

                if (action[0] == "Edit")
                {
                    article.Edit(action[1]);
                }
                else if (action[0] == "ChangeAuthor")
                {
                    article.ChangeAuthor(action[1]);
                }
                else if (action[0] == "Rename")
                {
                    article.Rename(action[1]);
                }
            }

            article.ToStringg();
        }
    }

    class Article
    {
        public string Title { get; set; }
        public string Content { get; set; }
        public string Author { get; set; }

        public Article(string title , string content , string author)
        {
            this.Title = title;
            this.Content = content;
            this.Author = author;
        }

        public void Edit(string content)
        {
            this.Content = content;
        }

        public void ChangeAuthor(string newAuthor)
        {
            this.Author = newAuthor;
        }

        public void Rename(string title)
        {
            this.Title = title;
        }

        public void ToStringg()
        {
            Console.WriteLine($"{Title} - {Content}: {Author}");
        }
    }
}
