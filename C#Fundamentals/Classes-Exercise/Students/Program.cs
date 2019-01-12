using System;
using System.Collections.Generic;
using System.Linq;

namespace Students
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Student> students = new List<Student>();
            for (int i = 0; i < n; i++)
            {
                string[] data = Console.ReadLine().Split();
                string firstName = data[0];
                string lasttName = data[1];
                double grade = double.Parse(data[2]);

                Student student = new Student(firstName, lasttName, grade);

                students.Add(student);

            }

            foreach (var student in students.OrderByDescending(x=>x.Grade))
            {
                Console.WriteLine($"{student.FirstName} {student.LastName}: {student.Grade:f2}");
            }
        }
    }

    class Student
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public double Grade { get; set; }

        public Student(string first, string last , double grade)
        {
            this.FirstName = first;
            this.LastName = last;
            this.Grade = grade;
        }
    }
}
