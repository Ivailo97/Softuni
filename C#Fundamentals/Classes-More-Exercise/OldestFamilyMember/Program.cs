using System;
using System.Collections.Generic;
using System.Linq;

namespace OldestFamilyMember
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Family family = new Family();

            for (int i = 0; i < n; i++)
            {
                string[] data = Console.ReadLine().Split();
                string name = data[0];
                int age = int.Parse(data[1]);

                Person person = new Person(name, age);

                family.AddMember(person);
            }

            Person oldest = family.GetOldest();

            Console.WriteLine(oldest.Name + " " + oldest.Age);
        }
    }

    class Family
    {
        public List<Person> People { get; set; }

        public void AddMember(Person person)
        {
            this.People.Add(person);
        }

        public Person GetOldest()
        {
            Person person = People.OrderByDescending(x => x.Age).First();

            return person;
        }

        public Family()
        {
            this.People = new List<Person>();
        }
    }

    class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public Person(string name, int age)
        {
            this.Age = age;
            this.Name = name;
        }
    }
}
