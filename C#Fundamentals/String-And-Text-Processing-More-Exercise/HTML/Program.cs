using System;
using System.Collections.Generic;

namespace HTML
{
    class Program
    {
        static void Main(string[] args)
        {
            string article = Console.ReadLine();
            string content = Console.ReadLine();
            List<string> comments = new List<string>();

            while (true)
            {

                string comment = Console.ReadLine();

                if (comment == "end of comments")
                {
                    break;
                }
                comments.Add(comment);
            }

            Console.WriteLine("<h1>");
            Console.WriteLine($"    {article}");
            Console.WriteLine("</h1>");
            Console.WriteLine("<article>");
            Console.WriteLine($"    {content}");
            Console.WriteLine("</article>");

            foreach (string comment in comments)
            {
                Console.WriteLine("<div>");
                Console.WriteLine($"    {comment}");
                Console.WriteLine("</div>");
            }
        }
    }
}
