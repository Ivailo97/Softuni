import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Human> humans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split(" ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Human human = new Human(name,age);

            humans.add(human);
        }

        humans.stream().filter(x-> x.Age > 30).sorted(Comparator.comparing(Human::GetName)).forEach(
                y -> System.out.println(y.Name + " - " + y.Age)
        );
    }
}

class Human {

    public String Name;
    public int Age;

    public Human(String name, int age){

        this.Age = age;
        this.Name = name;
    }

    public String GetName(){

        return  Name;
    }

}
