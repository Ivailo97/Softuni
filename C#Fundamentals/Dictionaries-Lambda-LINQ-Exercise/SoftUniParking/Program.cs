using System;
using System.Linq;
using System.Collections.Generic;

namespace SoftUniParking
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> register = new Dictionary<string, string>();
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] tokens = Console.ReadLine().Split();
                string action = tokens[0];
                string name = tokens[1];

                switch (action)
                {
                    case "register":

                        string licenseNumber = tokens[2];
                        try
                        {
                            register.Add(name, licenseNumber);
                            Console.WriteLine($"{name} registered {licenseNumber} successfully");
                        }
                        catch (Exception)
                        {
                            Console.WriteLine($"ERROR: already registered with plate number {register[name]} ");
                        }
                        break;
                    case "unregister":

                        if (!register.ContainsKey(name))
                        {
                            Console.WriteLine($"ERROR: user {name} not found");
                        }
                        else
                        {
                            register.Remove(name);
                            Console.WriteLine($"{name} unregistered successfully");
                        }
                        break;
                }
            }

            foreach (var pair in register)
            {
                Console.WriteLine($"{pair.Key} => {pair.Value}");
            }
        }
    }
}
