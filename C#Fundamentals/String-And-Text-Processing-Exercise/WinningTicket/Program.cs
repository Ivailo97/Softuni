using System;
using System.Text.RegularExpressions;

namespace WinningTicket
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] tickets = Console.ReadLine().Split(',',' ', StringSplitOptions.RemoveEmptyEntries);
            Regex regex = new Regex(@"([\^]{6,10}|[\$]{6,10}|[\@]{6,10}|[#]{6,10})");

            for (int i = 0; i < tickets.Length; i++)
            {
                tickets[i] = tickets[i].Trim();
            }

            foreach (var ticket in tickets)
            {

                if (ticket.Length != 20)
                {
                    Console.WriteLine("invalid ticket");
                }
                else
                {
                    string firstHalf = ticket.Substring(0, 10);
                    string secondHalf = ticket.Substring(10);

                    Match firstMatch = regex.Match(firstHalf);
                    int len1 = firstMatch.ToString().Length;
                    Match secondMatch = regex.Match(secondHalf);
                    int len2 = secondMatch.ToString().Length;

                    int minLen = Math.Min(len1, len2);

                    if ( minLen >= 6 && firstMatch.ToString()[0] == secondMatch.ToString()[0])
                    {
                        if  (minLen <= 9)
                        {
                            Console.WriteLine($"ticket \"{ticket}\" - {minLen}{firstMatch.ToString()[0]}");
                        }
                        else if (minLen == 10)
                        {
                            Console.WriteLine($"ticket \"{ticket}\" - {minLen}{firstMatch.ToString()[0]} Jackpot!");
                        }
                    }
                    else
                    {
                        Console.WriteLine($"ticket \"{ticket}\" - no match");
                    }
                }
            }
        }
    }
}
