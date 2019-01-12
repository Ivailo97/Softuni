package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> departments = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String email = "n/a";
            int age = -1;

            if (data.length == 6) {

                try {
                    age = Integer.parseInt(data[4]);
                    email = data[5];
                } catch (Exception a) {

                    age = Integer.parseInt(data[5]);
                    email = data[4];
                }
            } else if (data.length == 5) {

                try {
                    age = Integer.parseInt(data[4]);
                } catch (Exception e) {

                    email = data[4];
                }
            }

            Employee employee = new Employee(name, salary, position, department, email, age);

            Department existingDepartment = departments.stream().filter(x -> x.getName()
                    .equals(department)).findFirst().orElse(null);

            if (existingDepartment == null) {

                Department currentDepartment = new Department(department, new ArrayList<>());

                currentDepartment.addEmployee(employee);

                departments.add(currentDepartment);

            } else {

                existingDepartment.addEmployee(employee);

            }
        }

        departments = departments.stream().sorted((x1, x2) -> {

                    List<Double> avgList1 = new ArrayList<>();
                    List<Double> avgList2 = new ArrayList<>();

                    x1.getEmployees().forEach(x -> avgList1.add(x.getSalary()));
                    x2.getEmployees().forEach(x -> avgList2.add(x.getSalary()));

                    double avg1 = avgList1.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double avg2 = avgList2.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

                    return Double.compare(avg2, avg1);
                }
        ).collect(Collectors.toList());

        Department best = departments.get(0);

        System.out.printf("Highest Average Salary: %s%n", best.getName());

        best.getEmployees().stream().sorted((x1, x2) -> Double.compare(x2.getSalary(), x1.getSalary())).forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
