using System;
using System.Collections.Generic;
using System.Linq;

namespace Students2._0
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Student> students = new List<Student>();

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "end")
                {
                    break;
                }

                string[] tokens = line.Split(" ");

                string firstName = tokens[0];
                string lastName = tokens[1];
                int age = int.Parse(tokens[2]);
                string town = tokens[3];

                Student currentStudent = new Student(firstName, lastName, town, age);

                Student student = students.FirstOrDefault(x => x.FirstName == firstName && x.LastName == lastName);

                if (student == null)
                {
                    students.Add(currentStudent);
                }
                else
                {

                    student.Age = age;
                    student.HomeTown = town;
                }
            }

            string input = Console.ReadLine();

            foreach (var student in students)
            {
                if (student.HomeTown == input)
                {
                    Console.WriteLine($"{student.FirstName} {student.LastName} is {student.Age} years old.");
                }
            }
        }
    }

    class Student
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string HomeTown { get; set; }
        public int Age { get; set; }

        public Student(string firstName, string lastName, string hometown, int age)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.HomeTown = hometown;
            this.Age = age;
        }
    }
}
