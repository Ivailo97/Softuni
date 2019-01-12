using System;
using System.Collections.Generic;
using System.Linq;

namespace ForceBook
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, List<string>> sideAndUsers = new Dictionary<string, List<string>>();

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "Lumpawaroo")
                {
                    break;
                }

                if (line.Contains(" | "))
                {
                    string[] tokens = line.Split(" | ");
                    string side = tokens[0];
                    string user = tokens[1];

                    bool contains = false;

                    foreach (var pair in sideAndUsers)
                    {
                        foreach (var name in pair.Value)
                        {
                            if (name == user)
                            {
                                contains = true;
                                break;
                            }
                        }
                    }

                    if (!contains)
                    {

                        if (!sideAndUsers.ContainsKey(side))
                        {
                            sideAndUsers.Add(side, new List<string>());
                        }

                        sideAndUsers[side].Add(user);
                    }
                }
                else
                {
                    string[] tokens = line.Split(" -> ");
                    string user = tokens[0];
                    string side = tokens[1];

                    bool contains = false;

                    foreach (var pair in sideAndUsers)
                    {
                        foreach (var name in pair.Value)
                        {
                            if (name == user)
                            {
                                contains = true;
                                break;
                            }
                        }
                    }

                    if (contains)
                    {
                        string prevSide = "";

                        foreach (var pair in sideAndUsers)
                        {
                            if (pair.Value.Contains(user))
                            {
                                prevSide = pair.Key;
                            }
                        }

                        sideAndUsers[prevSide].Remove(user);

                        if (!sideAndUsers.ContainsKey(side))
                        {
                            sideAndUsers.Add(side, new List<string>());
                        }

                        sideAndUsers[side].Add(user);
                        Console.WriteLine($"{user} joins the {side} side!");

                    }
                    else
                    {

                        if (!sideAndUsers.ContainsKey(side))
                        {
                            sideAndUsers.Add(side, new List<string>());
                        }

                        sideAndUsers[side].Add(user);

                        Console.WriteLine($"{user} joins the {side} side!");
                    }
                }
            }

            foreach (var pair in sideAndUsers.OrderByDescending(x => x.Value.Count).ThenBy(x => x.Key))
            {
                if (pair.Value.Count != 0)
                {
                    Console.WriteLine($"Side: {pair.Key}, Members: {pair.Value.Count}");

                    foreach (string name in pair.Value.OrderBy(x => x))
                    {
                        Console.WriteLine($"! {name}");
                    }
                }
            }
        }
    }
}
