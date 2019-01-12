using System;
using System.Collections.Generic;
using System.Linq;

namespace CompanyRoster
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Department> departments = new List<Department>();

            for (int i = 0; i < n; i++)
            {
                string[] data = Console.ReadLine().Split();
                string name = data[0];
                double salary = double.Parse(data[1]);
                string department = data[2];

                Employee employee = new Employee(name, salary, department);

                Department current = departments.FirstOrDefault(x => x.Name == department);

                if (current !=  null)
                {
                    current.Employees.Add(employee);
                }
                else
                {
                    Department newDepartment = new Department(department, new List<Employee>());
                    newDepartment.Employees.Add(employee);
                    departments.Add(newDepartment);
                }
            }

            foreach (Department department in departments)
            {
                
                List<double> salaries = new List<double>();

                foreach (Employee employee in department.Employees)
                {
                    salaries.Add(employee.Salary);
                }

                department.Average = salaries.Average();

            }

            departments = departments.OrderByDescending(x => x.Average).ToList();

            Console.WriteLine($"Highest Average Salary: {departments[0].Name}");
            foreach (var  employee in departments[0].Employees.OrderByDescending(x=>x.Salary))
            {
                Console.WriteLine($"{employee.Name} {employee.Salary:f2}");
            }
        }
    }

    class Employee
    {
        public string Name { get; set; }
        public double Salary { get; set; }
        public string DepartmentName { get; set; }

        public Employee(string name, double salary, string dpName)
        {
            this.DepartmentName = dpName;
            this.Name = name;
            this.Salary = salary;
        }
    }

    class Department
    {
        public string Name { get; set; }
        public List<Employee> Employees { get; set; }
        public double Average { get; set; }

        public Department(string name, List<Employee> employees)
        {
            this.Employees = employees;
            this.Name = name;

        }
    }
}
