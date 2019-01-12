using System;

namespace ValidUsernames
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names = Console.ReadLine().Split(", ");
            

            foreach (string name in names)
            {
                bool flag = true;

                if (name.Length >= 3 && name.Length <= 16)
                {
                    foreach (char symbol in name)
                    {
                        if (!char.IsLetterOrDigit(symbol) && symbol != '-' && symbol != '_')
                        {
                            flag = false;
                            break;
                        }
                    }

                    if (flag)
                    {
                        Console.WriteLine(name);
                    }
                }
            }
        }
    }
}
