using System;

namespace Login
{
    class Program
    {
        static void Main(string[] args)
        {
            string username = Console.ReadLine();

            string password = "";

            for (int i = 0; i < username.Length; i++)
            {
                password += username[username.Length - 1 - i];
            }

            string pass = Console.ReadLine();
            int counter = 0;
            bool blocked = false;

            while (pass != password)
            {

                counter++;
                if (counter == 4)
                {
                    Console.WriteLine($"User {username} blocked!");
                    blocked = true;
                    break;
                }

                Console.WriteLine("Incorrect password. Try again.");


                pass = Console.ReadLine();
            }

            if (blocked == false)
            {
                Console.WriteLine($"User {username} logged in.");
            }
        }
    }
}
