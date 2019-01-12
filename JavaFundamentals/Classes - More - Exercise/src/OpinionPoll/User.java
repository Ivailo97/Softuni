package OpinionPoll;

public class User {

    private String name;
    private int age;

    public User(String name, int age) {

        this.age = age;
        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public  int getAge(){

        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",this.getName(),this.getAge());
    }
}
