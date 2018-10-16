using System;

namespace PasswordValidator
{
    class Program
    {
        static void Main(string[] args)
        {
            string password = Console.ReadLine();

            PrintMessage(password);
        }

        private static void PrintMessage(string password)
        {
            bool isValidLen = CheckForLength(password);
            bool areValidSymbols = CheckForSymbols(password);
            bool haveTwoDigits = CheckForDigits(password);

            if (isValidLen && areValidSymbols && haveTwoDigits)
            {
                Console.WriteLine("Password is valid");
            }
            else
            {
                if (!isValidLen)
                {
                    Console.WriteLine("Password must be between 6 and 10 characters");
                }

                if (!areValidSymbols)
                {
                    Console.WriteLine("Password must consist only of letters and digits");
                }

                if (!haveTwoDigits)
                {
                    Console.WriteLine("Password must have at least 2 digits");
                }
            }
        }

        private static bool CheckForDigits(string password)
        {
            bool result = false;
            int count = 0;

            for (int i = 0; i < password.Length; i++)
            {
                if (char.IsDigit(password[i]))
                {
                    count++;

                    if (count == 2)
                    {
                        result = true;
                        break;
                    }
                }
            }

            return result;
        }

        private static bool CheckForSymbols(string password)
        {
            bool result = false;

            for (int i = 0; i < password.Length; i++)
            {
                if (char.IsDigit(password[i]) || char.IsLetter(password[i]))
                {
                    result = true;

                }
                else
                {
                    result = false;
                    break;
                }
            }

            return result;
        }

        private static bool CheckForLength(string password)
        {
            bool result = true;

            if (password.Length > 10 || password.Length < 6)
            {
                result = false;
            }

            return result;
        }
    }
}
