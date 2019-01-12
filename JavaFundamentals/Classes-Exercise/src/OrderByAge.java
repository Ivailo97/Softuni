import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        while (true)
        {
            String line = scanner.nextLine();

            if (line.equals("End"))
            {
                break;
            }

            String[] data = line.split(" ");
            String name = data[0];
            String serialNumber = data[1];
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name, serialNumber, age);

            people.add(person);
        }
        people.stream().sorted(Comparator.comparing(Person::GetAge)).forEach(x ->{

            System.out.printf("%s with ID: %s is %d years old.%n",x.Name,x.SerialNumber,x.Age);
        });
    }
}

class Person
{
    public String Name;
    public String SerialNumber;
    public int Age;

    public Person(String name, String serialNumber, int age)
    {
        this.Age = age;
        this.Name = name;
        this.SerialNumber = serialNumber;
    }

    public int GetAge(){

        return Age;
    }
}
