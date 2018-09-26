using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;

namespace Intro_and_Basic_Syntax___Exercise_homework
{
    class Program
    {
        static void Main(string[] args)
        {

            ///USE INSTRUCTIONS
            ///1.Press Number 1-9 (3 times max (4 times max for numbers 7 , 9)
            ///2.Press Enter when you are reddy
            ///3.Press Space to clear Console
            ///Note:Pressed numbers are not displayed in the console


            var GSMtext = new Dictionary<string, string>();



            GSMtext["1"] = "";
            GSMtext["2"] = "a";
            GSMtext["22"] = "b";
            GSMtext["222"] = "c";
            GSMtext["2222"] = "";
            GSMtext["22222"] = "";
            GSMtext["222222"] = "";

            GSMtext["3"] = "d";
            GSMtext["33"] = "e";
            GSMtext["333"] = "f";
            GSMtext["3333"] = "";
            GSMtext["33333"] = "";
            GSMtext["333333"] = "";

            GSMtext["4"] = "g";
            GSMtext["44"] = "h";
            GSMtext["444"] = "i";
            GSMtext["4444"] = "";
            GSMtext["44444"] = "";
            GSMtext["444444"] = "";

            GSMtext["5"] = "j";
            GSMtext["55"] = "k";
            GSMtext["555"] = "l";
            GSMtext["5555"] = "";
            GSMtext["55555"] = "";
            GSMtext["555555"] = "";

            GSMtext["6"] = "m";
            GSMtext["66"] = "n";
            GSMtext["666"] = "o";
            GSMtext["6666"] = "";
            GSMtext["66666"] = "";
            GSMtext["666666"] = "";

            GSMtext["7"] = "p";
            GSMtext["77"] = "q";
            GSMtext["777"] = "r";
            GSMtext["7777"] = "s";
            GSMtext["77777"] = "";
            GSMtext["777777"] = "";

            GSMtext["8"] = "t";
            GSMtext["88"] = "u";
            GSMtext["888"] = "v";
            GSMtext["8888"] = "";
            GSMtext["88888"] = "";
            GSMtext["888888"] = "";

            GSMtext["9"] = "w";
            GSMtext["99"] = "x";
            GSMtext["999"] = "y";
            GSMtext["9999"] = "z";
            GSMtext["99999"] = "";
            GSMtext["999999"] = "";

            GSMtext["0"] = " ";
            GSMtext["00"] = "";
            GSMtext["000"] = "";
            GSMtext["0000"] = "";

            string temp = default(string);

            while (true)
            {

                ConsoleKeyInfo pass = Console.ReadKey(true);


                if (pass.Key == ConsoleKey.Enter)
                {

                    Console.Write(GSMtext[temp]);
                    temp = default(string);
                }
                else if (pass.Key == ConsoleKey.Spacebar)
                {

                    Console.Clear();

                }
                else
                {
                    temp = temp + pass.KeyChar;

                }



            }


        }

    }
}