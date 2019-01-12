using System;
using System.Collections.Generic;

namespace Songs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<Song> songs = new List<Song>();

            for (int i = 0; i < n; i++)
            {
                string[] tokens = Console.ReadLine().Split('_');
                string type = tokens[0];
                string name = tokens[1];
                string duration = tokens[2];
                Song song = new Song(type, name, duration);

                songs.Add(song);

            }

            string line = Console.ReadLine();

            if (line == "all")
            {
                foreach (Song song in songs)
                {
                    Console.WriteLine(song.Name);
                }
            }
            else
            {
                foreach (Song song in songs)
                {
                    if (song.TypeList == line)
                    {
                        Console.WriteLine(song.Name);
                    }
                }
            }
        }
    }

    class Song
    {
        public string  TypeList{ get; set; }
        public string Name { get; set; }
        public string Time { get; set; }

        public  Song (string type,string name, string time)
        {
            this.Name = name;
            this.TypeList = type;
            this.Time = time;
        }
    }
}
